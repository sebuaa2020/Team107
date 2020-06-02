#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fstream>
#include <iostream>
#include <sys/types.h>
#include <signal.h>
#include <cstring>
#include <sstream>
#include <string>

using namespace std;


//STATE
bool robot_start = false;
bool navigation_start = false;
bool gmapping_start = false;
bool keyboard_controll_start = false;

void start_robot() {
    int ret;
    ret = system("gnome-terminal -x roslaunch robot_sim_demo robot_spawn.launch");
    if (ret != -1 || ret != 127) {
        cout << "robot_start" << endl;
        robot_start = true;
    } else {
        throw "command execute error";
    }
}


void navigation() {
    int ret;
    ret = system("gnome-terminal -x roslaunch vel_pkg navigation.launch");
    if (ret != -1 || ret != 127) {
        cout << "navi_service_start" << endl;
    } else {
        throw "command execute error";
    }
}

void set_navi_point(string x,string y) {
    string str = "gnome-terminal -x rosrun vel_pkg navigation " + x + " "+ y;
    char * strc = new char[strlen(str.c_str()) + 1];
    strcpy(strc, str.c_str());
    int ret = system(strc);
    if (ret != -1 || ret != 127) {
        cout << "start_move" << endl;
    } else {
        throw "command execute error";
    }
}


void gmapping(){
    int ret;
    ret = system("gnome-terminal -x roslaunch vel_pkg gmapping.launch");
    if (ret != -1 || ret != 127) {
        cout << "gmapping_start,please use keyboard to controll" << endl;
        gmapping_start = true;
    } else {
        throw "command execute error";
    }
}

void save_map(){
    int ret;
    ret = system("rosrun map_server map_saver -f  ~/Desktop/map");
    if (ret != -1 || ret != 127) {
        cout << "map saved" << endl;
    } else {
        throw "command execute error";
    }
}

void keyboard_controll() {
    int ret;
    ret = system("gnome-terminal -x rosrun vel_pkg robot_keyboard_teleop.py");
    if (ret != -1 || ret != 127) {
        cout << "RVIZ可视化界面已启动" << endl;
    } else {
        throw "command execute error";
      }
}




int main() {
    while(true){
        cout << "input instruction" << endl;
        cout << "0:  start_robot" << endl;
        cout << "1:  keyboard_controll" << endl;
        cout << "2:  start_navigation" << endl;
        cout << "3:  set_navi_point" << endl;
        cout << "4:  start_gmapping" << endl;
        cout << "5:  save_map" << endl;
        int flag;
        cin >> flag;
        if(flag == 0) {
            if(robot_start){
                cout << "already start!" << endl;
            }
            else 
                start_robot();
        }
        else if(flag == 1) {
            keyboard_controll();
        }
        else if (flag == 2) {
            navigation();
        }
        else if(flag == 3) {
            cout << "please input where you want to go" << endl;
            string x,y;
            cin >> x;
            cin >> y;
            set_navi_point(x,y);
        }
        else if (flag ==4) {
                gmapping();
        }
        else if(flag == 5) {
            if(!gmapping_start)
                cout << "please start gmapping first" << endl;
            else 
                save_map();
        }
        else {
            cout << "please input right command!" << endl;
        }
    }
    return 0;
}