src					
├robot_sim_demo             //模拟器
├─test		       //测试文件
│  └─src
└─vel_pkg		       //主要的c++代码
├─bash		       //命令行接口
├─launch
│  └─include
├─maps			//保存的地图
├─param			//movebase的参数
├─rviz			
├─scripts			//主要的python代码


c++代码：
MainController.cpp             //主控制器
navigation_interface.cpp       //导航接口


python代码：
get_camera.py
get_map.py			
get_position.py			//获取当前摄像机、地图信息、机器人位置，传递给前端

robot_keyboard_teleop.py        //手动控制节点

telecontroller.py
teleoperation.py
teleoperation_angle.py          //前端控制机器人相关程序