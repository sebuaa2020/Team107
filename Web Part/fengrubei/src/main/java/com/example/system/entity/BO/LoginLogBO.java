package com.example.system.entity.BO;


import com.example.system.entity.Loginlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginLogBO {
    private Integer id;

    private String loginname;

    private String loginip;

    private Date logintime;

    public static List<LoginLogBO> LoginLogTOJSON(List<Loginlog> records){
        List<LoginLogBO> list = new ArrayList<>();
        for(Loginlog record:records){
            list.add(new LoginLogBO(record.getId(),record.getLoginname(),record.getLoginip(),record.getLogintime()));
        }
        return list;
    }
}
