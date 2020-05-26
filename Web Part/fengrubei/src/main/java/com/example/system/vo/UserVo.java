package com.example.system.vo;

import com.example.system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserVo extends User {
    private static final long serialVersionUID = 1L;


    private Integer page=1;
    private Integer limit=10;

    private Integer[] ids;//接收多个ID


}
