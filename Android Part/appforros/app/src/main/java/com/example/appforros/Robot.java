package com.example.appforros;

import android.content.Context;
import android.content.Intent;
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
    private String recvMsg = null;
    private WebClient webClient;
    private Context context;

    public Robot() {

    }

    public Robot(int robot_id, long robot_ip, String form_ip, Context context) {
        this.robot_id = robot_id;
        this.form_ip = form_ip;
        this.robot_ip = robot_ip;
        this.context = context;
        try {
            webClient = new WebClient(new URI(form_ip), context);
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
        sendMessage("hello");
        //while (sendMessage("hello") == null) {
            //等待收到应答确保发送完成
        //}
        return true;
    }

    /**方向控制
     */
    public void move(String direction) {
        sendMessage(direction);
        //while (sendMessage(direction) == null) {
            //等待收到应答确保发送完成
        //}
    }

    /**更新地图
     */
    public void refresh_map() {
        sendMessage("refresh map");
        Intent intent = new Intent();
        intent.setAction("com");
        intent.putExtra("message", "test");
        System.out.println("send");
        context.sendBroadcast(intent);
        //while (sendMessage("refresh map") == null) {

        //}
    }

    /**发送导航点坐标
     */
    public void send_des(String des) {
        sendMessage(des);
        //while (sendMessage(des) == null) {

        //}
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

    private void sendMessage(String Msg) {
        //webClient.send(Msg);
    }

}
