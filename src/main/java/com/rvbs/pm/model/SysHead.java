package com.rvbs.pm.model;

/**
 * 系统头Bean
 * @author xiaole
 *
 */
public class SysHead {
	/** 请求日期 */
	private String requestData;
	/** 请求时间 */
	private String requestTime;
	/** 通讯流水号 */
	private String conSumerSeqNo;
	/** 返回码 */
	private String returnCode;
	/** 返回消息 */
	private String returnMsg;
	/** 服务码 */
	private String serviceCode;
	
	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getConSumerSeqNo() {
		return conSumerSeqNo;
	}

	public void setConSumerSeqNo(String conSumerSeqNo) {
		this.conSumerSeqNo = conSumerSeqNo;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public SysHead setReturnCode(String returnCode) {
		this.returnCode = returnCode;
		return this;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public SysHead setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
		return this;
	}
	
}
