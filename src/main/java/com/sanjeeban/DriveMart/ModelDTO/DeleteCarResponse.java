package com.sanjeeban.DriveMart.ModelDTO;

import com.sanjeeban.DriveMart.Entity.Car;

public class DeleteCarResponse {
	
	private String responseCode;
	private String responseMsg;
	private Car car;
	public DeleteCarResponse() {
		super();
	}
	public DeleteCarResponse(String responseCode, String responseMsg, Car car) {
		super();
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
		this.car = car;
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
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	
	
}
