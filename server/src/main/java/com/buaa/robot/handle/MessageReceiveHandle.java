package com.buaa.robot.handle;
import com.buaa.robot.controller.WebSocketServer;
import com.buaa.robot.message.Message;
import com.google.gson.Gson;

import java.util.HashMap;


public class MessageReceiveHandle {
    private Gson gson = new Gson();
    private static HashMap<String,Integer> addressMap = new HashMap<String,Integer>();
    public MessageReceiveHandle(){
        addressMap.put("robot",2);
        addressMap.put("android",1);

    }
    public void messageReceiveHandle(String message) {
        Message msg = gson.fromJson(message,Message.class);
        WebSocketServer.sendMessage("i have rcv you message: " + message,
                addressMap.get(msg.getFrom()));
        WebSocketServer.sendMessage(message,addressMap.get(msg.getTo()));
    }
}
