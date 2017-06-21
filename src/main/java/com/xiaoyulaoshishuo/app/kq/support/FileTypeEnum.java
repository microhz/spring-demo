package com.xiaoyulaoshishuo.app.kq.support;
/**
 * @author mapc 
 * @date 2017年6月15日
 */
public enum FileTypeEnum {
	
	DOWN_SEARCH(0,"下载查询"),
	
	COLLECT_DETAIL(1, "汇总表"),
	TRADE_DETAIL(2, "交易明细"),
	GATEWAY_DETAIL(3, "分账网关交易明细表");

	private int code;
	private String name;
	private FileTypeEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
