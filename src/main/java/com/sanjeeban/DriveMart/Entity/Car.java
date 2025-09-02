package com.sanjeeban.DriveMart.Entity;

import java.awt.color.ColorSpace;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name="t_car",
		schema="drivemart_db",
		uniqueConstraints = {
				
			}
		)
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carId;
	
	
	@ManyToOne
	@JoinColumn(name="brand_info",
				referencedColumnName="brandId",
				foreignKey = @ForeignKey(name="FK_CAR_BRAND"),
				nullable=false
			)//owning side
	private Brand brandInfo;
	
	@Column(nullable=false, length=50)
	private String model;
	
	@Column(nullable=false, length=50)
	private String price;
	
	@Column(nullable=false, length=20)
	private String availability;
	
	@ManyToOne
	@JoinColumn(
			name="engine_info",
			referencedColumnName="engineId",
			nullable=false
			)
	private Engine engineInfo;
	
	@ManyToMany
	@JoinTable(
			name="t_car_color",
			schema="drivemart_db",
			joinColumns= @JoinColumn(
					name="car_id",  //owning side
					referencedColumnName = "carId"
					),
			inverseJoinColumns = @JoinColumn(
					name="color_id",
					referencedColumnName="colorId"
					),
			uniqueConstraints  = @UniqueConstraint(
					name="unique_car_color",
					columnNames = {"car_id","color_id"}
					)
			)
	private List<Color> colors;
	
	
	@CreationTimestamp
	@Column(nullable=false, updatable=false)
	private LocalDateTime  createdAt;
	
	
	@CreationTimestamp
	@Column
	private LocalDateTime  updatedAt;

	public Car() {
		super();
	}

	public Car(Long carId, Brand brandInfo, String model, String price, String availability, Engine engineInfo,
			List<Color> colors, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.carId = carId;
		this.brandInfo = brandInfo;
		this.model = model;
		this.price = price;
		this.availability = availability;
		this.engineInfo = engineInfo;
		this.colors = colors;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Brand getBrandInfo() {
		return brandInfo;
	}

	public void setBrandInfo(Brand brandInfo) {
		this.brandInfo = brandInfo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Engine getEngineInfo() {
		return engineInfo;
	}

	public void setEngineInfo(Engine engineInfo) {
		this.engineInfo = engineInfo;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
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
