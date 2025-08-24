package com.sanjeeban.DriveMart.ModelDTO;

import java.math.BigDecimal;

public class AddCarRequest {
	private Long id; // BIGINT UNSIGNED -> use Long in Java
	private String brand; // VARCHAR(100)
	private String model; // VARCHAR(100)
	private Integer modelYear; // YEAR -> Integer
	private BigDecimal price; // DECIMAL(10,2) -> BigDecimal
	private Boolean availability; // TINYINT(1) -> Boolean (1=true, 0=false)
	private String fuelType; // VARCHAR(100)
	private String transmission; // VARCHAR(100)
	private String description; // VARCHAR(240)

	public AddCarRequest() {
		super();
	}

	public AddCarRequest(Long id, String brand, String model, Integer modelYear, BigDecimal price, Boolean availability,
			String fuelType, String transmission, String description) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.modelYear = modelYear;
		this.price = price;
		this.availability = availability;
		this.fuelType = fuelType;
		this.transmission = transmission;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
