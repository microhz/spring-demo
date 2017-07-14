package com.micro.demo.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mapc 
 * @date 2017年6月28日
 */
@RestController
public class LogbackTestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("log")
	@ResponseBody
	public String testLog() {
		logger.debug("test log");
		return "{code : 1}";
	}
}
