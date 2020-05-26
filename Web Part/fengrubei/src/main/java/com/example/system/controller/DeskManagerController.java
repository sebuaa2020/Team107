package com.example.system.controller;

import com.example.system.utils.common.JSON.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeskManagerController {


    @RequestMapping("loadAllBackData")
    public JSONResult loadAllBackData(){

        return JSONResult.ok(null);
    }
}
