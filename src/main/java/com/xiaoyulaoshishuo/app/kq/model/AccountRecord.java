package com.xiaoyulaoshishuo.app.kq.model;

import java.util.Date;

public class AccountRecord {
    private Long id;

    /**
     * 账户id, 对应UserAccount表id
     */
    private Long accountId;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 批次号
     */
    private String batchId;
    /**
     * 交易号
     */
    private String tradeNo;
    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 订单号
     */
    private String oderId;

    /**
     * 交易对方
     */
    private String targetName;

    /**
     * 交易对方银行
     */
    private String targetBank;

    /**
     * 交易对方银行卡号
     */
    private String targetBackNo;

    /**
     * 收入
     */
    private Double income;

    /**
     * 支出
     */
    private Double expend;

    /**
     * 余额
     */
    private Double balance;

    /**
     * 币种
     */
    private Integer moneyType;

    /**
     * 创建时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 省份城市
     */
    private String province;

    /**
     * 银行分支名称
     */
    private String bankBranchName;

    /**
     * 付方名称                                                                                                                                                                                                                                                                                                 
     */
    private String paySideName;

    /**
     * 接收方名称
     */
    private String recieveSideName;

    /**
     * 对方电话
     */
    private String targetTel;

    /**
     * 对方电子邮件
     */
    private String targetEmail;

    /**
     * 金额
     */
    private Double amount;

    /**
     * 费用
     */
    private Double charge;

    /**
     * 实际交易金额
     */
    private Double realCharge;

    /**
     * 交易状态
     */
    private Integer status;

    /**
     * 失败原因
     */
    private String failReason;

    /**
     * 备注
     */
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    public String getOderId() {
        return oderId;
    }

    public void setOderId(String oderId) {
        this.oderId = oderId == null ? null : oderId.trim();
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName == null ? null : targetName.trim();
    }

    public String getTargetBank() {
        return targetBank;
    }

    public void setTargetBank(String targetBank) {
        this.targetBank = targetBank == null ? null : targetBank.trim();
    }

    public String getTargetBackNo() {
        return targetBackNo;
    }

    public void setTargetBackNo(String targetBackNo) {
        this.targetBackNo = targetBackNo == null ? null : targetBackNo.trim();
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getExpend() {
        return expend;
    }

    public void setExpend(Double expend) {
        this.expend = expend;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(Integer moneyType) {
        this.moneyType = moneyType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName == null ? null : bankBranchName.trim();
    }

    public String getPaySideName() {
        return paySideName;
    }

    public void setPaySideName(String paySideName) {
        this.paySideName = paySideName == null ? null : paySideName.trim();
    }

    public String getRecieveSideName() {
        return recieveSideName;
    }

    public void setRecieveSideName(String recieveSideName) {
        this.recieveSideName = recieveSideName == null ? null : recieveSideName.trim();
    }

    public String getTargetTel() {
        return targetTel;
    }

    public void setTargetTel(String targetTel) {
        this.targetTel = targetTel == null ? null : targetTel.trim();
    }

    public String getTargetEmail() {
        return targetEmail;
    }

    public void setTargetEmail(String targetEmail) {
        this.targetEmail = targetEmail == null ? null : targetEmail.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public Double getRealCharge() {
        return realCharge;
    }

    public void setRealCharge(Double realCharge) {
        this.realCharge = realCharge;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}