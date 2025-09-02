package com.sanjeeban.DriveMart.Repository;

import com.sanjeeban.DriveMart.Enums.ColorType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeeban.DriveMart.Entity.Color;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color,Long>{
    Optional<Color> findByColorName(ColorType colorName);
}
