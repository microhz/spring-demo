package com.xiaoyulaoshishuo.app.kq.support;

/**
 * @author mapc
 * @date 2017年6月15日
 */
public enum TimeRangeEnum {

	RECENT_MONTH(0, "最近一个月"), RENCENT_THREE_MONTH(1, "最近三个月"), RECENT_HALF_YEAR(2, "最近半年"), RECENT_YEAD(3, "最近一年");

	private Integer val;
	private String name;

	private TimeRangeEnum(Integer val, String name) {
		this.val = val;
		this.name = name;
	}

	public Integer getVal() {
		return val;
	}

	public String getName() {
		return name;
	}

}
