package com.micro.demo.spring;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.micro.demo.spring.service.UserService;

/**
 * @author mapc
 * @date 2017年6月10日
 */
@Configuration
@ImportResource("classpath:*.xml")
public class ConfigBeanDefined {
	
	@Autowired
	private List<UserService> userServiceList;
	
	@Autowired
	private UserBean userBean;
	
	// 配置Bean的方式有三种，第一种是xml方式,第二种注解的方式，但是注解怎么初始化属性可以采用代码配置的方式
	@Bean
	public User user() {
		User user = new User();
		user.setName("micro");
		user.setPassword("test_micro");
		return user;
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("post method..");
		userBean.test();
	}
	
	@PostConstruct
	public void testService() {
		// 注入多个
		for (UserService userService : userServiceList) {
			userService.say(" hello...");
		}
	}
	
	public static void main(String[] args) {
		AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
		annotationConfigWebApplicationContext.setConfigLocation("com.micro.demo.spring");
		annotationConfigWebApplicationContext.refresh();
		User user = (User)annotationConfigWebApplicationContext.getBean("user");
		System.out.println(user.getName() + user.getPassword());
	}
	
}

class User {
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
