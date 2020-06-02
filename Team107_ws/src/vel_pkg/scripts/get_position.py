#! /usr/bin/env python
#coding=utf-8
import rospy
from geometry_msgs.msg import PoseWithCovarianceStamped,PoseStamped
import websocket
import time
try:
    import thread
except ImportError:
    import _thread as thread

def on_message(ws, message):
    #print(ws)
    print("reveive" + message)


def on_error(ws, error):
    #print(ws)
    print(error)


def on_close(ws):
    #print(ws)
    print("### closed ###")

ws = websocket.WebSocketApp("ws://134.175.14.15:8080/demo/websocket/5",
                            on_message=on_message,
                            on_error=on_error,
                            on_close=on_close)
x = 0.0
y = 0.0
def PoseCallBack(msg):
	#订阅到的坐标信息
    global x,y

    x = msg.pose.pose.position.x
    y = msg.pose.pose.position.y
    x = x * -1.68
    y = -1.73*(y+10.5)

def PoseSub():
	rospy.init_node('pose_sub',anonymous=False)
	#监控话题，并在回调函数中处理
	rospy.Subscriber('/amcl_pose',PoseWithCovarianceStamped,PoseCallBack)
	rospy.spin()



def on_open(ws):
    def run(*args):

        while True:
            time.sleep(0.2)
            #print(data) 
            global x,y
            
            s = '{"to":"android","from":"robot","type":"receive_des","data":"'+str(x)+" "+str(y)+'"}'
            print(s)
            ws.send(s)
    thread.start_new_thread(run, ())


if __name__=='__main__':
    ws.on_open = on_open
    thread.start_new_thread(ws.run_forever, ())
    PoseSub()
