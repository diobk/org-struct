package com.webapp.service;


import com.webapp.entity.Department;
import com.webapp.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService
{
    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo)
    {
        this.departmentRepo = departmentRepo;
    }

    public void save (Department department)
    {
        departmentRepo.save(department);
    }

    public Department findByName(String name)
    {
        return departmentRepo.findByName(name);
    }
}
