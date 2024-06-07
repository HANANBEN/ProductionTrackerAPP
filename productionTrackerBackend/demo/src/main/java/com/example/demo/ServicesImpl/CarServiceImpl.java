package com.example.demo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CarRepository;
import com.example.demo.Services.CarService;
import com.example.demo.entities.Car;
@Service
public class CarServiceImpl implements CarService {
	@Autowired
	CarRepository carrep;

	@Override
	public List<Car> getAllCarList() {
		// TODO Auto-generated method stub
		return carrep.findAll();
	}

	@Override
	public Car saveCar(Car car) {
		// TODO Auto-generated method stub
		return carrep.save(car);
	}

	@Override
	public Car getCarById(Long id) {
		// TODO Auto-generated method stub
		return carrep.getById(id);
	}

	@Override
	public Car editCar(Car car) {
		// TODO Auto-generated method stub
		return carrep.save(car);
	}

	@Override
	public Long countCars() {
		// TODO Auto-generated method stub
		return  carrep.count();
	}

	@Override
	public void deleteCarById(Long id) {
		// TODO Auto-generated method stub
		carrep.deleteById(id);
		
	}
    @Autowired
	public CarServiceImpl(CarRepository carrep) {
		super();
		this.carrep = carrep;
	}

	public CarServiceImpl() {
		super();
	}

	@Override
	public List<Car> findByDeliveryDate(int year) {
		// TODO Auto-generated method stub
		return carrep.findByDeliveryDateYear(year);
	}

	@Override
	public double CountPercentage(int year) {
	    long totalCars = carrep.count();
	    //we can't divide by a 0
	    if (totalCars == 0) {
	        return 0.0; 
	    }
	    // Count number of cars delivered in the specified year
	    int carsDeliveredInYear = carrep.CountByDeliveryDateYear(year) ;
	    // Calculate percentage
	    double percentage = ((double) carsDeliveredInYear / totalCars) * 100.0;
	    
	    return percentage;
	}
	

}
