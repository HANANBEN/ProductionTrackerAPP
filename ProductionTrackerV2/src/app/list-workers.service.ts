import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Worker } from './models/worker.model';
@Injectable({
  providedIn: 'root'
})
export class ListWorkersService {



  private apiUrl = 'http://localhost:50125';

  constructor(private http: HttpClient) {}

  getWorkersList(): Observable<Worker[]> {
    return this.http.get<Worker[]>(`${this.apiUrl}/workers`);
  }
  getWorkerById(id: number): Observable<Worker> {
    const url = `${this.apiUrl}/worker/${id}`;
    return this.http.get<Worker>(url).pipe(
      catchError(error => {
        console.error('Error fetching worker:', error);
        return throwError(error);
      })
    );
  }

  updateWorker(id: number, updatedWorker: Worker): Observable<any> {
    const url = `${this.apiUrl}/worker/edit/${id}`;
    return this.http.put(url, updatedWorker).pipe(
      catchError(error => {
        console.error('Error updating worker:', error);
        return throwError(error);
      })
    );
  }
}
