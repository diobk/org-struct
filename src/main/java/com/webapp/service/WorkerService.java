package com.webapp.service;


import com.webapp.entity.Worker;
import com.webapp.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService
{
    private final WorkerRepo workerRepo;

    public WorkerService(WorkerRepo workerRepo)
    {
        this.workerRepo = workerRepo;
    }

    public void save(Worker worker)
    {
        workerRepo.save(worker);
    }

    public Worker findByName (String name)
    {
        return workerRepo.findByName(name);
    }
}
