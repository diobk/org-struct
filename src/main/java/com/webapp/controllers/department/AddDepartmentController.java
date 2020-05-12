package com.webapp.controllers.department;

import com.webapp.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/department")
public class AddDepartmentController
{
    private final DepartmentService departmentService;

    public AddDepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public String addDepartment(@RequestParam String department)
    {
        if (departmentService.findByName(department) == null)
        {
            departmentService.save(department);
            return "redirect:/department/add";
        }
        return "redirect:/department/add?error";
    }
}
