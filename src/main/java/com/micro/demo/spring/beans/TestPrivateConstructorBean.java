package com.micro.demo.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author mapc 
 * @date 2017年6月16日
 */
@Configuration
public class TestPrivateConstructorBean {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.micro.demo.spring.beans");
		TestBean testBean = annotationConfigApplicationContext.getBean(TestBean.class);
		System.out.println(testBean.getName());
		annotationConfigApplicationContext.close();
	}
	
}

@Component
class TestBean {
	
	@Value("micro")
	private String name;
	
	private TestBean(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
