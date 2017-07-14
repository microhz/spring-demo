package com.xiaoyulaoshishuo.app.kq.support;

/**
 * @author mapc
 * @date 2017年6月15日
 */
public enum TradeTypeEnum {
	
	ALL(0,"所有交易类型"),
	OTHER(1,"其他"),
	BALANCE_COLLECTION(2,"资金归集"),
	BALANCE_UNDER(3, "资金下拨"),
	CHARGE(4, "账户充值"),
	WITHDRAW(5,"账户提现"),
	PAY_TO_BANK(6,"付款到银行账户"),
	PAY_GATEWAY(7,"支付到网关"),
	REFUND(8, "退款"),
	GATEWAY_REFUND(9,"支付网关退款"),
	PAY_KQ_ACCOUNT(10,"支付到快钱账户"),
	BATCH_PAY_KQ(11, "批量支付到快钱账户"),
	BATCH_BANK(12, "批量付款到银行账户"),
	KQ_CHAINE(13,"快钱链"),
	ENTRUST(14 , "委托代收"),
	ENTRUST_RECIEVED(15, "委托代收签约");

	private Integer code;
	private String name;
	private TradeTypeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	public Integer getCode() {
		return code;
	}
	public String getName() {
		return name;
	}


}
