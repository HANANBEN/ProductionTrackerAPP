package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Car;

public interface CarService {
	public List<Car> getAllCarList();
    public  Car saveCar(Car  car );
    public Car getCarById(Long id);
    public Car editCar(Car car) ;
    public Long countCars();
    public void deleteCarById(Long id);
    List<Car> findByDeliveryDate(int year);
    double CountPercentage(int year);
}
