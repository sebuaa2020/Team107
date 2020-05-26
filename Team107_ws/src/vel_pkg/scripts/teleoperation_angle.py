#!/usr/bin/env python
import rospy

from geometry_msgs.msg import Twist

import sys, select, termios, tty
import websocket
import json
import math

try:
    import thread
except ImportError:
    import _thread as thread



key_list = []

def on_message(ws, message):
    #print(ws)
    print("reveive" + message)
    jsonObj = json.loads(message)
    if jsonObj['type'] == 'angle_speed':
        key_list.append(jsonObj['data'])

def on_error(ws, error):
    #print(ws)
    print(error)


def on_close(ws):
    #print(ws)
    print("### closed ###")


ws = websocket.WebSocketApp("ws://134.175.14.15:8080/demo/websocket/2",
                            on_message=on_message,
                            on_error=on_error,
                            on_close=on_close)


thread.start_new_thread(ws.run_forever, ())


msg = """
Remote Control The Robot!
"""


def getKey():
    if len(key_list) == 0:
        key = ''
    else:
        key = key_list.pop()
        key = key.split(" ")     
    return key

speed = .2
turn = 1

def vels(speed,turn):
    return "currently:\tspeed %s\tturn %s " % (speed,turn)

if __name__=="__main__":
    settings = termios.tcgetattr(sys.stdin)
    
    rospy.init_node('robot_teleop')
    pub = rospy.Publisher('/cmd_vel_mux/input/teleop', Twist, queue_size=5)

    x = 0
    th = 0
    status = 0
    count = 0
    acc = 0.1
    target_speed = 0
    target_turn = 0
    control_speed = 0
    control_turn = 0
    try:
        print(msg)
        print(vels(speed,turn))
        while(1):

            key = getKey()
            
            if key != '':
                ang = float(key[0])
                base = 1
                if 0 <= ang and ang < 90:
                    base = -1
                    th = -math.cos(math.radians(ang))
                elif 90 <= ang and ang < 180:
                    base = -1
                    th = -math.cos(math.radians(ang))
                elif 180 <= ang and ang < 270:
                    base = 1
                    th = -math.cos(math.radians(ang))
                elif 270 <= ang and ang < 360:
                    base = 1
                    th = -math.cos(math.radians(ang))

                x = float(key[1]) * 2 * base
                
                count = 0
            else:
                count = count + 1
                if count > 10000:
                    x = 0
                    th = 0
                if (key == '\x03'):
                    break

            target_speed = speed * x
            target_turn = turn * th


            if target_speed > control_speed:
                control_speed = min( target_speed, control_speed + 0.02 )
            elif target_speed < control_speed:
                control_speed = max( target_speed, control_speed - 0.02 )
            else:
                control_speed = target_speed

            if target_turn > control_turn:
                control_turn = min( target_turn, control_turn + 0.1 )
            elif target_turn < control_turn:
                control_turn = max( target_turn, control_turn - 0.1 )
            else:
                control_turn = target_turn

            twist = Twist()
            twist.linear.x = control_speed; twist.linear.y = 0; twist.linear.z = 0
            twist.angular.x = 0; twist.angular.y = 0; twist.angular.z = control_turn
            pub.publish(twist)

            #print("loop: {0}".fsource ./devel/setup.bashormat(count))
            #print("target: vx: {0}, wz: {1}".format(target_speed, target_turn))
            #print("publihsed: vx: {0}, wz: {1}".format(twist.linear.x, twist.angular.z))
    except:
        print("exception")

    finally:
        twist = Twist()
        twist.linear.x = 0; twist.linear.y = 0; twist.linear.z = 0
        twist.angular.x = 0; twist.angular.y = 0; twist.angular.z = 0
        pub.publish(twist)

    termios.tcsetattr(sys.stdin, termios.TCSADRAIN, settings)
