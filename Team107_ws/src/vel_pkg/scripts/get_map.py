#!/usr/bin/env python

import rospy
import cv2
import numpy as np

from nav_msgs.msg import OccupancyGrid
import matplotlib.pyplot as plt

class Map(object):
  def __init__(self):

    self.map_sub = rospy.Subscriber("/map",OccupancyGrid, self.callback)
    print self.map_sub

  def callback(self,mapmsg):
    try:
      print "into callback"
      map = mapmsg.data
      map = np.array(map)
      print map.shape
      map = map.reshape((992,992))
#     datas
      print map
      row,col = map.shape
      tem = np.zeros((row,col))
      for i in range(row):
        for j in range(col):
          if(map[i,j]==-1):
             tem[i,j]=255
          else:
             tem[i,j]=map[i,j]
#      print map.shape
      cv2.imshow("map",tem)
      cv2.waitKey(0)
#      plt.imshow(map)
#      plt.show()
    
    except Exception,e:
      print e
      rospy.loginfo('convert rgb image error')

  def getImage():
    return self.rgb_image

def main(_):
  rospy.init_node('map',anonymous=True)
  v=Map()
  rospy.spin()

if __name__=='__main__':
  main('_')
