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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name="t_color",
		schema="drivemart_db",
		uniqueConstraints= {
				@UniqueConstraint(name="unique_color",columnNames= {"colorName"})
			}
		)
public class Color {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long colorId;
	
	
	@Column(nullable=false,length=50)
	private String colorName;
	
	@Column(nullable=false,length=250)
	private String colorDescription;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(nullable=false, updatable=false)
	private LocalDateTime  createdAt;
	
	@JsonIgnore
	@CreationTimestamp
	@Column
	private LocalDateTime  updatedAt;
	
	@ManyToMany(mappedBy="colors")   //inverse side
	private List<Car> cars  = new ArrayList<>();

	public Color() {
		super();
	}

	public Color(Long colorId, String colorName, String colorDescription, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.colorId = colorId;
		this.colorName = colorName;
		this.colorDescription = colorDescription;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getColorId() {
		return colorId;
	}

	public void setColorId(Long colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorDescription() {
		return colorDescription;
	}

	public void setColorDescription(String colorDescription) {
		this.colorDescription = colorDescription;
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
