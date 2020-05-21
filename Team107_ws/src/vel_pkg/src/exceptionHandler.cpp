#include <ros/ros.h>
#include <iostream>


#define WAYPOINT_NOT_EXIST_EXP  		0
#define FAIL_TO_WAYPOINT_EXP    		1
#define OBSTACLE_EXP                    2
#define FAIL_TO_GEN_PATH                3
#define FAIL_TO_NAI                     4



void ExpHandler(int expNum){
    switch(expNum){

        case(WAYPOINT_NOT_EXIST_EXP):
            ROS_ERROR("Failed to call service");
            break;

        case(FAIL_TO_WAYPOINT_EXP):
            ROS_INFO("Failed to get to ..." );
            break;

        case(OBSTACLE_EXP):
            ROS_INFO("Meeting Obstacle");
            break;


        case(FAIL_TO_GEN_PATH):
            ROS_INFO("Failed to get path to  ...");
            break;
            
        case(FAIL_TO_NAI):
            ROS_WARN("Navigation failed...");
            break;
            
        default: ;
    }
}

int main(int argc, char** argv)
{
    ros::init(argc,argv,"exceptionHandler");
    
    ROS_INFO("exceptionHandler start!");
    // 暂时未写具体异常处理
    int flag;
    std::cin >> flag;

    ExpHandler(flag);
    
}
