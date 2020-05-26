package com.example.system.controller;


import com.example.system.utils.common.JSON.JSONResult;
import com.example.system.utils.common.ActiveUser;
import com.example.system.utils.common.WebUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.system.utils.common.ConstantUtils.USER_SESSION_KEY;

//import com.sxt.sys.common.ActiverUser;
//import com.sxt.sys.common.ResultObj;
//import com.sxt.sys.common.WebUtils;
//import com.sxt.sys.domain.Loginfo;
//import com.sxt.sys.service.LoginfoService;

/**
 * <p>
 *  登陆前端控制器
 * </p>
 *
 * @author 老雷
 * @since 2019-09-20
 */
@RestController
@RequestMapping("login")
public class LoginController {


	@RequestMapping("login")
	public JSONResult login(String loginname, String pwd) {
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(loginname, pwd);
		try {
			subject.login(token);
			ActiveUser activeUser=(ActiveUser) subject.getPrincipal();
			WebUtils.getSession().setAttribute(USER_SESSION_KEY, activeUser.getUser());

			return JSONResult.ok();
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return JSONResult.errorMsg("登陆出现异常");
		}
	}
}

