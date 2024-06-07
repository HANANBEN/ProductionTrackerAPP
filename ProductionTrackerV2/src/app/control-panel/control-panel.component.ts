import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ControlPanelService } from '../control-panel.service';
import { Car } from '../models/car.model';
import { Mission } from '../models/mission.model';

@Component({
  selector: 'app-control-panel',
  templateUrl: './control-panel.component.html',
  styleUrls: ['./control-panel.component.css']
})
export class ControlPanelComponent implements OnInit {
  selectedYear: number = new Date().getFullYear();
  years: number[] = [2021, 2022, 2023, 2024]; //la liste des annees to check
  cars: Car[]=[];
  carsPercentage!: number;
  missions: Mission[]=[];
  missionsPercentage!: number;
  warehouseEnergyPercentage!: number;


  constructor(private controlPanelService: ControlPanelService ,  private router: Router) { }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {

    this.loadMissions();
    this.loadCars();
    this.loadPercentageData();
  }


  loadMissions(): void {
    this.controlPanelService.getMissions(this.selectedYear).subscribe(missions => this.missions = missions);
  }

  loadCars(): void {
    this.controlPanelService.getCars(this.selectedYear).subscribe(cars => this.cars = cars);
  }


  loadPercentageData(): void {
    this.loadCarsPercentage();
    this.loadMissionsPercentage();
    this.loadWarehouseEnergyPercentage();
  }

  loadCarsPercentage(): void {
    this.controlPanelService.getCarsPercentage(this.selectedYear).subscribe(percentage => this.carsPercentage = percentage);
  }

  loadMissionsPercentage(): void {
    this.controlPanelService.getMissionsPercentage(this.selectedYear).subscribe(percentage => this.missionsPercentage = percentage);
  }

  loadWarehouseEnergyPercentage(): void {
    this.controlPanelService.getWarehouseEnergyPercentage(this.selectedYear).subscribe(percentage => this.warehouseEnergyPercentage = percentage);
  }

  onYearChange(event: any): void {
    const year = event?.target?.value;
    if (year) {
      this.selectedYear = parseInt(year, 10);
      this.loadData();
    }
}

}
