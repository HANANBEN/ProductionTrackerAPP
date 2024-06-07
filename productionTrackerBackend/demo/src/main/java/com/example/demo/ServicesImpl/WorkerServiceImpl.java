package com.example.demo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.MissionRepository;
import com.example.demo.Repositories.WorkerRepository;
import com.example.demo.Services.WorkerService;
import com.example.demo.entities.Worker;

@Service
public class WorkerServiceImpl implements WorkerService {
	
	
     @Autowired
     WorkerRepository wrkrep;
     
    
    @Autowired
    public WorkerServiceImpl(WorkerRepository wrkrep) {
		super();
		this.wrkrep = wrkrep;
	}

	@Override
    public Worker saveWorker(Worker worker) {
       return wrkrep.save(worker);
    }

    @Override
    public Worker getWorkerById(Long id) {
        return wrkrep.findById(id).get();
    }

    @Override
    public Worker editWorker(Worker worker) {
       return wrkrep.save(worker);
    }

    @Override
    public Long countWorkers() {
       return wrkrep.count();
    }

    @Override
    public void deleteWorkerById(Long id) {
    wrkrep.delete(wrkrep.findById(id).get());
    }

    @Override
    public List<Worker> getAllWorkerList() {
       return wrkrep.findAll();
    }

	
   

}
