// edit-worker.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ListWorkersService } from '../list-workers.service';
import { Worker } from '../models/worker.model';

@Component({
  selector: 'app-edit-worker',
  templateUrl: './edit-worker.component.html',
  styleUrls: ['./edit-worker.component.css']
})
export class EditWorkerComponent implements OnInit {
  worker: Worker | null = null;
  workerId!: number;
  errorMessage!: string;

  constructor(
    private route: ActivatedRoute,
    private workerService: ListWorkersService,
    private router: Router
  ) {}


  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const idParam = params.get('id');
      console.log('Route parameter id:', idParam); //check if the id is well recuperer from the router
      if (idParam !== null) {
        const id = Number(idParam);
        console.log('Converted ID:', id); // we need to convert it to a number in order to call methodes who need an id number
        if (isNaN(id) || id <= 0) {
          this.errorMessage = 'Invalid worker ID';
          return;
        }
        this.workerId = id;
        this.loadWorker();
      } else {
        this.errorMessage = 'No worker ID provided';
      }
    });
  }

  loadWorker(): void {
    this.workerService.getWorkerById(this.workerId).subscribe(
      data => {
        this.worker = data;
      },
      error => {
        console.error('Error fetching worker data:', error);
        if (error.status === 404) {
          this.errorMessage = 'Worker not found';
        } else {
          this.errorMessage = 'An error occurred while fetching worker data';
        }
      }
    );
  }


  saveChanges(): void {
    if (this.worker && this.workerId !== null) {
      this.workerService.updateWorker(this.workerId, this.worker).subscribe(
        () => {
          console.log('Worker updated successfully');
          this.router.navigate(['/workers']);
        },
        error => console.error('Error updating worker:', error)
      );
    } else {
      console.error('Worker or Worker ID is null');
    }
  }
}
