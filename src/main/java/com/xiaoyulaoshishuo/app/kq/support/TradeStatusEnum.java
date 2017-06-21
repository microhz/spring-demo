package com.xiaoyulaoshishuo.app.kq.support;

/**
 * @author mapc
 * @date 2017年6月15日
 */
public enum TradeStatusEnum {

	SUCCESS(0, "交易成功"), DOING(1, "交易进行中"), FAIL(2, "交易失败");

	private int val;
	private String name;

	private TradeStatusEnum(int val, String name) {
		this.val = val;
		this.name = name;
	}

	public int getVal() {
		return val;
	}

	public String getName() {
		return name;
	}

}
