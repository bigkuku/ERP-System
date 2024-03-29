package com.bx.sys.controller;


import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bx.sys.common.ActiverUser;
import com.bx.sys.common.ResultObj;
import com.bx.sys.common.WebUtils;
import com.bx.sys.domain.Loginfo;
import com.bx.sys.service.LoginfoService;

/**
 * <p>
 *  登陆前端控制器
 * </p>
 *
 * @author bx
 */
@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private LoginfoService loginfoService;
	
	@RequestMapping("login")
	public ResultObj login(String loginname,String pwd) {
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token=new UsernamePasswordToken(loginname, pwd);
		try {
			subject.login(token);
			ActiverUser activerUser=(ActiverUser) subject.getPrincipal();
			WebUtils.getSession().setAttribute("user", activerUser.getUser());
			//记录登陆日志
			Loginfo entity=new Loginfo();
			entity.setLoginname(activerUser.getUser().getName()+"-"+activerUser.getUser().getLoginname());
			entity.setLoginip(WebUtils.getRequest().getRemoteAddr());
			entity.setLogintime(new Date());
			loginfoService.save(entity);
			return ResultObj.LOGIN_SUCCESS;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return ResultObj.LOGIN_ERROR_PASS;
		}
	}
}

