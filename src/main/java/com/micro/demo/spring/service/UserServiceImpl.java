package com.micro.demo.spring.service;

import org.springframework.stereotype.Service;

/**
 * @author mapc 
 * @date 2017年6月11日
 */
@Service
public class UserServiceImpl implements UserService {

	public void say(String content) {
		System.out.println("impl say : " + content);
	}

}
