package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Worker;

public interface WorkerService {

 public List<Worker> getAllWorkerList();
    public  Worker saveWorker(Worker   worker );
    public Worker getWorkerById(Long id);
    public Worker editWorker(Worker worker) ;
   
    public Long countWorkers();
    public void deleteWorkerById(Long id);
}
