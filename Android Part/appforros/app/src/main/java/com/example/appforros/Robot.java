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
    //private String map;
    private String map = "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";
    private String camera = "";
    private String des = "0 0";
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

    public String getDes() {
        return des;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public void setDes(String des) {
        this.des = des;
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