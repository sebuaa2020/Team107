#!/usr/bin/env python
#get map
import rospy
import cv2
import numpy as np
import base64
import PIL.Image as Image
import io
import websocket
import os

from nav_msgs.msg import OccupancyGrid
import matplotlib.pyplot as plt
import json
try:
    import thread
except ImportError:
    import _thread as thread

ws = []
cur_map = []

def on_message(ws, message):
    #print(ws)
    print("reveive" + message)
    jsonObj = json.loads(message)
    
    if jsonObj['type'] == 'map_refresh':
      map = cur_map.data
      map = np.array(map)
      
      map = map.reshape((992,992))
      print map.shape
#     datas
#      print map
      row,col = map.shape
      tem = np.zeros((row,col))
      for i in range(row):
        for j in range(col):
          if(map[i,j]==-1):
            tem[i,j]=255
          elif tem[i,j] == 0 :
            tem[i,j] = 200
          else:
            tem[i,j]= 10

      img = Image.fromarray(np.uint8(tem))
      img = img.transpose(Image.FLIP_LEFT_RIGHT)
      imgByteArr = io.BytesIO()
      img.save(imgByteArr, format='PNG')
      imgByteArr = imgByteArr.getvalue()
      
      strEncode = base64.b64encode(imgByteArr)
      
      s = '{"to":"android","from":"map","type":"map","data":"'+strEncode+'"}'
      ws.send(s)
      print('send map')
    elif jsonObj['type'] == 'send_des':
      os.system('gnome-terminal -x rosrun vel_pkg navigation '+jsonObj['data'])




def on_error(ws, error):
    #print(ws)
    print(error)


def on_close(ws):
    #print(ws)
    print("### closed ###")

ws = websocket.WebSocketApp("ws://134.175.14.15:8080/demo/websocket/3",
                            on_message=on_message,
                            on_error=on_error,
                            on_close=on_close)


class Map(object):
  def __init__(self):

    self.map_sub = rospy.Subscriber("/map",OccupancyGrid, self.map_callback)
    print self.map_sub

  def map_callback(self,mapmsg):
    try:
      print "into callback"
      
      global cur_map
      cur_map = mapmsg
      '''
      if len(map_list) != 0:
        map_list.pop()
        img = Image.fromarray(np.uint8(tem))
        imgByteArr = io.BytesIO()
        img.save(imgByteArr, format='PNG')
        imgByteArr = imgByteArr.getvalue()

        strEncode = base64.b64encode(imgByteArr)
        s = '{"to":"android","from":"robot","type":"map","data":"'+strEncode+'"}'
        ws.send(s)
        print('send map')
      '''
#      print map.shape
#      cv2.imwrite("1.png", tem)
#      cv2.imshow("map",tem)
#      cv2.waitKey(0)
#      plt.imshow(map)
#      plt.show()
    
    except Exception,e:
      print e
      rospy.loginfo('convert rgb image error')


def map_listener():
  rospy.init_node('map',anonymous=True)
  v=Map()
  rospy.spin()

if __name__=="__main__":
    thread.start_new_thread(ws.run_forever, ())
    map_listener()