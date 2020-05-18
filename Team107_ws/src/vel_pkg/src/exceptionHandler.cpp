#include <ros/ros.h>
#include <iostream>


#define WAYPOINT_NOT_EXIST_EXP  		0
#define FAIL_TO_WAYPOINT_EXP    		1
#define MASTER_NOT_EXIST_EXP    		2
#define FAIL_TO_MASTER_EXP      		3
#define FOLLOW_START_EXP        		4
#define FOLLOW_STOP_EXP         		5
#define VOICE_NOT_GET_TRANSFORM_EXP 	6
#define GRAB_FAIL				7



void ExpHandler(int expNum){
    switch(expNum){

        case(WAYPOINT_NOT_EXIST_EXP):
            ROS_ERROR("Failed to call service GetWaypointByName");
            break;

        case(FAIL_TO_WAYPOINT_EXP):
            ROS_INFO("Failed to get to ..." );
            break;

        case(MASTER_NOT_EXIST_EXP):
            ROS_ERROR("Failed to call service GetWaypointByName");
            break;


        case(FAIL_TO_MASTER_EXP):
            ROS_INFO("Failed to get to  ...");
            break;
            
        case(FOLLOW_START_EXP)://跟随启动失败
            ROS_WARN("[CActionManager] - follow start failed...");
            break;
            
        case(FOLLOW_STOP_EXP)://跟随终止失败
            ROS_WARN("[CActionManager] - failed to stop following...");
            break;

        case(GRAB_FAIL):
            ROS_ERROR("Failed to grab something");
            break;
            
        default: ;
    }
}

int main(int argc, char** argv)
{
    ros::init(argc,argv,"exceptionHandler");
    
    ROS_INFO("exceptionHandler start!");

    int flag;
    std::cin >> flag;

    ExpHandler(flag);
    
}