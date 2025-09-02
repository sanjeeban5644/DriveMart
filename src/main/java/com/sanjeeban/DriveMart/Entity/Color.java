package com.sanjeeban.DriveMart.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sanjeeban.DriveMart.Enums.ColorType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=50)
	private ColorType colorName;
	
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

	public Color(Long colorId, ColorType colorName, String colorDescription, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

	public ColorType getColorName() {
		return colorName;
	}

	public void setColorName(ColorType colorName) {
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
