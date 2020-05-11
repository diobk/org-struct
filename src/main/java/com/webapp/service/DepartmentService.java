package com.webapp.service;

import com.webapp.entity.Department;
import com.webapp.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService
{
    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo)
    {
        this.departmentRepo = departmentRepo;
    }

    public Boolean save (String department)
    {
        if (department != null && !department.isEmpty())
        {
            departmentRepo.save(new Department(department));
            return true;
        }
        return false;
    }

    public List<Department> findAll()
    {
        return departmentRepo.findAll();
    }

    public Department findByName(String name)
    {
        System.out.println(departmentRepo.findByName(name) == null);
        return departmentRepo.findByName(name);
    }

    public List<Department> findWithoutGen()
    {
        List<Department> departments = departmentRepo.findAll();
        departments.removeIf(department -> department.getName().equals("отдел генерального"));
        return departments;
    }

    public void deleteByName(String department)
    {
        departmentRepo.delete(findByName(department));
    }
}
