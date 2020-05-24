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
    private final String REPLY_MESSAGE = "reply"; //机器人确认信息
    private Context mContext;
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
        if (!message.isEmpty()){
            Intent intent = new Intent();
            if (message == REPLY_MESSAGE) {
                //检查message类型，发送不同广播
                intent.setAction(REPLY_MESSAGE);
                intent.putExtra(REPLY_MESSAGE,message);
            } else if (message == MAP_MESSAGE) {
                intent.setAction(MAP_MESSAGE);
                intent.putExtra(MAP_MESSAGE,message);
            } else {
                intent.setAction(REPLY_MESSAGE);
                intent.putExtra(REPLY_MESSAGE,message);
            }

            showLog("发送收到的消息");
            mContext.sendBroadcast(intent);
        }
    }
}
