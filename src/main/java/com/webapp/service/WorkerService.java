package com.webapp.service;


import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repo.DepartmentRepo;
import com.webapp.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService
{
    private final WorkerRepo workerRepo;

    public WorkerService(WorkerRepo workerRepo)
    {
        this.workerRepo = workerRepo;
    }

    public boolean save(Worker worker)
    {
        if (worker.getName() != null && !worker.getName().isEmpty() &&
                worker.getLastname() != null && !worker.getLastname().isEmpty() &&
                worker.getPassword() != null && !worker.getPassword().isEmpty() &&
                worker.getRole() != null && worker.getDepartment() != null && worker.getPost() != null)
        {
            workerRepo.save(worker);
            return true;
        }
        return false;
    }

    public Worker findByName (String name)
    {
        return workerRepo.findByName(name);
    }

    public List<Worker> findByRole(Role role)
    {
        return workerRepo.findByRole(role);
    }

    public List<Worker> findAll()
    {
        return workerRepo.findAll();
    }

    public Worker findById(Long id)
    {
        if (workerRepo.findById(id).isEmpty())
            return null;
        return workerRepo.findById(id).get();
    }

    public void deleteById(Long id)
    {
        Worker worker = workerRepo.findWorkerById(id);
        if (worker.getRole().equals(Role.DIR))
        {
            List<Worker> workers = workerRepo.findByDepartment(worker.getDepartment());
            int size = workers.size();

            workers.removeIf(w -> w.getRole().equals(Role.WORKER));

            if (size == workers.size())
                workerRepo.deleteById(id);
        }
        else if (worker.getRole().equals(Role.WORKER))
            workerRepo.deleteById(id);
    }
}
