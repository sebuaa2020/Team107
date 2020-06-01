package com.buaa.robot.handle;
import com.buaa.robot.controller.WebSocketServer;
import com.buaa.robot.message.Message;
import com.google.gson.Gson;

import java.util.HashMap;


public class MessageReceiveHandle {
    private Gson gson = new Gson();
    private static HashMap<String,Integer> addressMap = new HashMap<String,Integer>();
    public MessageReceiveHandle(){
        addressMap.put("camera",4);
        addressMap.put("map",3);
        addressMap.put("robot",2);
        addressMap.put("android",1);
        addressMap.put("server",0);
    }
    public void messageReceiveHandle(String message) {
        Message msg = null;
        try{
            msg = gson.fromJson(message,Message.class);
        }catch (Exception e){
            System.out.println("Not json format");
            return;
        }

        try{
            if (addressMap.get(msg.getFrom()) != 0){
                WebSocketServer.sendMessage(message, addressMap.get(msg.getFrom()));
            }

            if (addressMap.get(msg.getTo()) != 0){
                WebSocketServer.sendMessage(message, addressMap.get(msg.getTo()));
            }
        } catch (Exception e){
            System.out.println("Unknown destination");
        }

    }
}
