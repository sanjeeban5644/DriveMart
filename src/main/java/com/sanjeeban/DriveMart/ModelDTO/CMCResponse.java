package com.sanjeeban.DriveMart.ModelDTO;

public class CMCResponse {
	private String responseCode;
	private String responseMsg;
	private AddCarRequest request;
	public CMCResponse() {
		super();
	}
	public CMCResponse(String responseCode, String responseMsg, AddCarRequest request) {
		super();
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
	public AddCarRequest getRequest() {
		return request;
	}
	public void setRequest(AddCarRequest request) {
		this.request = request;
	}
}
