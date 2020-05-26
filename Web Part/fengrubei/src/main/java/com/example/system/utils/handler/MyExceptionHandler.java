package com.example.system.utils.handler;


import com.example.system.utils.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler{

    @ExceptionHandler(UserNotExistException.class)
    public String handle1(Exception e, HttpServletRequest request){

        request.setAttribute("javax.servlet.error.status_code",404);
        Map<String , Object> map = new HashMap<>();

        map.put("aaa","nmsl");
        map.put("aaaa",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }


}
