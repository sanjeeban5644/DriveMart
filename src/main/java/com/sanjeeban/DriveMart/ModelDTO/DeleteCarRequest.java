package com.sanjeeban.DriveMart.ModelDTO;

public class DeleteCarRequest {
	private String carBrand;
	private String carModel;
	public DeleteCarRequest() {
		super();
	}
	public DeleteCarRequest(String carBrand, String carModel) {
		super();
		this.carBrand = carBrand;
		this.carModel = carModel;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	
}
