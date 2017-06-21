package com.xiaoyulaoshishuo.app.kq.service;
/**
 * @author mapc 
 * @date 2017年6月13日
 */

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.xiaoyulaoshishuo.app.kq.model.AccountRecord;

public interface AccountService {

	Double getBalanceByAccountUserId(Long userId);

	List<AccountRecord> getAccountRecordListByAccountId(Long accountId);
	
	List<AccountRecord> getAccountRecordList(Long accountId, Date startTime, Date endTime, Integer page, Integer size);
	
	List<AccountRecord> getAccountRecordList(Long accountId, Integer tradeType, Integer tradeStatus,String tradeNo, String orderNo, Double tradeAmount, Date startDate, Date endDate, Integer timeRangeCode, Integer page, Integer size);

	List<Map<Integer, String>> getTradeTypeList();
	
	List<Map<Integer, String>> getTradeStatusList();
	
	List<Map<String, String>> getSearchList(Long accountId, Integer fileType);
}
