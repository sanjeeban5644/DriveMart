package com.sanjeeban.DriveMart.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sanjeeban.DriveMart.Enums.FuelType;
import com.sanjeeban.DriveMart.Enums.TransmissionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(
		name="t_engine",
		schema="drivemart_db",
		uniqueConstraints= {
				//@UniqueConstraint(name="")
			}
		)
public class Engine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long engineId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=50)
	private FuelType fuelType;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=50)
	private TransmissionType transmission;
	
	@Column(nullable=false,length=50)
	private String capacity;
	
	@Column(nullable=false,length=50)
	private String mileage;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(nullable=false, updatable=false)
	private LocalDateTime  createdAt;
	
	@JsonIgnore
	@CreationTimestamp
	@Column
	private LocalDateTime  updatedAt;
	
	
	@OneToMany(mappedBy="engineInfo")
	private List<Car> cars = new ArrayList<>();

	public Engine() {
		super();
	}

	

	public Engine(Long engineId, FuelType fuelType, TransmissionType transmission, String capacity, String mileage,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.engineId = engineId;
		this.fuelType = fuelType;
		this.transmission = transmission;
		this.capacity = capacity;
		this.mileage = mileage;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public Long getEngineId() {
		return engineId;
	}

	public void setEngineId(Long engineId) {
		this.engineId = engineId;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public TransmissionType getTransmission() {
		return transmission;
	}

	public void setTransmission(TransmissionType transmission) {
		this.transmission = transmission;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
}
