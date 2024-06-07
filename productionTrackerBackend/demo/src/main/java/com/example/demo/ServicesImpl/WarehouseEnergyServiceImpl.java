package com.example.demo.ServicesImpl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Services.WarehouseEnergyServive;
import com.example.demo.WhareHouseEnergyDTO.WarehouseEnergyAPI;

@Service
public class WarehouseEnergyServiceImpl implements WarehouseEnergyServive{
	
	   @Autowired
	    private RestTemplate restTemplate;
	   
	   private static final String EXTERNAL_API_URL = "https://6115144daec65d0017e9dcab.mockapi.io/api/wh_enrgy/trans";

@Autowired
	public WarehouseEnergyServiceImpl(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}


	@Override
	public List<WarehouseEnergyAPI> getEnergyData() {
		WarehouseEnergyAPI[] response = restTemplate.getForObject(EXTERNAL_API_URL, WarehouseEnergyAPI[].class);
	        return Arrays.asList(response);
	}
	
	 /*@Override
	    public double calculateTotalEnergyConsumptionInYear(int year) {
	        // Fetch energy data
	        List<WarehouseEnergyAPI> energyData = getEnergyData();
	        
	        // Calculate total energy consumption in 2024
	        double totalEnergyConsumption = energyData.stream() 
	                .filter(data -> {
	                 
	                    LocalDate dataDate = LocalDate.parse((CharSequence) data.getYear());
	                    return dataDate.getYear() == year; // Filter by year
	                })
	                .mapToDouble(WarehouseEnergyAPI::getEnergy)
	                .sum();
	        return totalEnergyConsumption;
	    }*/
	@Override
	public double calculateTotalEnergyConsumptionInYear(int year) {
	
	    List<WarehouseEnergyAPI> energyData = getEnergyData();
	    
	    // Calculate total energy consumption in the specified year
	    double totalEnergyConsumption = energyData.stream() 
	            .filter(data -> {
	                // Convert Date to LocalDate
	                Instant instant = data.getYear().toInstant();
	                ZoneId zoneId = ZoneId.systemDefault(); // Get the system default time zone
	                LocalDate dataDate = instant.atZone(zoneId).toLocalDate();
	                
	                return dataDate.getYear() == year; // Filter by year
	            })
	            .mapToDouble(WarehouseEnergyAPI::getEnergy)
	            .sum();
	    return totalEnergyConsumption;
	}

	@Override
	public double calculateTotalEnergyConsumption() {
	    List<WarehouseEnergyAPI> energyData = getEnergyData();
	    
	    // Calculate total energy consumption across all years
	    double totalEnergyConsumption = energyData.stream()
	            .mapToDouble(WarehouseEnergyAPI::getEnergy)
	            .sum();
	    return totalEnergyConsumption;
	}
	@Override
	public double calculatePercentageTotalEnergyConsumptionInYear(int year) {
	    // Calculate total energy consumption in the specified year
	    double totalEnergyConsumptionInYear = calculateTotalEnergyConsumptionInYear(year);
	    
	    // Calculate total energy consumption across all years
	    double totalEnergyConsumption = calculateTotalEnergyConsumption();
	    
	    // Calculate percentage
	    double percentage = (totalEnergyConsumptionInYear / totalEnergyConsumption) * 100.0;
	    
	    return percentage;
	}

}
