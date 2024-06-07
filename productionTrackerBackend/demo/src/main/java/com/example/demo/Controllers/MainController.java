package com.example.demo.Controllers;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Services.CarService;
import com.example.demo.Services.MissionService;
import com.example.demo.Services.WarehouseEnergyServive;
import com.example.demo.Services.WorkerService;
import com.example.demo.WhareHouseEnergyDTO.WarehouseEnergyAPI;
import com.example.demo.entities.Car;
import com.example.demo.entities.Mission;
import com.example.demo.entities.Worker;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

	
	@Autowired
	 public MainController(CarService carService) {
		super();
		this.carService = carService;
	}

	@Autowired
	    private CarService carService;
	@Autowired
    private WorkerService workerService;
	@Autowired
    private MissionService missionService;
	
	@Autowired
	WarehouseEnergyServive weser;
	
	    @GetMapping("/workers")
	    public List<Worker> getAllWorkers() {
	        return workerService.getAllWorkerList();
	    }

	    @PostMapping("/cars")
	    public List<Car> getAllCars2() {
	        return carService.getAllCarList();
	    }
	
	    @GetMapping("/wherehouse")
	    public List<WarehouseEnergyAPI> getWherehouseEnergy() {
	        return weser.getEnergyData();
	    }
	    
	    @GetMapping("/missions/{year}")
	    public List<Mission> listMissions(@PathVariable int year){
			return missionService.EndMissions(year);
	    	
	    }
	    
	    
	    @GetMapping("/cars/{year}")
	    public List<Car> listCars(@PathVariable int year){
			return carService.findByDeliveryDate(year);
	    	
	    }
	    @GetMapping("/cars/percentage/{year}")
	    public double  CarsPercentage(@PathVariable int year){
	    	
			return carService.CountPercentage(year);
	    	
	    }
	    @GetMapping("/missions/percentage/{year}")
	    public double  MissionsPercentage(@PathVariable int year){
	    	
			return missionService.calculateMissionsPercentage(year);
	    	
	    }
	    
	    @GetMapping("/EnergyConsumption/percentage/{year}")
	    public double  EnergyConsumption(@PathVariable int year){
	    	
			return weser.calculatePercentageTotalEnergyConsumptionInYear(year) ;
	    	
	    }
	    @GetMapping("/worker/{id}")
	    public  ResponseEntity<Worker>  getWorker(@PathVariable Long id){
	    	 Worker worker = workerService.getWorkerById(id);
	         return ResponseEntity.ok(worker);
	    }
	    
	    @PutMapping("/worker/edit/{id}")
	    public ResponseEntity<Void> updateWorker(@PathVariable Long id, @RequestBody Worker updatedWorker) {
	        Worker existingWorker = workerService.getWorkerById(id);
	           
	        existingWorker.setFirstName(updatedWorker.getFirstName());
	        existingWorker.setLastname(updatedWorker.getLastname());
	       
	        workerService.editWorker(existingWorker);

	        return ResponseEntity.noContent().build();
	    }	    
}