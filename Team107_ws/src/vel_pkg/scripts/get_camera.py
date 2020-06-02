#!/usr/bin/env python
#get camera
import rospy
from sensor_msgs.msg import Image
import cv2
from cv_bridge import CvBridge
import websocket
from PIL import Image as PILImage
import base64
import io
import json
import time
try:
    import thread
except ImportError:
    import _thread as thread


strEncode = ""
oldStrEncode = ""

def on_message(ws, message):
    #print(ws)
    print(message)
    global oldStrEncode
    if strEncode != oldStrEncode:
        s = '{"to":"android","from":"camera","type":"receive_camera","data":"'+strEncode+'"}'
        oldStrEncode = strEncode
        ws.send(s)


def on_error(ws, error):
    #print(ws)
    print(error)


def on_close(ws):
    #print(ws)
    print("### closed ###")

ws = websocket.WebSocketApp("ws://134.175.14.15:8080/demo/websocket/4",
                            on_message=on_message,
                            on_error=on_error,
                            on_close=on_close)


def carama_callback(imgmsg):
    bridge = CvBridge()
    img = bridge.imgmsg_to_cv2(imgmsg, "bgr8")

    img = PILImage.fromarray(cv2.cvtColor(img,cv2.COLOR_BGR2RGB))
    img = img.resize((150,150))
    img = img.convert('L')
    
    #img.save('2.png','png')
    
    imgByteArr = io.BytesIO()
    img.save(imgByteArr, format='PNG')
    imgByteArr = imgByteArr.getvalue()
    global strEncode
    strEncode = base64.b64encode(imgByteArr)

    #print(strEncode)
    
    rospy.sleep(10.)
#   add code here
#    ws.send()
#   cv2.imwrite("1.png", img)
#    cv2.waitKey(3)
    
def carama_listener():
    # In ROS, nodes are uniquely named. If two nodes with the same
    # node are launched, the previous one is kicked off. The
    # anonymous=True flag means that rospy will choose a unique
    # name for our 'listener' node so that multiple listeners can
    # run simultaneously.
    rospy.init_node('listener', anonymous=True)
    rospy.Subscriber("/camera/rgb/image_raw", Image, carama_callback)
    # spin() simply keeps python from exiting until this node is stopped
    rospy.spin()


if __name__ == '__main__':
    thread.start_new_thread(ws.run_forever, ())
    carama_listener()