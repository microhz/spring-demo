package com.xiaoyulaoshishuo.app.kq.service;

import java.util.List;

import com.xiaoyulaoshishuo.app.kq.model.Operator;
import com.xiaoyulaoshishuo.app.kq.model.UserAccount;

/**
 * @author mapc 
 * @date 2017年6月13日
 */
public interface UserService {
	
	UserAccount getUserAccountByName(String name);
	
	boolean checkUser(String username, String vcode);
	
	List<Operator> getOperatorListByUserId(Long userId);
	
	Operator getOperator(Long operatorId, String password);
}
