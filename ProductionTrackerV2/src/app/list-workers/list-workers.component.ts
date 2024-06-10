import { Component, OnInit } from '@angular/core';
import { ListWorkersService } from '../list-workers.service';
import { Worker } from '../models/worker.model';

@Component({
  selector: 'app-list-workers',
  templateUrl: './list-workers.component.html',
  styleUrls: ['./list-workers.component.css']
})
export class ListWorkersComponent implements OnInit {
  workers: Worker[] = [];
  worker: Worker | null = null;
  errorMessage: string | null = null;

  constructor(private listWorkersService: ListWorkersService) { }

  ngOnInit(): void {
    this.listWorkersService.getWorkersList().subscribe(
      (workers: Worker[]) => {
        this.workers = workers;
        console.log(this.workers);
      },
      error => {
        console.error('Error fetching workers:', error);
      }
    );
  }

  selectWorker(workerId: number): void {
    console.log('Selected worker ID:', workerId);
    this.listWorkersService.getWorkerById(workerId).subscribe(
      data => {
        this.worker = data;

      },
      error => {
        console.error('Error fetching worker data:', error);
        this.worker = null;
        if (error.status === 404) {
          this.errorMessage = 'Worker not found';
        } else {
          this.errorMessage = 'An error occurred while fetbching worker data ';
        }
      }
    );
  }

  saveChanges(): void {
    if (this.worker) {
      this.listWorkersService.updateWorker(this.worker.id, this.worker).subscribe(
        () => {
          console.log('Worker updated successfullyy');
          this.worker = null;
          this.ngOnInit();
        },
        error => {
          console.error('Error updating worker:', error);
        }
      );
    } else {
      console.error('no worker');
    }
  }
}
