package com.micro.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mapc 
 * @date 2017年5月19日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login")
	public void doLogin() {
		System.out.println("login..");
	}
}
