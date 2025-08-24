package com.sanjeeban.DriveMart.ModelDTO;

public class LoginResponse {
	private String responseCode;
	private String responseMsg;
	private String role;
	public LoginResponse() {
		super();
	}
	public LoginResponse(String responseCode, String responseMsg, String role) {
		super();
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
