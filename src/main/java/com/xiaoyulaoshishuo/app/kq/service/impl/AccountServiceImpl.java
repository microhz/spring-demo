package com.xiaoyulaoshishuo.app.kq.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xiaoyulaoshishuo.app.kq.model.AccountFile;
import com.xiaoyulaoshishuo.app.kq.model.AccountFileExample;
import com.xiaoyulaoshishuo.app.kq.model.AccountRecord;
import com.xiaoyulaoshishuo.app.kq.model.AccountRecordExample;
import com.xiaoyulaoshishuo.app.kq.model.AccountRecordExample.Criteria;
import com.xiaoyulaoshishuo.app.kq.service.AccountService;
import com.xiaoyulaoshishuo.app.kq.support.BaseService;
import com.xiaoyulaoshishuo.app.kq.support.TimeRangeEnum;
import com.xiaoyulaoshishuo.app.kq.support.TradeStatusEnum;
import com.xiaoyulaoshishuo.app.kq.support.TradeTypeEnum;
import com.xiaoyulaoshishuo.app.kq.utils.DateUtils;

/**
 * @author mapc
 * @date 2017年6月13日
 */
@Service
public class AccountServiceImpl extends BaseService implements AccountService {

	public Double getBalanceByAccountUserId(Long userId) {
		AccountRecordExample accountRecordExample = new AccountRecordExample();
		accountRecordExample.or().andAccountIdEqualTo(userId);
		accountRecordExample.setOrderByClause("end_time DESC");
		accountRecordExample.setStart(0);
		accountRecordExample.setEnd(1);
		List<AccountRecord> accountRecordList = accountRecordMapper.selectByExampleByPageSize(accountRecordExample);
		if (accountRecordList == null || accountRecordList.size() == 0) {
			return 0.0d;
		}
		return accountRecordList.get(0).getBalance();
	}

	public List<AccountRecord> getAccountRecordListByAccountId(Long accountId) {
		AccountRecordExample accountRecordExample = new AccountRecordExample();
		accountRecordExample.or().andAccountIdEqualTo(accountId);
		List<AccountRecord> accountRecordList = accountRecordMapper.selectByExample(accountRecordExample);
		if (accountRecordList != null && accountRecordList.size() > 0) {
			return accountRecordList;
		}
		return new ArrayList<AccountRecord>();
	}

	public List<AccountRecord> getAccountRecordList(Long accountId, Date startTime, Date endTime, Integer page,
			Integer size) {
		AccountRecordExample accountRecordExample = new AccountRecordExample();
		Criteria criteria = accountRecordExample.createCriteria();
		if (startTime != null) {
			criteria.andOperateTimeGreaterThan(startTime);
		}
		if (endTime != null) {
			criteria.andOperateTimeLessThan(endTime);
		}
		criteria.andAccountIdEqualTo(accountId);
		accountRecordExample.setStart(page * size);
		accountRecordExample.setEnd(page * size + size);
		List<AccountRecord> accountRecordList = accountRecordMapper.selectByExample(accountRecordExample);
		return accountRecordList != null ? accountRecordList : new ArrayList<AccountRecord>();
	}

	public List<Map<Integer, String>> getTradeTypeList() {
		List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();
		for (TradeTypeEnum tradeTypeEnum : TradeTypeEnum.values()) {
			Map<Integer, String> map = new HashMap<Integer, String>();
			map.put(tradeTypeEnum.getCode(), tradeTypeEnum.getName());
			list.add(map);
		}
		return list;
	}

	public List<Map<Integer, String>> getTradeStatusList() {
		List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();
		for (TradeStatusEnum tradeStatusEnum : TradeStatusEnum.values()) {
			Map<Integer, String> map = new HashMap<Integer, String>();
			map.put(tradeStatusEnum.getVal(),tradeStatusEnum.getName());
			list.add(map);
		}
		return list;
	}

