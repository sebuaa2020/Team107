package com.example.appforros;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class WebClient extends WebSocketClient{
    private final String MAP_MESSAGE = "map"; //地图信息
    private final String HELLO_MESSAGE = "hello"; //机器人确认信息
    private final String RECEIVE_DES = "receive_des";
    private Context mContext;
    private RobotList robotList = RobotList.getInstance();
    private Robot robot;
    /**
     *  路径为ws+服务器地址+服务器端设置的子路径+参数（这里对应服务器端机器编号为参数）
     *  如果服务器端为https的，则前缀的ws则变为wss
     */
    //private static String mAddress = "ws://服务器地址：端口/mhwang7758/websocket/";
    private void showLog(String msg){
        Log.d("WebClient---->", msg);
    }

    public WebClient(URI serverUri, Context context){
        super(serverUri, new Draft_6455());
        mContext = context;
        showLog("WebClient");
        try {
            connectBlocking();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        showLog("open->"+handshakedata.toString());
    }

    @Override
    public void onMessage(String message) {
        showLog("onMessage->"+message);
        sendMessageBroadcast(message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        showLog("onClose->"+reason);
    }

    @Override
    public void onError(Exception ex) {
        showLog("onError->"+ex.toString());
    }


    /** 初始化
     * @param vmc_no
     */
    /*
    public static void initWebSocket(final long vmc_no, String address){
        mAddress = address;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mWebClient = new WebClient(new URI(mAddress+vmc_no));
                    try {
                        mWebClient.connectBlocking();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    */
    /** 发送消息广播
     * @param message
     */
    private void sendMessageBroadcast(String message){
        //String map = "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";
        if (!message.isEmpty()){
            Message msg_as_json = new Message(message);
            System.out.println("webclient: " + msg_as_json.getType());
            Intent intent = new Intent();
            if (msg_as_json.getType().equals(HELLO_MESSAGE)) {
                intent.setAction(HELLO_MESSAGE);
                intent.putExtra(HELLO_MESSAGE,msg_as_json.getData());
            } else if (msg_as_json.getType().equals(MAP_MESSAGE)) {
                intent.setAction(MAP_MESSAGE);
                intent.putExtra(MAP_MESSAGE,msg_as_json.getData());
                if (robotList.getChosed_id() != -1) {
                    robot = robotList.getChosed_robot();
                    //System.out.println("webclient image");
                    robot.setMap(msg_as_json.getData());
                }
            } else if (msg_as_json.getType().equals(RECEIVE_DES)) {
                intent.setAction(RECEIVE_DES);
                intent.putExtra(RECEIVE_DES, msg_as_json.getData());
                if (robotList.getChosed_id() != -1) {
                    robot = robotList.getChosed_robot();
                    //System.out.println("webclient image");
                    robot.setDes(msg_as_json.getData());
                }
            } else {
                intent.setAction("other");
                intent.putExtra("other",msg_as_json.getData());
            }

            showLog("发送收到的消息");
            mContext.sendBroadcast(intent);
        }
    }
}
