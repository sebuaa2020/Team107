package com.example.appforros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RobotList {

    //private Map<Integer, Robot> robots = new HashMap<>();
    private int robot_count = 0;
    private int chosed_id = -1;
    private ArrayList<Robot> robots = new ArrayList<>();

    private RobotList() {

    }

    private static class RobotListHolder {
        private static RobotList robotList = new RobotList();
    }

    public void setChosed_id(int chosed_id) {
        this.chosed_id = chosed_id;
    }

    public ArrayList<Robot> getRobots() {
        return robots;
    }

    public int getChosed_id() {
        return chosed_id;
    }

    public Robot getChosed_robot() {
        for (Robot robot : robots) {
            if (robot.getRobot_id() == chosed_id) {
                return robot;
            }
        }
        return null;
    }

    public int getBigestId() {
        int id = -1;
        for (Robot robot : robots) {
            if (robot.getRobot_id() > id) {
                id = robot.getRobot_id();
            }
        }
        return id;
    }

    public int getRobot_count() {
        return robot_count;
    }

    public static RobotList getInstance() {
        return RobotListHolder.robotList;
    }

    public void addRobot(Robot robot) {
        //robots.put(robot_count++, robot);
        robots.add(robot);
    }

    public void removeRobotById(int id) {
        robots.remove(id);
    }


    public Robot getRobot() {
        if (chosed_id == -1) {
            return null;
        } else {
            return robots.get(chosed_id);
        }
    }

    public Robot getRobotById(int robot_id) {
        return robots.get(robot_id);
    }

    public int size() {
        return robots.size();
    }
}