	public List<AccountRecord> getAccountRecordList(Long accountId, Integer tradeType, Integer tradeStatus,
			String tradeNo, String orderNo, Double tradeAmount, Date startDate, Date endDate, Integer timeRangeCode,
			Integer page, Integer size) {
		AccountRecordExample accountRecordExample = new AccountRecordExample();
		Criteria criteria = accountRecordExample.createCriteria();
		if (timeRangeCode != null) {
			TimeRangeEnum timeRangeEnum = getTimeRangeByCode(timeRangeCode);
			Calendar calendar = Calendar.getInstance();
			endDate = new Date();
			int recentMonthCount = 0;
			if (timeRangeEnum == TimeRangeEnum.RECENT_MONTH) {
				recentMonthCount = -1;
			} else if (timeRangeEnum == TimeRangeEnum.RENCENT_THREE_MONTH) {
				recentMonthCount = -3;
			} else if (timeRangeEnum == TimeRangeEnum.RECENT_HALF_YEAR) {
				recentMonthCount = -6;
			} else if (timeRangeEnum == TimeRangeEnum.RECENT_YEAD) {
				recentMonthCount = -12;
			}
			calendar.set(Calendar.MONTH, recentMonthCount);
			startDate = calendar.getTime();
		}
		if (getTradeTypeByCode(tradeType) != null) {
			String tradeTypeName = getTradeTypeByCode(tradeType).getName();
			criteria.andTradeTypeEqualTo(tradeTypeName);
		}
		if (accountId != null) {
			criteria.andAccountIdEqualTo(accountId);
		}
		if (tradeStatus != null) {
			criteria.andStatusEqualTo(tradeStatus);
		}
		if (!StringUtils.isEmpty(tradeNo)) {
			criteria.andTradeNoEqualTo(tradeNo);
		}
		if (!StringUtils.isEmpty(orderNo)) {
			criteria.andOderIdEqualTo(orderNo);
		}
		if (tradeAmount != null) {
			criteria.andAmountEqualTo(tradeAmount);
		}
//		criteria.andAccountIdEqualTo(accountId).andStatusEqualTo(tradeStatus).andTradeNoEqualTo(tradeNo).andOderIdEqualTo(orderNo).andAmountEqualTo(tradeAmount);
		if (page != null && size != null) {
			accountRecordExample.setStart(page * size);
			accountRecordExample.setEnd(page * size + size);
		}
		accountRecordExample.setOrderByClause("operate_time DESC");
		return accountRecordMapper.selectByExample(accountRecordExample);
	}
	
	private TradeTypeEnum getTradeTypeByCode(Integer code) {
		for (TradeTypeEnum tradeTypeEnum : TradeTypeEnum.values()) {
			if (tradeTypeEnum.getCode() == code) {
				return tradeTypeEnum;
			}
		}
		return null;
	}
	
	private TimeRangeEnum getTimeRangeByCode(int code) {
		for (TimeRangeEnum timeRangeEnum : TimeRangeEnum.values()) {
			if (code == timeRangeEnum.getVal()) {
				return timeRangeEnum;
			}
		}
		return null;
	}

	public List<Map<String, String>> getSearchList(Long accountId, Integer fileType) {
		AccountFileExample accountFileExample = new AccountFileExample();
		accountFileExample.or().andAccountidEqualTo(accountId).andTypeEqualTo(fileType);
		List<AccountFile> accountFileList = accountFileMapper.selectByExample(accountFileExample);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		if (accountFileList != null) {
			for (AccountFile accountFile : accountFileList) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", accountFile.getId().toString());
				map.put("date", DateUtils.dayMonthSDF.format(accountFile.getDate()));
				map.put("name", accountFile.getAccountFileName());
				list.add(map);
			}
		}
		return list;
	}

	/*private TradeStatusEnum getTradeStatusByCode(Integer code) {
		for (TradeStatusEnum tradeStatusEnum : TradeStatusEnum.values()) {
			if (tradeStatusEnum.getVal() == code) {
				return tradeStatusEnum;
			}
		}
		return null;
	}*/
}
