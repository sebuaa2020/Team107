package com.example.appforros;

import android.content.Context;
import android.content.Intent;
import android.telephony.mbms.MbmsErrors;
import android.util.AndroidException;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

public class Robot {
    private int robot_id = 0;
    private long robot_ip;
    private String form_ip;
    private Socket socket;
    private String uri = "ws://134.175.14.15:8080/demo/websocket/1";
    private String recvMsg = null;
    private WebClient webClient;
    private Context context;
    private String map;
    private final String FROM = "android";
    private final String TO = "robot";
    private final String TO_MAP = "map";
    private final String DIRECTION = "direction";
    private final String MAP_BEGIN = "map_begin";
    private final String MAP_END =  "map_end";
    private final String MAP_REFRESH = "map_refresh";
    private final String ANGLE = "angle_speed";
    private final String SEND_DES = "send_des";
    private final String SEND_STOP = "stop";

    public Robot() {

    }

    public Robot(int robot_id, long robot_ip, String form_ip, Context context) {
        this.robot_id = robot_id;
        this.form_ip = form_ip;
        this.robot_ip = robot_ip;
        this.context = context;
        try {
            webClient = new WebClient(new URI(uri), context);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
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

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    /**检查连接情况
     */
    public boolean sendHello() {
        Message msg = new Message(FROM, TO, "hello", "hello");
        //System.out.println("webclient");
        sendMessage(msg);
        //sendMessage("hello");
        return true;
    }

    public void sendStop() {
        Message msg = new Message(FROM, TO, SEND_STOP, SEND_STOP);
        sendMessage(msg);
    }

    /**方向控制
     */
    public void move(String direction) {
        Message msg = new Message(FROM, TO, DIRECTION, direction);
        sendMessage(msg);
        //sendMessage(direction);
    }

    public void sendAngle(String angle) {
        Message msg = new Message(FROM, TO, ANGLE, angle);
        sendMessage(msg);
    }

    public void map_begin() {
        Message msg = new Message(FROM, TO, MAP_BEGIN, MAP_BEGIN);
        sendMessage(msg);
    }

    public void map_end() {
        Message msg = new Message(FROM, TO, MAP_END, MAP_END);
        sendMessage(msg);
    }

    /**更新地图
     */
    public void refresh_map() {
        Message msg = new Message(FROM, TO_MAP, MAP_REFRESH, MAP_REFRESH);
        sendMessage(msg);
    }

    /**发送导航点坐标
     */
    public void send_des(String des) {
        Message msg = new Message(FROM, TO, SEND_DES, des);
        sendMessage(msg);
    }

    private void sendMessage(Message msg) {
        webClient.send(msg.MessageToJson());
        //System.out.println("send" + Msg.toString());
    }

    private void sendMessage(String msg) {
        webClient.send(msg);
    }

}