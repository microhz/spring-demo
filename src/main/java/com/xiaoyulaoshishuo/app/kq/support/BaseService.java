package com.xiaoyulaoshishuo.app.kq.support;
/**
 * @author mapc 
 * @date 2017年6月13日
 */

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaoyulaoshishuo.app.kq.mapper.AccountFileMapper;
import com.xiaoyulaoshishuo.app.kq.mapper.AccountRecordMapper;
import com.xiaoyulaoshishuo.app.kq.mapper.OperatorMapper;
import com.xiaoyulaoshishuo.app.kq.mapper.UserAccountMapper;

public abstract class BaseService {
	
	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	protected UserAccountMapper userAccountMapper;
	
	@Autowired
	protected OperatorMapper operatorMapper;
	
	@Autowired
	protected AccountRecordMapper accountRecordMapper;
	
	@Autowired
	protected AccountFileMapper accountFileMapper;
}
