package com.xiaoyulaoshishuo.app.kq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoyulaoshishuo.app.kq.model.Operator;
import com.xiaoyulaoshishuo.app.kq.model.UserAccount;
import com.xiaoyulaoshishuo.app.kq.support.BaseController;
import com.xiaoyulaoshishuo.app.kq.support.annotation.UnLoginCheck;
import com.xiaoyulaoshishuo.app.kq.utils.ErrorMsgEnum;

/**
 * @author mapc 
 * @date 2017年6月13日
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	private Random r = new Random();
	
	@RequestMapping("login")
	@ResponseBody
	@UnLoginCheck
	public String login(@RequestParam("username") String username,@RequestParam("vcode") String vcode) {
		if (StringUtils.isEmpty(username)) {
			return fail(ErrorMsgEnum.PARAMS_ERROR);
		}
		UserAccount userAccount = null;
		if ((userAccount = userService.getUserAccountByName(username)) != null) {
			return ok(userAccount);
		}
		return fail(ErrorMsgEnum.USER_NOT_EXITS);
	}
	
	@RequestMapping("getOperators")
	@UnLoginCheck
	public @ResponseBody String operatos(Long userId) {
		List<Operator> operatorList = userService.getOperatorListByUserId(userId);
		return ok(operatorList);
	}
	
	@RequestMapping("myAccount")
	@ResponseBody
	@UnLoginCheck
	public String myAccount(@RequestParam("operatorId") Long operatorId, @RequestParam("password") String password, HttpSession session) {
		Operator operator = userService.getOperator(operatorId, password);
		if (operator == null) {
			return fail(ErrorMsgEnum.USER_NOT_EXITS);
		}
		session.setAttribute(USER_KEY, operator);
		return ok(operator);
	}
	
	// 欢迎页
	@RequestMapping("index")
	@ResponseBody
	public String index() {
		Operator operator = currentOperator();
		if (operator == null) {
			return fail(ErrorMsgEnum.USER_NOT_LOGIN);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("name", operator.getName());
		dataMap.put("totalBalance", accountService.getBalanceByAccountUserId(operator.getUserId()));
		dataMap.put("ip", generatorIp());
		return ok(dataMap);
	}
	
	private String generatorIp() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0;i < 4;i ++) {
			sb.append(r.nextInt(255)).append(".");
		}
		return sb.subSequence(0, sb.lastIndexOf(".")).toString();
	}
}





