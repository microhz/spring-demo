package com.xiaoyulaoshishuo.app.kq.support;

/**
 * @author mapc
 * @date 2017年6月14日
 */
public enum AccountTypeEnum {
	RMB(0, "人民币余额");
	private int typeCode;
	private String accountType;

	private AccountTypeEnum(int typeCode, String accountType) {
		this.typeCode = typeCode;
		this.accountType = accountType;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public String getAccountType() {
		return accountType;
	}

}
