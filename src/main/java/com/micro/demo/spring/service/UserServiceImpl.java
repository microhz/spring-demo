package com.micro.demo.spring.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author mapc 
 * @date 2017年6月11日
 */
@Service
@Order(2)
public class UserServiceImpl implements UserService {

	public void say(String content) {
		System.out.println("impl say : " + content);
	}

}
