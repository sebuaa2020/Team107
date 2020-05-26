package com.example.appforros;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Message {
    private String from;
    private String to;
    private String type;
    private String data;

    public Message(String from, String to, String type, String data){
        this.from = from;
        this.to = to;
        this.type = type;
        this.data = data;
    }

    public Message(String msg) {
        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(gson.toJson(this), JsonObject.class);
        from = obj.get("from").toString();
        to = obj.get("to").toString();
        type = obj.get("type").toString();
        data = obj.get("data").toString();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public String MessageToJson() {
        Gson gson = new Gson();
        //JsonObject obj = gson.fromJson(gson.toJson(this), JsonObject.class);
        //System.out.println(obj.get("from"));
        //System.out.println(gson.toJson(this));
        return gson.toJson(this);
    }

}