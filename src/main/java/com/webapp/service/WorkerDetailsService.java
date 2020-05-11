package com.webapp.service;

import com.webapp.entity.Worker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WorkerDetailsService implements UserDetailsService
{
    private final WorkerService workerService;

    public WorkerDetailsService(WorkerService workerService)
    {
        this.workerService = workerService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException
    {
        Worker worker = workerService.findByName(name);
        if (worker == null)
            throw new UsernameNotFoundException("not found user with " + name);

        System.out.println("user auth " + worker.getName());

        return worker;
    }
}
