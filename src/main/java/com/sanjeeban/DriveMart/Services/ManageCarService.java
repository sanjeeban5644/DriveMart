package com.sanjeeban.DriveMart.Services;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sanjeeban.DriveMart.Entity.Car;
import com.sanjeeban.DriveMart.ModelDTO.AddCarRequest;
import com.sanjeeban.DriveMart.ModelDTO.CMCResponse;
import com.sanjeeban.DriveMart.ModelDTO.DeleteCarRequest;
import com.sanjeeban.DriveMart.Repository.CarRepository;

import ch.qos.logback.classic.Logger;
import jakarta.transaction.Transactional;

@Component
@Service
@Transactional
public class ManageCarService {
	
	@Autowired
	private CarRepository carRepository;
	
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ManageCarService.class);

	public CMCResponse addCar(AddCarRequest request) {
		CMCResponse response = new CMCResponse();
		
		Car newCar = new Car();
		
		try {
//			newCar.setId(request.getId());
//			newCar.setBrand(request.getBrand());
//			newCar.setModel(request.getModel());
//			newCar.setModel_year(request.getModelYear());
//			newCar.setPrice(request.getPrice());
//			newCar.setAvailability(request.getAvailability());
//			newCar.setFuel_type(request.getFuelType());
//			newCar.setTransmission(request.getTransmission());
//			newCar.setDescription(request.getDescription());
			carRepository.save(newCar);
			
			// setting response
			response.setRequest(request);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	public List<Car> showAllCars(){
		List<Car> list = new ArrayList<>();
		
		list = carRepository.findAll();
		
		return list;
	}

	public Car deleteCar(DeleteCarRequest dcRequest) {
		Car carDeleted = new Car();
		
		String carBrand = dcRequest.getCarBrand();
		String carModel = dcRequest.getCarModel();
		
		
		try {
			//carDeleted = carRepository.findCarByBrandAndModel(carBrand,carModel);
			
			//int code = carRepository.deleteCarByBrandAndModel(carBrand, carModel);
			logger.info("code for delete is : "/*+code*/);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return carDeleted;
	}
	
	
	
	
}
