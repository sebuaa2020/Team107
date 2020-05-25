package com.example.appforros;

import android.content.Context;
import android.content.Intent;
import android.telephony.mbms.MbmsErrors;
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
    private final String FROM = "android";
    private final String TO = "server";
    private final String DIRECTION = "direction";
    private final String REFRESH_MAP = "refresh_map";
    private final String SEND_DES = "send_des";

    public Robot() {

    }

    public Robot(int robot_id, long robot_ip, String form_ip, Context context) {
        this.robot_id = robot_id;
        this.form_ip = form_ip;
        this.robot_ip = robot_ip;
        this.context = context;
        try {
            System.out.println("opentest");
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

    /**检查连接情况
     */
    public boolean sendHello() {
        Message msg = new Message(FROM, TO, "hello", "hello");
        sendMessage(msg);
        return true;
    }

    /**方向控制
     */
    public void move(String direction) {
        Message msg = new Message(FROM, TO, DIRECTION, direction);
        sendMessage(msg);
    }

    /**更新地图
     */
    public void refresh_map() {
        Message msg = new Message(FROM, TO, REFRESH_MAP, REFRESH_MAP);
        sendMessage(msg);
        /**广播功能测试

        Intent intent = new Intent();
        intent.setAction("map");
        intent.putExtra("map", "test");
        System.out.println("send");
        context.sendBroadcast(intent);

         */
    }

    /**发送导航点坐标
     */
    public void send_des(String des) {
        Message msg = new Message(FROM, TO, SEND_DES, des);
        sendMessage(msg);
    }

    /*
    private String sendMessage (final String Msg){

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    socket = new Socket(form_ip, 12574);

                    //向服务器发送数据
                    PrintWriter send = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8")));
                    send.println(Msg);
                    send.flush();

                    //接受服务端数据
                    BufferedReader recv = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    recvMsg = recv.readLine();
                    if (recvMsg != null) {
//                          mRecvText.setText(recvMsg);
                        System.out.println(recvMsg);
                    } else {
//                          mRecvText.setText("Cannot receive data correctly.");
                    }

                    send.close();
                    recv.close();
                    socket.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }).start();
        return recvMsg;
    }*/

    private void sendMessage(Message msg) {
        webClient.send(msg.MessageToJson());
        //System.out.println("send" + Msg.toString());
    }

}
