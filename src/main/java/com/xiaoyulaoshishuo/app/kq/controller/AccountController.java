package com.xiaoyulaoshishuo.app.kq.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xiaoyulaoshishuo.app.kq.model.AccountFile;
import com.xiaoyulaoshishuo.app.kq.model.AccountRecord;
import com.xiaoyulaoshishuo.app.kq.model.Operator;
import com.xiaoyulaoshishuo.app.kq.support.BaseController;
import com.xiaoyulaoshishuo.app.kq.utils.DateUtils;
import com.xiaoyulaoshishuo.app.kq.utils.ErrorMsgEnum;

/**
 * @author mapc
 * @date 2017年6月13日
 */
@RequestMapping("account")
@Controller
public class AccountController extends BaseController {
	

	@RequestMapping("balanceDetail")
	@ResponseBody
	public String detail(@RequestParam(value = "accountType", required = false, defaultValue = "0") Integer accountType,
			@RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate,@ModelAttribute("user") Operator op,@RequestParam("page") Integer page,@RequestParam("size") Integer size) {
		// 测试SessionAttributes
		if (currentOperator() == op) {
			System.out.println("同样的对象");
		}
		Operator operator = currentOperator();
		if (operator == null) {
			return fail(ErrorMsgEnum.USER_NOT_LOGIN);
		}
		Date start = null;
		Date end = null;
		try {
			start = startDate == null ? null : DateUtils.dayMonthSDF.parse(startDate);
			end = endDate == null ? null : DateUtils.dayMonthSDF.parse(endDate);
		} catch (Exception ex) {
			logger.error("parse date error : source " + startDate + ",end time : " + endDate ,ex);
			return fail(ErrorMsgEnum.DATE_FORMACT_ERROR);
		}
		List<AccountRecord> accountRecordList = accountService.getAccountRecordList(operator.getId(), start, end, page, size);
		return ok(accountRecordList);
	}
	
	@RequestMapping("tradeType")
	@ResponseBody
	public String getTradeTypeList() {
		Map<String,List<Map<Integer, String>>> typeAndStatusMap = new HashMap<String, List<Map<Integer, String>>>();
		typeAndStatusMap.put("tradeType", accountService.getTradeTypeList());
		typeAndStatusMap.put("tradeStatus", accountService.getTradeStatusList());
		return ok(typeAndStatusMap);
	}
	
	@RequestMapping("tradeSearch")
	@ResponseBody
	public String search(@RequestParam(value = "type", required = false) Integer type,
			@RequestParam(value = "tradeStatus", required = false) Integer status,
			@RequestParam(value = "tradeNo", required = false) String tradeNo,
			@RequestParam(value = "orderNo", required = false) String orderNo,
			@RequestParam(value = "tradeAmount", required = false) Double tradeAmount,
			@RequestParam(value = "startDate", required = false) Date startDate,
			@RequestParam(value = "endDate", required = false) Date endDate,
			@RequestParam(value = "DateRange",required = false) Integer dateRange,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		Operator operator = currentOperator();
		if (operator == null) {
			return fail(ErrorMsgEnum.USER_NOT_EXITS);
		}
		List<AccountRecord> accountRecordList = accountService.getAccountRecordList(operator.getUserId(), type, status, tradeNo, orderNo, tradeAmount, startDate, endDate, dateRange, page, size);
		return ok(accountRecordList);
	}
	
	
	@RequestMapping("accountSearch")
	@ResponseBody
	public String accountSearch(@RequestParam("searchType") Integer searchType) {
		List<AccountFile> accountFileList = fileService.getFileUrl(searchType, currentOperator().getId());
		return ok(accountFileList);
	}
}
