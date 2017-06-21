package com.xiaoyulaoshishuo.app.kq.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xiaoyulaoshishuo.app.kq.support.PageSizeMapperExampleSupport;

public class AccountRecordExample extends PageSizeMapperExampleSupport {
	protected String orderByClause;

	protected boolean distinct;

	public void setOredCriteria(List<Criteria> oredCriteria) {
		this.oredCriteria = oredCriteria;
	}

	protected List<Criteria> oredCriteria;

	public AccountRecordExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andAccountIdIsNull() {
			addCriterion("account_id is null");
			return (Criteria) this;
		}

		public Criteria andAccountIdIsNotNull() {
			addCriterion("account_id is not null");
			return (Criteria) this;
		}

		public Criteria andAccountIdEqualTo(Long value) {
			addCriterion("account_id =", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdNotEqualTo(Long value) {
			addCriterion("account_id <>", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdGreaterThan(Long value) {
			addCriterion("account_id >", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
			addCriterion("account_id >=", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdLessThan(Long value) {
			addCriterion("account_id <", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdLessThanOrEqualTo(Long value) {
			addCriterion("account_id <=", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdIn(List<Long> values) {
			addCriterion("account_id in", values, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdNotIn(List<Long> values) {
			addCriterion("account_id not in", values, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdBetween(Long value1, Long value2) {
			addCriterion("account_id between", value1, value2, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdNotBetween(Long value1, Long value2) {
			addCriterion("account_id not between", value1, value2, "accountId");
			return (Criteria) this;
		}

		public Criteria andOperateTimeIsNull() {
			addCriterion("operate_time is null");
			return (Criteria) this;
		}

		public Criteria andOperateTimeIsNotNull() {
			addCriterion("operate_time is not null");
			return (Criteria) this;
		}

		public Criteria andOperateTimeEqualTo(Date value) {
			addCriterion("operate_time =", value, "operateTime");
			return (Criteria) this;
		}

		public Criteria andOperateTimeNotEqualTo(Date value) {
			addCriterion("operate_time <>", value, "operateTime");
			return (Criteria) this;
		}

		public Criteria andOperateTimeGreaterThan(Date value) {
			addCriterion("operate_time >", value, "operateTime");
			return (Criteria) this;
		}

		public Criteria andOperateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("operate_time >=", value, "operateTime");
			return (Criteria) this;
		}

		public Criteria andOperateTimeLessThan(Date value) {
			addCriterion("operate_time <", value, "operateTime");
			return (Criteria) this;
		}

		public Criteria andOperateTimeLessThanOrEqualTo(Date value) {
			addCriterion("operate_time <=", value, "operateTime");
			return (Criteria) this;
		}

		public Criteria andOperateTimeIn(List<Date> values) {
			addCriterion("operate_time in", values, "operateTime");
			return (Criteria) this;
		}

		public Criteria andOperateTimeNotIn(List<Date> values) {
			addCriterion("operate_time not in", values, "operateTime");
			return (Criteria) this;
		}

		public Criteria andOperateTimeBetween(Date value1, Date value2) {
			addCriterion("operate_time between", value1, value2, "operateTime");
			return (Criteria) this;
		}

		public Criteria andOperateTimeNotBetween(Date value1, Date value2) {
			addCriterion("operate_time not between", value1, value2, "operateTime");
			return (Criteria) this;
		}

		public Criteria andBatchIdIsNull() {
			addCriterion("batch_id is null");
			return (Criteria) this;
		}

		public Criteria andBatchIdIsNotNull() {
			addCriterion("batch_id is not null");
			return (Criteria) this;
		}

		public Criteria andBatchIdEqualTo(String value) {
			addCriterion("batch_id =", value, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdNotEqualTo(String value) {
			addCriterion("batch_id <>", value, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdGreaterThan(String value) {
			addCriterion("batch_id >", value, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdGreaterThanOrEqualTo(String value) {
			addCriterion("batch_id >=", value, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdLessThan(String value) {
			addCriterion("batch_id <", value, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdLessThanOrEqualTo(String value) {
			addCriterion("batch_id <=", value, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdLike(String value) {
			addCriterion("batch_id like", value, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdNotLike(String value) {
			addCriterion("batch_id not like", value, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdIn(List<String> values) {
			addCriterion("batch_id in", values, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdNotIn(List<String> values) {
			addCriterion("batch_id not in", values, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdBetween(String value1, String value2) {
			addCriterion("batch_id between", value1, value2, "batchId");
			return (Criteria) this;
		}

		public Criteria andBatchIdNotBetween(String value1, String value2) {
			addCriterion("batch_id not between", value1, value2, "batchId");
			return (Criteria) this;
		}

		public Criteria andTradeNoIsNull() {
			addCriterion("trade_no is null");
			return (Criteria) this;
		}

		public Criteria andTradeNoIsNotNull() {
			addCriterion("trade_no is not null");
			return (Criteria) this;
		}

		public Criteria andTradeNoEqualTo(String value) {
			addCriterion("trade_no =", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotEqualTo(String value) {
			addCriterion("trade_no <>", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoGreaterThan(String value) {
			addCriterion("trade_no >", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
			addCriterion("trade_no >=", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoLessThan(String value) {
			addCriterion("trade_no <", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoLessThanOrEqualTo(String value) {
			addCriterion("trade_no <=", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoLike(String value) {
			addCriterion("trade_no like", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotLike(String value) {
			addCriterion("trade_no not like", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoIn(List<String> values) {
			addCriterion("trade_no in", values, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotIn(List<String> values) {
			addCriterion("trade_no not in", values, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoBetween(String value1, String value2) {
			addCriterion("trade_no between", value1, value2, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotBetween(String value1, String value2) {
			addCriterion("trade_no not between", value1, value2, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeTypeIsNull() {
			addCriterion("trade_type is null");
			return (Criteria) this;
		}

		public Criteria andTradeTypeIsNotNull() {
			addCriterion("trade_type is not null");
			return (Criteria) this;
		}

		public Criteria andTradeTypeEqualTo(String value) {
			addCriterion("trade_type =", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeNotEqualTo(String value) {
			addCriterion("trade_type <>", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeGreaterThan(String value) {
			addCriterion("trade_type >", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
			addCriterion("trade_type >=", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeLessThan(String value) {
			addCriterion("trade_type <", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeLessThanOrEqualTo(String value) {
			addCriterion("trade_type <=", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeLike(String value) {
			addCriterion("trade_type like", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeNotLike(String value) {
			addCriterion("trade_type not like", value, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeIn(List<String> values) {
			addCriterion("trade_type in", values, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeNotIn(List<String> values) {
			addCriterion("trade_type not in", values, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeBetween(String value1, String value2) {
			addCriterion("trade_type between", value1, value2, "tradeType");
			return (Criteria) this;
		}

		public Criteria andTradeTypeNotBetween(String value1, String value2) {
			addCriterion("trade_type not between", value1, value2, "tradeType");
			return (Criteria) this;
		}

		public Criteria andOderIdIsNull() {
			addCriterion("oder_id is null");
			return (Criteria) this;
		}

		public Criteria andOderIdIsNotNull() {
			addCriterion("oder_id is not null");
			return (Criteria) this;
		}

		public Criteria andOderIdEqualTo(String value) {
			addCriterion("oder_id =", value, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdNotEqualTo(String value) {
			addCriterion("oder_id <>", value, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdGreaterThan(String value) {
			addCriterion("oder_id >", value, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdGreaterThanOrEqualTo(String value) {
			addCriterion("oder_id >=", value, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdLessThan(String value) {
			addCriterion("oder_id <", value, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdLessThanOrEqualTo(String value) {
			addCriterion("oder_id <=", value, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdLike(String value) {
			addCriterion("oder_id like", value, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdNotLike(String value) {
			addCriterion("oder_id not like", value, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdIn(List<String> values) {
			addCriterion("oder_id in", values, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdNotIn(List<String> values) {
			addCriterion("oder_id not in", values, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdBetween(String value1, String value2) {
			addCriterion("oder_id between", value1, value2, "oderId");
			return (Criteria) this;
		}

		public Criteria andOderIdNotBetween(String value1, String value2) {
			addCriterion("oder_id not between", value1, value2, "oderId");
			return (Criteria) this;
		}

		public Criteria andTargetNameIsNull() {
			addCriterion("target_name is null");
			return (Criteria) this;
		}

		public Criteria andTargetNameIsNotNull() {
			addCriterion("target_name is not null");
			return (Criteria) this;
		}

		public Criteria andTargetNameEqualTo(String value) {
			addCriterion("target_name =", value, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameNotEqualTo(String value) {
			addCriterion("target_name <>", value, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameGreaterThan(String value) {
			addCriterion("target_name >", value, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameGreaterThanOrEqualTo(String value) {
			addCriterion("target_name >=", value, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameLessThan(String value) {
			addCriterion("target_name <", value, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameLessThanOrEqualTo(String value) {
			addCriterion("target_name <=", value, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameLike(String value) {
			addCriterion("target_name like", value, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameNotLike(String value) {
			addCriterion("target_name not like", value, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameIn(List<String> values) {
			addCriterion("target_name in", values, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameNotIn(List<String> values) {
			addCriterion("target_name not in", values, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameBetween(String value1, String value2) {
			addCriterion("target_name between", value1, value2, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetNameNotBetween(String value1, String value2) {
			addCriterion("target_name not between", value1, value2, "targetName");
			return (Criteria) this;
		}

		public Criteria andTargetBankIsNull() {
			addCriterion("target_bank is null");
			return (Criteria) this;
		}

		public Criteria andTargetBankIsNotNull() {
			addCriterion("target_bank is not null");
			return (Criteria) this;
		}

		public Criteria andTargetBankEqualTo(String value) {
			addCriterion("target_bank =", value, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankNotEqualTo(String value) {
			addCriterion("target_bank <>", value, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankGreaterThan(String value) {
			addCriterion("target_bank >", value, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankGreaterThanOrEqualTo(String value) {
			addCriterion("target_bank >=", value, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankLessThan(String value) {
			addCriterion("target_bank <", value, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankLessThanOrEqualTo(String value) {
			addCriterion("target_bank <=", value, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankLike(String value) {
			addCriterion("target_bank like", value, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankNotLike(String value) {
			addCriterion("target_bank not like", value, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankIn(List<String> values) {
			addCriterion("target_bank in", values, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankNotIn(List<String> values) {
			addCriterion("target_bank not in", values, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankBetween(String value1, String value2) {
			addCriterion("target_bank between", value1, value2, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBankNotBetween(String value1, String value2) {
			addCriterion("target_bank not between", value1, value2, "targetBank");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoIsNull() {
			addCriterion("target_back_no is null");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoIsNotNull() {
			addCriterion("target_back_no is not null");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoEqualTo(String value) {
			addCriterion("target_back_no =", value, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoNotEqualTo(String value) {
			addCriterion("target_back_no <>", value, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoGreaterThan(String value) {
			addCriterion("target_back_no >", value, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoGreaterThanOrEqualTo(String value) {
			addCriterion("target_back_no >=", value, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoLessThan(String value) {
			addCriterion("target_back_no <", value, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoLessThanOrEqualTo(String value) {
			addCriterion("target_back_no <=", value, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoLike(String value) {
			addCriterion("target_back_no like", value, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoNotLike(String value) {
			addCriterion("target_back_no not like", value, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoIn(List<String> values) {
			addCriterion("target_back_no in", values, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoNotIn(List<String> values) {
			addCriterion("target_back_no not in", values, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoBetween(String value1, String value2) {
			addCriterion("target_back_no between", value1, value2, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andTargetBackNoNotBetween(String value1, String value2) {
			addCriterion("target_back_no not between", value1, value2, "targetBackNo");
			return (Criteria) this;
		}

		public Criteria andIncomeIsNull() {
			addCriterion("income is null");
			return (Criteria) this;
		}

		public Criteria andIncomeIsNotNull() {
			addCriterion("income is not null");
			return (Criteria) this;
		}

		public Criteria andIncomeEqualTo(Double value) {
			addCriterion("income =", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeNotEqualTo(Double value) {
			addCriterion("income <>", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeGreaterThan(Double value) {
			addCriterion("income >", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeGreaterThanOrEqualTo(Double value) {
			addCriterion("income >=", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeLessThan(Double value) {
			addCriterion("income <", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeLessThanOrEqualTo(Double value) {
			addCriterion("income <=", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeIn(List<Double> values) {
			addCriterion("income in", values, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeNotIn(List<Double> values) {
			addCriterion("income not in", values, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeBetween(Double value1, Double value2) {
			addCriterion("income between", value1, value2, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeNotBetween(Double value1, Double value2) {
			addCriterion("income not between", value1, value2, "income");
			return (Criteria) this;
		}

		public Criteria andExpendIsNull() {
			addCriterion("expend is null");
			return (Criteria) this;
		}

		public Criteria andExpendIsNotNull() {
			addCriterion("expend is not null");
			return (Criteria) this;
		}

		public Criteria andExpendEqualTo(Double value) {
			addCriterion("expend =", value, "expend");
			return (Criteria) this;
		}

		public Criteria andExpendNotEqualTo(Double value) {
			addCriterion("expend <>", value, "expend");
			return (Criteria) this;
		}

		public Criteria andExpendGreaterThan(Double value) {
			addCriterion("expend >", value, "expend");
			return (Criteria) this;
		}

		public Criteria andExpendGreaterThanOrEqualTo(Double value) {
			addCriterion("expend >=", value, "expend");
			return (Criteria) this;
		}

		public Criteria andExpendLessThan(Double value) {
			addCriterion("expend <", value, "expend");
			return (Criteria) this;
		}

		public Criteria andExpendLessThanOrEqualTo(Double value) {
			addCriterion("expend <=", value, "expend");
			return (Criteria) this;
		}

		public Criteria andExpendIn(List<Double> values) {
			addCriterion("expend in", values, "expend");
			return (Criteria) this;
		}

		public Criteria andExpendNotIn(List<Double> values) {
			addCriterion("expend not in", values, "expend");
			return (Criteria) this;
		}

		public Criteria andExpendBetween(Double value1, Double value2) {
			addCriterion("expend between", value1, value2, "expend");
			return (Criteria) this;
		}

		public Criteria andExpendNotBetween(Double value1, Double value2) {
			addCriterion("expend not between", value1, value2, "expend");
			return (Criteria) this;
		}

		public Criteria andBalanceIsNull() {
			addCriterion("balance is null");
			return (Criteria) this;
		}

		public Criteria andBalanceIsNotNull() {
			addCriterion("balance is not null");
			return (Criteria) this;
		}

		public Criteria andBalanceEqualTo(Double value) {
			addCriterion("balance =", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotEqualTo(Double value) {
			addCriterion("balance <>", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceGreaterThan(Double value) {
			addCriterion("balance >", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceGreaterThanOrEqualTo(Double value) {
			addCriterion("balance >=", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceLessThan(Double value) {
			addCriterion("balance <", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceLessThanOrEqualTo(Double value) {
			addCriterion("balance <=", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceIn(List<Double> values) {
			addCriterion("balance in", values, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotIn(List<Double> values) {
			addCriterion("balance not in", values, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceBetween(Double value1, Double value2) {
			addCriterion("balance between", value1, value2, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotBetween(Double value1, Double value2) {
			addCriterion("balance not between", value1, value2, "balance");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeIsNull() {
			addCriterion("money_type is null");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeIsNotNull() {
			addCriterion("money_type is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeEqualTo(Integer value) {
			addCriterion("money_type =", value, "moneyType");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeNotEqualTo(Integer value) {
			addCriterion("money_type <>", value, "moneyType");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeGreaterThan(Integer value) {
			addCriterion("money_type >", value, "moneyType");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("money_type >=", value, "moneyType");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeLessThan(Integer value) {
			addCriterion("money_type <", value, "moneyType");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeLessThanOrEqualTo(Integer value) {
			addCriterion("money_type <=", value, "moneyType");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeIn(List<Integer> values) {
			addCriterion("money_type in", values, "moneyType");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeNotIn(List<Integer> values) {
			addCriterion("money_type not in", values, "moneyType");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeBetween(Integer value1, Integer value2) {
			addCriterion("money_type between", value1, value2, "moneyType");
			return (Criteria) this;
		}

		public Criteria andMoneyTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("money_type not between", value1, value2, "moneyType");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNull() {
			addCriterion("start_time is null");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNotNull() {
			addCriterion("start_time is not null");
			return (Criteria) this;
		}

		public Criteria andStartTimeEqualTo(Date value) {
			addCriterion("start_time =", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotEqualTo(Date value) {
			addCriterion("start_time <>", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThan(Date value) {
			addCriterion("start_time >", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("start_time >=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThan(Date value) {
			addCriterion("start_time <", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("start_time <=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeIn(List<Date> values) {
			addCriterion("start_time in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotIn(List<Date> values) {
			addCriterion("start_time not in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeBetween(Date value1, Date value2) {
			addCriterion("start_time between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("start_time not between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(Date value) {
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(Date value) {
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(Date value) {
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(Date value) {
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<Date> values) {
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<Date> values) {
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(Date value1, Date value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andProvinceIsNull() {
			addCriterion("province is null");
			return (Criteria) this;
		}

		public Criteria andProvinceIsNotNull() {
			addCriterion("province is not null");
			return (Criteria) this;
		}

		public Criteria andProvinceEqualTo(String value) {
			addCriterion("province =", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotEqualTo(String value) {
			addCriterion("province <>", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceGreaterThan(String value) {
			addCriterion("province >", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceGreaterThanOrEqualTo(String value) {
			addCriterion("province >=", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLessThan(String value) {
			addCriterion("province <", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLessThanOrEqualTo(String value) {
			addCriterion("province <=", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLike(String value) {
			addCriterion("province like", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotLike(String value) {
			addCriterion("province not like", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceIn(List<String> values) {
			addCriterion("province in", values, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotIn(List<String> values) {
			addCriterion("province not in", values, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceBetween(String value1, String value2) {
			addCriterion("province between", value1, value2, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotBetween(String value1, String value2) {
			addCriterion("province not between", value1, value2, "province");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameIsNull() {
			addCriterion("bank_branch_name is null");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameIsNotNull() {
			addCriterion("bank_branch_name is not null");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameEqualTo(String value) {
			addCriterion("bank_branch_name =", value, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameNotEqualTo(String value) {
			addCriterion("bank_branch_name <>", value, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameGreaterThan(String value) {
			addCriterion("bank_branch_name >", value, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameGreaterThanOrEqualTo(String value) {
			addCriterion("bank_branch_name >=", value, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameLessThan(String value) {
			addCriterion("bank_branch_name <", value, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameLessThanOrEqualTo(String value) {
			addCriterion("bank_branch_name <=", value, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameLike(String value) {
			addCriterion("bank_branch_name like", value, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameNotLike(String value) {
			addCriterion("bank_branch_name not like", value, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameIn(List<String> values) {
			addCriterion("bank_branch_name in", values, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameNotIn(List<String> values) {
			addCriterion("bank_branch_name not in", values, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameBetween(String value1, String value2) {
			addCriterion("bank_branch_name between", value1, value2, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andBankBranchNameNotBetween(String value1, String value2) {
			addCriterion("bank_branch_name not between", value1, value2, "bankBranchName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameIsNull() {
			addCriterion("pay_side_name is null");
			return (Criteria) this;
		}

		public Criteria andPaySideNameIsNotNull() {
			addCriterion("pay_side_name is not null");
			return (Criteria) this;
		}

		public Criteria andPaySideNameEqualTo(String value) {
			addCriterion("pay_side_name =", value, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameNotEqualTo(String value) {
			addCriterion("pay_side_name <>", value, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameGreaterThan(String value) {
			addCriterion("pay_side_name >", value, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameGreaterThanOrEqualTo(String value) {
			addCriterion("pay_side_name >=", value, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameLessThan(String value) {
			addCriterion("pay_side_name <", value, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameLessThanOrEqualTo(String value) {
			addCriterion("pay_side_name <=", value, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameLike(String value) {
			addCriterion("pay_side_name like", value, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameNotLike(String value) {
			addCriterion("pay_side_name not like", value, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameIn(List<String> values) {
			addCriterion("pay_side_name in", values, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameNotIn(List<String> values) {
			addCriterion("pay_side_name not in", values, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameBetween(String value1, String value2) {
			addCriterion("pay_side_name between", value1, value2, "paySideName");
			return (Criteria) this;
		}

		public Criteria andPaySideNameNotBetween(String value1, String value2) {
			addCriterion("pay_side_name not between", value1, value2, "paySideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameIsNull() {
			addCriterion("recieve_side_name is null");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameIsNotNull() {
			addCriterion("recieve_side_name is not null");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameEqualTo(String value) {
			addCriterion("recieve_side_name =", value, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameNotEqualTo(String value) {
			addCriterion("recieve_side_name <>", value, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameGreaterThan(String value) {
			addCriterion("recieve_side_name >", value, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameGreaterThanOrEqualTo(String value) {
			addCriterion("recieve_side_name >=", value, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameLessThan(String value) {
			addCriterion("recieve_side_name <", value, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameLessThanOrEqualTo(String value) {
			addCriterion("recieve_side_name <=", value, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameLike(String value) {
			addCriterion("recieve_side_name like", value, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameNotLike(String value) {
			addCriterion("recieve_side_name not like", value, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameIn(List<String> values) {
			addCriterion("recieve_side_name in", values, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameNotIn(List<String> values) {
			addCriterion("recieve_side_name not in", values, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameBetween(String value1, String value2) {
			addCriterion("recieve_side_name between", value1, value2, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andRecieveSideNameNotBetween(String value1, String value2) {
			addCriterion("recieve_side_name not between", value1, value2, "recieveSideName");
			return (Criteria) this;
		}

		public Criteria andTargetTelIsNull() {
			addCriterion("target_tel is null");
			return (Criteria) this;
		}

		public Criteria andTargetTelIsNotNull() {
			addCriterion("target_tel is not null");
			return (Criteria) this;
		}

		public Criteria andTargetTelEqualTo(String value) {
			addCriterion("target_tel =", value, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelNotEqualTo(String value) {
			addCriterion("target_tel <>", value, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelGreaterThan(String value) {
			addCriterion("target_tel >", value, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelGreaterThanOrEqualTo(String value) {
			addCriterion("target_tel >=", value, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelLessThan(String value) {
			addCriterion("target_tel <", value, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelLessThanOrEqualTo(String value) {
			addCriterion("target_tel <=", value, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelLike(String value) {
			addCriterion("target_tel like", value, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelNotLike(String value) {
			addCriterion("target_tel not like", value, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelIn(List<String> values) {
			addCriterion("target_tel in", values, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelNotIn(List<String> values) {
			addCriterion("target_tel not in", values, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelBetween(String value1, String value2) {
			addCriterion("target_tel between", value1, value2, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetTelNotBetween(String value1, String value2) {
			addCriterion("target_tel not between", value1, value2, "targetTel");
			return (Criteria) this;
		}

		public Criteria andTargetEmailIsNull() {
			addCriterion("target_email is null");
			return (Criteria) this;
		}

		public Criteria andTargetEmailIsNotNull() {
			addCriterion("target_email is not null");
			return (Criteria) this;
		}

		public Criteria andTargetEmailEqualTo(String value) {
			addCriterion("target_email =", value, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailNotEqualTo(String value) {
			addCriterion("target_email <>", value, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailGreaterThan(String value) {
			addCriterion("target_email >", value, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailGreaterThanOrEqualTo(String value) {
			addCriterion("target_email >=", value, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailLessThan(String value) {
			addCriterion("target_email <", value, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailLessThanOrEqualTo(String value) {
			addCriterion("target_email <=", value, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailLike(String value) {
			addCriterion("target_email like", value, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailNotLike(String value) {
			addCriterion("target_email not like", value, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailIn(List<String> values) {
			addCriterion("target_email in", values, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailNotIn(List<String> values) {
			addCriterion("target_email not in", values, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailBetween(String value1, String value2) {
			addCriterion("target_email between", value1, value2, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andTargetEmailNotBetween(String value1, String value2) {
			addCriterion("target_email not between", value1, value2, "targetEmail");
			return (Criteria) this;
		}

		public Criteria andAmountIsNull() {
			addCriterion("amount is null");
			return (Criteria) this;
		}

		public Criteria andAmountIsNotNull() {
			addCriterion("amount is not null");
			return (Criteria) this;
		}

		public Criteria andAmountEqualTo(Double value) {
			addCriterion("amount =", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotEqualTo(Double value) {
			addCriterion("amount <>", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThan(Double value) {
			addCriterion("amount >", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThanOrEqualTo(Double value) {
			addCriterion("amount >=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThan(Double value) {
			addCriterion("amount <", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThanOrEqualTo(Double value) {
			addCriterion("amount <=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountIn(List<Double> values) {
			addCriterion("amount in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotIn(List<Double> values) {
			addCriterion("amount not in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountBetween(Double value1, Double value2) {
			addCriterion("amount between", value1, value2, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotBetween(Double value1, Double value2) {
			addCriterion("amount not between", value1, value2, "amount");
			return (Criteria) this;
		}

		public Criteria andChargeIsNull() {
			addCriterion("charge is null");
			return (Criteria) this;
		}

		public Criteria andChargeIsNotNull() {
			addCriterion("charge is not null");
			return (Criteria) this;
		}

		public Criteria andChargeEqualTo(Double value) {
			addCriterion("charge =", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotEqualTo(Double value) {
			addCriterion("charge <>", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeGreaterThan(Double value) {
			addCriterion("charge >", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeGreaterThanOrEqualTo(Double value) {
			addCriterion("charge >=", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeLessThan(Double value) {
			addCriterion("charge <", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeLessThanOrEqualTo(Double value) {
			addCriterion("charge <=", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeIn(List<Double> values) {
			addCriterion("charge in", values, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotIn(List<Double> values) {
			addCriterion("charge not in", values, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeBetween(Double value1, Double value2) {
			addCriterion("charge between", value1, value2, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotBetween(Double value1, Double value2) {
			addCriterion("charge not between", value1, value2, "charge");
			return (Criteria) this;
		}

		public Criteria andRealChargeIsNull() {
			addCriterion("real_charge is null");
			return (Criteria) this;
		}

		public Criteria andRealChargeIsNotNull() {
			addCriterion("real_charge is not null");
			return (Criteria) this;
		}

		public Criteria andRealChargeEqualTo(Double value) {
			addCriterion("real_charge =", value, "realCharge");
			return (Criteria) this;
		}

		public Criteria andRealChargeNotEqualTo(Double value) {
			addCriterion("real_charge <>", value, "realCharge");
			return (Criteria) this;
		}

		public Criteria andRealChargeGreaterThan(Double value) {
			addCriterion("real_charge >", value, "realCharge");
			return (Criteria) this;
		}

		public Criteria andRealChargeGreaterThanOrEqualTo(Double value) {
			addCriterion("real_charge >=", value, "realCharge");
			return (Criteria) this;
		}

		public Criteria andRealChargeLessThan(Double value) {
			addCriterion("real_charge <", value, "realCharge");
			return (Criteria) this;
		}

		public Criteria andRealChargeLessThanOrEqualTo(Double value) {
			addCriterion("real_charge <=", value, "realCharge");
			return (Criteria) this;
		}

		public Criteria andRealChargeIn(List<Double> values) {
			addCriterion("real_charge in", values, "realCharge");
			return (Criteria) this;
		}

		public Criteria andRealChargeNotIn(List<Double> values) {
			addCriterion("real_charge not in", values, "realCharge");
			return (Criteria) this;
		}

		public Criteria andRealChargeBetween(Double value1, Double value2) {
			addCriterion("real_charge between", value1, value2, "realCharge");
			return (Criteria) this;
		}

		public Criteria andRealChargeNotBetween(Double value1, Double value2) {
			addCriterion("real_charge not between", value1, value2, "realCharge");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andFailReasonIsNull() {
			addCriterion("fail_reason is null");
			return (Criteria) this;
		}

		public Criteria andFailReasonIsNotNull() {
			addCriterion("fail_reason is not null");
			return (Criteria) this;
		}

		public Criteria andFailReasonEqualTo(String value) {
			addCriterion("fail_reason =", value, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonNotEqualTo(String value) {
			addCriterion("fail_reason <>", value, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonGreaterThan(String value) {
			addCriterion("fail_reason >", value, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonGreaterThanOrEqualTo(String value) {
			addCriterion("fail_reason >=", value, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonLessThan(String value) {
			addCriterion("fail_reason <", value, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonLessThanOrEqualTo(String value) {
			addCriterion("fail_reason <=", value, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonLike(String value) {
			addCriterion("fail_reason like", value, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonNotLike(String value) {
			addCriterion("fail_reason not like", value, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonIn(List<String> values) {
			addCriterion("fail_reason in", values, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonNotIn(List<String> values) {
			addCriterion("fail_reason not in", values, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonBetween(String value1, String value2) {
			addCriterion("fail_reason between", value1, value2, "failReason");
			return (Criteria) this;
		}

		public Criteria andFailReasonNotBetween(String value1, String value2) {
			addCriterion("fail_reason not between", value1, value2, "failReason");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}