package com.xiaoyulaoshishuo.app.kq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoyulaoshishuo.app.kq.mapper.UserAccountMapper;
import com.xiaoyulaoshishuo.app.kq.model.UserAccount;
import com.xiaoyulaoshishuo.app.kq.model.UserAccountExample;

/**
 * @author mapc 
 * @date 2017年6月5日
 */
@RestController
public class TestController {
	
	@Autowired
	private UserAccountMapper userAccountMapper;

	@RequestMapping("/test")
	public ResponseEntity<Object> test() {
		System.out.println("recieved request...");
		
		List<UserAccount> userAccountList = userAccountMapper.selectByExample(new UserAccountExample());
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
}
