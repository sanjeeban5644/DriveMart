package com.sanjeeban.DriveMart.ModelDTO;

import com.sanjeeban.DriveMart.Entity.Car;

public class CMCResponse {
	private String responseCode;
	private String responseMsg;
	private Car request;
	public CMCResponse() {
		super();
	}

	public CMCResponse(String responseCode, String responseMsg, Car request) {
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
		this.request = request;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public Car getRequest() {
		return request;
	}

	public void setRequest(Car request) {
		this.request = request;
	}
}
