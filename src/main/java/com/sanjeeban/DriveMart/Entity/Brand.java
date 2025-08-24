package com.sanjeeban.DriveMart.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name="t_brand",
		schema="drivemart_db",
		uniqueConstraints= {
				@UniqueConstraint(name="unique_brandName", columnNames= {"brandName"})
			}
		)
public class Brand {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long brandId;
	
	@Column(nullable=false,length=50)
	private String brandName;
	
	@Column(nullable=false,length=50)
	private String countryOfOrigin;
	
	@Column(nullable=false,length=4)
	private String establishedYear;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(nullable=false, updatable=false)
	private LocalDateTime  createdAt;
	
	@JsonIgnore
	@CreationTimestamp
	@Column
	private LocalDateTime  updatedAt;
	
	@OneToMany(mappedBy="brandInfo")//inverse side
	private List<Car> cars = new ArrayList<>();
	

	public Brand() {
		super();
	}

	public Brand(Long brandId, String brandName, String countryOfOrigin, String establishedYear,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.countryOfOrigin = countryOfOrigin;
		this.establishedYear = establishedYear;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getEstablishedYear() {
		return establishedYear;
	}

	public void setEstablishedYear(String establishedYear) {
		this.establishedYear = establishedYear;
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
