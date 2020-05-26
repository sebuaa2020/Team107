package com.example.system.vo;

import java.util.Date;

import com.example.system.entity.Loginlog;
import org.springframework.format.annotation.DateTimeFormat;



import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class LoginlogVo extends Loginlog
{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer page=1;//当前页
	private Integer limit=10;//每页个数
	
	private Integer[] ids;//接收多个ID
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
}
