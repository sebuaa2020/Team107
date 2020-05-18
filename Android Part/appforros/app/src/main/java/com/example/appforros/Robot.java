package com.example.appforros;

public class Robot {
    private int robot_id = 0;
    private long robot_ip;
    private String form_ip;

    public Robot() {

    }

    public Robot(int robot_id, long robot_ip,String form_ip) {
        this.robot_id = robot_id;
        this.form_ip = form_ip;
        this.robot_ip = robot_ip;
    }

    public int getRobot_id() {
        return robot_id;
    }

    public long getRobot_ip() {
        return robot_ip;
    }

    public String getForm_ip() {
        return form_ip;
    }

    public void move(String direction) {
        if (direction == "forward") {

        } else if (direction  == "turnleft") {

        } else if (direction == "turnright") {

        } else if (direction == "backoff") {

        } else {

        }
    }

}
