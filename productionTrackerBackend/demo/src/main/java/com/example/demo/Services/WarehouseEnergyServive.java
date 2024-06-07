package com.example.demo.Services;

import java.util.List;

import com.example.demo.WhareHouseEnergyDTO.WarehouseEnergyAPI;

public interface WarehouseEnergyServive {
	public List<WarehouseEnergyAPI> getEnergyData() ;

	double calculateTotalEnergyConsumptionInYear(int year);

	double calculateTotalEnergyConsumption();

	double calculatePercentageTotalEnergyConsumptionInYear(int year);
	

}
