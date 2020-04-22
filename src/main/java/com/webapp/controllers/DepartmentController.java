package com.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/department")
public class DepartmentController
{
    @GetMapping("/add")
    public String addDepartment()
    {
        return "";
    }

    @GetMapping("/delete")
    public String deleteDepartment()
    {
        return "";
    }
}
