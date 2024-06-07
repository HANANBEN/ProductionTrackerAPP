import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ListWorkersService } from '../list-workers.service';
import { Worker } from '../models/worker.model';

@Component({
  selector: 'app-list-workers',
  templateUrl: './list-workers.component.html',
  styleUrl: './list-workers.component.css'
})
export class ListWorkersComponent  implements OnInit {
  workers: Worker[] = [];


  constructor(private listworkersService: ListWorkersService , private router: Router) { }

  ngOnInit(): void {


    this.listworkersService.getWorkersList().subscribe(
      (workers: Worker[]) => {
        this.workers = workers;
      },
      (error) => {
        console.error('Error fetching workers:', error);
      }
    );
  }


  editWorker(workerId: number): void {
    console.log('Edit worker with ID:', workerId);
    this.router.navigate(['/edit-worker', workerId]);
  }
}
