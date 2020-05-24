package com.buaa.robot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlphaController {

    @RequestMapping("/")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot";
    }


}
