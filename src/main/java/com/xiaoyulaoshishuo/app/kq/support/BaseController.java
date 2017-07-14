package com.xiaoyulaoshishuo.app.kq.support;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaoyulaoshishuo.app.kq.model.Operator;
import com.xiaoyulaoshishuo.app.kq.service.AccountService;
import com.xiaoyulaoshishuo.app.kq.service.FileService;
import com.xiaoyulaoshishuo.app.kq.service.UserService;

/**
 * @author mapc
 * @date 2017年6月13日
 */
public abstract class BaseController implements ApplicationContextAware {

	public final static String USER_KEY = "user";
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected AccountService accountService;
	
	@Autowired
	protected FileService fileService;

	@Autowired
	private HttpSession httpSession;

	protected ObjectMapper objectMapper = new ObjectMapper();

	protected WebApplicationContext webApplicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (applicationContext instanceof WebApplicationContext) {
			this.webApplicationContext = (WebApplicationContext) applicationContext;
		}
	}
	
	protected String ok() {
		return ok(null);
	}

	// 转换返回参数转换json
	protected String ok(Object data) {
		return result(data, Status.SUCCESS, "");
	}

	protected String fail(String errorMessage) {
		return result(null, Status.FAIL, errorMessage);
	}

	private String result(Object data, Status status, String msg) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", data);
		result.put("code", status.getCode());
		result.put("message", msg);
		try {
			return objectMapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected Operator currentOperator() {
		if (httpSession.getAttribute(USER_KEY) != null && httpSession.getAttribute(USER_KEY) instanceof Operator) {
			return (Operator) httpSession.getAttribute(USER_KEY);
		}
		return null;
	}

	static enum Status {
		SUCCESS(0), FAIL(1);
		private int code;

		private Status(int code) {
			this.code = code;
		}

		public Integer getCode() {
			return this.code;
		}
	}

}
