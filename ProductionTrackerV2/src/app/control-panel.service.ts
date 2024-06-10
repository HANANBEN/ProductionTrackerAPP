import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from './models/car.model';
import { Mission } from './models/mission.model';
import { Worker } from './models/worker.model';
@Injectable({
  providedIn: 'root'
})
export class ControlPanelService {


  private apiUrl = 'http://localhost:50125';

  constructor(private http: HttpClient) {}

  getWorkersList(): Observable<Worker[]> {
    return this.http.get<Worker[]>(`${this.apiUrl}/workers`);
  }

  getMissions(year: number): Observable<Mission[]> {
    return this.http.get<Mission[]>(`${this.apiUrl}/missions/${year}`);
  }
  getMissionsPercentage(year: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/missions/percentage/${year}`);
  }

  getCars(year: number): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.apiUrl}/cars/${year}`);
  }

  getCarsPercentage(year: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/cars/percentage/${year}`);
  }
  getWarehouseEnergyPercentage(year: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/EnergyConsumption/percentage/${year}`);
  }


}
