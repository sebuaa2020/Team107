package com.buaa.robot.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @RequestMapping(value = "/operation/{vmc}/{cmd}")
    public String remote(@PathVariable("vmc") long vmc, @PathVariable("cmd") String cmd){
        System.out.print("remote");
        String message = cmd;
        System.out.println("message in json is :"+ cmd);
        return WebSocketServer.sendMessage(message,vmc);
    }

    @RequestMapping(value = "/test")
    public String test(){
        System.out.print("test");
        return "hello world";
    }
}
