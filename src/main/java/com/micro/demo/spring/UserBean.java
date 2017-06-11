package com.micro.demo.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author mapc 
 * @date 2017年6月6日
 */
@Component("userBean")
public class UserBean {
	@Value("7")
	private int status = 0;
	public void test() {
		System.out.println("user service test executed!! status = " + status);
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
