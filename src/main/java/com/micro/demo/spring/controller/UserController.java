package com.micro.demo.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mapc 
 * @date 2017年5月19日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login")
	@ResponseBody
	public String doLogin(HttpServletRequest httpServletRequest) {
		Cookie[] cookies = httpServletRequest.getCookies();
		System.out.println("login..");
		return "test";
	}
}
