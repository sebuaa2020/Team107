#!/usr/bin/env python
import rospy

from geometry_msgs.msg import Twist

import sys, select, termios, tty


msg = """
Control The Robot!
---------------------------
Moving around:
   u    i    o
   j    k    l
   m    ,    .

q/z : increase/decrease max speeds by 10%
w/x : increase/decrease only linear speed by 10%
e/c : increase/decrease only angular speed by 10%
space key, k : force stop
anything else : stop smoothly

CTRL-C to quit
"""

moveBindings = {
        'i':(1,0),
        'o':(1,-1),
        'j':(0,1),
        'l':(0,-1),
        'u':(1,1),
        ',':(-1,0),
        '.':(-1,1),
        'm':(-1,-1),
           }

speedBindings={
        'q':(1.1,1.1),
        'z':(.9,.9),
        'w':(1.1,1),
        'x':(.9,1),
        'e':(1,1.1),
        'c':(1,.9),
          }

def getKey():
    print "get_key_test_ok"
    tty.setraw(sys.stdin.fileno())
    rlist, _, _ = select.select([sys.stdin], [], [], 0.1)
    if rlist:
        key = sys.stdin.read(1)
    else:
        key = ''

    termios.tcsetattr(sys.stdin, termios.TCSADRAIN, settings)
    return key

speed = .2
turn = 1

def vels(speed,turn):
    print "vels_test_ok"
    return "currently:\tspeed %s\tturn %s " % (speed,turn)

if __name__=="__main__":
    print "main_ok"
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
        print msg
        print vels(speed,turn)
        while(1):
            print "while_test_ok"
            key = getKey()
            if key in moveBindings.keys():
                print "if_1_test_ok"
                x = moveBindings[key][0]
                th = moveBindings[key][1]
                count = 0
            elif key in speedBindings.keys():
                print "if_2_test_ok"
                speed = speed * speedBindings[key][0]
                turn = turn * speedBindings[key][1]
                count = 0

                print vels(speed,turn)
                if (status == 14):
                    print "if_2-1_test_ok"
                    print msg
                status = (status + 1) % 15
            elif key == ' ' or key == 'k' :
                print "if_3_test_ok"
                x = 0
                th = 0
                control_speed = 0
                control_turn = 0
            else:
                print "if_4_test_ok"
                count = count + 1
                if count > 4:
                    print "if_4-1_test_ok"
                    x = 0
                    th = 0
                if (key == '\x03'):
                    print "if_4-2_test_ok"
                    break

            target_speed = speed * x
            target_turn = turn * th

            if target_speed > control_speed:
                print "if_5_test_ok"
                control_speed = min( target_speed, control_speed + 0.02 )
            elif target_speed < control_speed:
                print "if_6_test_ok"
                control_speed = max( target_speed, control_speed - 0.02 )
            else:
                print "if_7_test_ok"
                control_speed = target_speed

            if target_turn > control_turn:
                print "if_8_test_ok"
                control_turn = min( target_turn, control_turn + 0.1 )
            elif target_turn < control_turn:
                print "if_9_test_ok"
                control_turn = max( target_turn, control_turn - 0.1 )
            else:
                print "if_10_test_ok"
                control_turn = target_turn

            twist = Twist()
            twist.linear.x = control_speed; twist.linear.y = 0; twist.linear.z = 0
            twist.angular.x = 0; twist.angular.y = 0; twist.angular.z = control_turn
            pub.publish(twist)

            #print("loop: {0}".format(count))
            #print("target: vx: {0}, wz: {1}".format(target_speed, target_turn))
            #print("publihsed: vx: {0}, wz: {1}".format(twist.linear.x, twist.angular.z))

    except:
        print "except_test_ok"
        print e

    finally:
        print "finally_test_ok"
        twist = Twist()
        twist.linear.x = 0; twist.linear.y = 0; twist.linear.z = 0
        twist.angular.x = 0; twist.angular.y = 0; twist.angular.z = 0
        pub.publish(twist)

    termios.tcsetattr(sys.stdin, termios.TCSADRAIN, settings)
