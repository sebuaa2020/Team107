package com.example.business.vo;

import com.example.business.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper=false)
public class ProjectVo extends Project {
    private static final long serialVersionUID = 1L;



    private Integer page=1;
    private Integer limit=10;

    private Integer[] ids;//接收多个ID


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
