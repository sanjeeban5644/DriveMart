package com.sanjeeban.DriveMart.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeeban.DriveMart.Entity.Car;
import com.sanjeeban.DriveMart.ModelDTO.AddCarRequest;
import com.sanjeeban.DriveMart.ModelDTO.CMCResponse;
import com.sanjeeban.DriveMart.ModelDTO.DeleteCarRequest;
import com.sanjeeban.DriveMart.ModelDTO.DeleteCarResponse;
import com.sanjeeban.DriveMart.Services.ManageCarService;

@RestController
@RequestMapping("/cmc")//cmc -> car management controller
@CrossOrigin(origins="*")
public class CarManagementController {

	@Autowired
	ManageCarService manageCarService;
	
	@PostMapping("/saveCar")
	public CMCResponse addCars(@RequestBody AddCarRequest request) {
		CMCResponse response = new CMCResponse();
		
		if(request==null) {
			response.setResponseCode("500");
			response.setResponseMsg("Null Request");
			return response;
		}
		
		try {
			response = manageCarService.addCar(request);
			response.setResponseCode("200");
			response.setResponseMsg("Saved successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	
	@GetMapping("/showAllCars")
	public List<Car> getAllCars(){
		List<Car> list = new ArrayList<>();
	
		try {
			list = manageCarService.showAllCars();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@DeleteMapping("/deleteCar")
	public DeleteCarResponse deleteCar(@RequestParam(required=true) String carBrand, @RequestParam(required=true) String carModel) {
		DeleteCarRequest dcRequest = new DeleteCarRequest();
		DeleteCarResponse response = new DeleteCarResponse();		
		
		Car car = new Car();
		
		dcRequest.setCarBrand(carBrand);
		dcRequest.setCarModel(carModel);
		
		try {
			car = manageCarService.deleteCar(dcRequest);
			if(car==null) {
				response.setResponseCode("404");
				response.setResponseMsg("Invalid Car details provided");
				response.setCar(car);
			}else {
				response.setResponseCode("200");
				response.setResponseMsg("Successfully deleted Car");
				response.setCar(car);
			}
		}catch(Exception e) {
			response.setResponseCode("500");
			response.setResponseMsg("Exception in Controller Method");
			e.printStackTrace();
		}

		return response;
	}
	
	
	
}
