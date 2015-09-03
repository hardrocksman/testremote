package com.zhl.test.rmi.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhl.test.rmi.core.model.UserInfo;
import com.zhl.test.rmi.core.service.IUserService;


@Controller
public class HelloController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/init")
	public ModelAndView init(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Hello World!");
		mav.setViewName("jsp/hello.jsp");
		
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getUsers")
	public List<UserInfo> getUsers(HttpServletResponse response,HttpServletRequest request){
		String userName = request.getParameter("userName");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName", userName + "%");
		List<UserInfo> userList = userService.getUser(param);
		return userList;
	}
}
