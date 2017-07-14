package com.xiaoyulaoshishuo.app.kq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xiaoyulaoshishuo.app.kq.model.Operator;
import com.xiaoyulaoshishuo.app.kq.model.OperatorExample;
import com.xiaoyulaoshishuo.app.kq.model.UserAccount;
import com.xiaoyulaoshishuo.app.kq.model.UserAccountExample;
import com.xiaoyulaoshishuo.app.kq.service.UserService;
import com.xiaoyulaoshishuo.app.kq.support.BaseService;

/**
 * @author mapc 
 * @date 2017年6月13日
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

	public boolean checkUser(String username, String vcode) {
		UserAccountExample userAccountExample = new UserAccountExample();
		userAccountExample.or().andNameEqualTo(username);
		return userAccountMapper.countByExample(userAccountExample) > 0;
	}

	public List<Operator> getOperatorListByUserId(Long userId) {
		OperatorExample operatorExample = new OperatorExample();
		operatorExample.or().andUserIdEqualTo(userId);
		List<Operator> operatorList = operatorMapper.selectByExample(operatorExample);
		if (operatorList != null) {
			return operatorList;
		}
		return new ArrayList<Operator>();
	}

	public Operator getOperator(Long operatorId, String password) {
		OperatorExample operatorExample = new OperatorExample();
		operatorExample.or().andIdEqualTo(operatorId).andPasswordEqualTo(password);
		List<Operator> operatorList = operatorMapper.selectByExample(operatorExample);
		if (operatorList == null || operatorList.size() == 0) {
			return null;
		}
		return operatorList.get(0);
	}

	public UserAccount getUserAccountByName(String name) {
		UserAccountExample userAccountExample = new UserAccountExample();
		userAccountExample.or().andNameEqualTo(name);
		List<UserAccount> userAccountList = userAccountMapper.selectByExample(userAccountExample);
		if (userAccountList != null && userAccountList.size() > 0) {
			return userAccountList.get(0);
		}
		return null;
	}

}
