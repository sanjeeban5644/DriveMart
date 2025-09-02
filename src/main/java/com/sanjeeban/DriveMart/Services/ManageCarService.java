package com.sanjeeban.DriveMart.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import com.sanjeeban.DriveMart.Entity.Brand;
import com.sanjeeban.DriveMart.Entity.Color;
import com.sanjeeban.DriveMart.Entity.Engine;
import com.sanjeeban.DriveMart.Enums.ColorType;
import com.sanjeeban.DriveMart.Repository.BrandRepository;
import com.sanjeeban.DriveMart.Repository.ColorRepository;
import com.sanjeeban.DriveMart.Repository.EngineRepository;
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

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private ColorRepository colorRepository;

	@Autowired
	private EngineRepository engineRepository;
	
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ManageCarService.class);

	public CMCResponse addCar(Car request) {
		CMCResponse response = new CMCResponse();
		
		Car newCar = new Car();
		
		try {
			// inserting brand info

			Brand brand = new Brand();
			brand.setBrandName(request.getBrandInfo().getBrandName());
			brand.setCountryOfOrigin(request.getBrandInfo().getCountryOfOrigin());
			brand.setEstablishedYear(request.getBrandInfo().getEstablishedYear());

			newCar.setBrandInfo(brand);
			brandRepository.save(brand);

			// setting engine info

			Engine engine = new Engine();
			engine.setFuelType(request.getEngineInfo().getFuelType());
			engine.setTransmission(request.getEngineInfo().getTransmission());
			engine.setCapacity(request.getEngineInfo().getCapacity());
			engine.setMileage(request.getEngineInfo().getMileage());

			newCar.setEngineInfo(engine);
			engineRepository.save(engine);

			// setting color info
			List<Color> newColorList = new ArrayList<>();
			int i = 0;
			int colorList = request.getColors().size();
			while(i<colorList){
				Color color = getOrCreateColor(
						request.getColors().get(i).getColorName(),
						request.getColors().get(i).getColorDescription()
				);
				newColorList.add(color);
				i+=1;
			}
			newCar.setColors(newColorList);



			// setting rest main body info
			newCar.setModel(request.getModel());
			newCar.setPrice(request.getPrice());
			newCar.setAvailability(request.getAvailability());
			newCar.setCreatedAt(LocalDateTime.now());
			newCar.setUpdatedAt(LocalDateTime.now());

			newCar.setAvailability(request.getAvailability());

			carRepository.save(newCar);

			response.setRequest(request);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	public Color getOrCreateColor(ColorType colorName,String desc){
		return colorRepository.findByColorName(colorName)
				.orElseGet(() -> {
					Color color = new Color();
					color.setColorName(colorName);
					color.setColorDescription(desc);
					return colorRepository.save(color);
				});
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
