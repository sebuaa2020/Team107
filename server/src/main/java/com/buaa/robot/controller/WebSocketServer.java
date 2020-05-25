package com.buaa.robot.controller;
import com.buaa.robot.handle.MessageReceiveHandle;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/websocket/{vmcNo}") // 客户端URI访问的路径
@Component
public class WebSocketServer {
    /** 保存所有连接的webSocket实体
     * CopyOnWriteArrayList使用了一种叫写时复制的方法，
     * 当有新元素添加到CopyOnWriteArrayList时，
     * 先从原有的数组中拷贝一份出来，然后在新的数组做写操作，
     * 写完之后，再将原来的数组引用指向到新数组。
     * 具备线程安全，并且适用于高并发场景
     */
    private static CopyOnWriteArrayList<WebSocketServer> sWebSocketServers = new CopyOnWriteArrayList<>();
    private Session mSession; // 与客户端连接的会话，用于发送数据
    private long mVmcNo; // 客户端的标识(这里以机器编号)
    private Log mLog = LogFactory.getLog(WebSocketServer.class);
    private MessageReceiveHandle mRH = new MessageReceiveHandle();

    public static CopyOnWriteArrayList<WebSocketServer> getsWebSocketServers() {
        return sWebSocketServers;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("vmcNo") long vmcNo){
        mSession = session;
        sWebSocketServers.add(this); // 将回话保存
        mLog.info("-->onOpen new connect vmcNo is "+vmcNo);
        mVmcNo = vmcNo;
    }

    @OnClose
    public void onClose(){
        sWebSocketServers.remove(this);
        mLog.info("-->onClose a connect");
    }

    @OnMessage
    public void onMessage(String message){
        mLog.info("-->onMessage: "+message);
        mRH.messageReceiveHandle(message);
    }

    /** 对当前机器发送发送消息
     * @param message 信息
     */
    public boolean sendMessage(String message){
        try {
            mSession.getBasicRemote().sendText(message);
        } catch (IOException e) {
            mLog.info(e.toString());
            return false;
        }
        return true;
    }

    /** 对某个机器发送消息
     * @param message 信息
     * @param vmcNo 机器编号
     * @return true,返回发送的消息,false，返回failed字符串
     */

    public static String sendMessage(String message, long vmcNo){
        boolean success = false;
        for (WebSocketServer server : sWebSocketServers){
            if (server.mVmcNo == vmcNo){
                success = server.sendMessage(message);
                break;
            }
        }
        return success ? message : "failed";
    }
}
