package com.micro.demo.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author mapc
 * @date 2017年6月11日
 */
@Component
public class Father {
	@Value("micro")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
