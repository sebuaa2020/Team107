package com.example.appforros;


import com.google.gson.Gson;

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
        return gson.toJson(this);
    }

}