package com.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/worker")
public class WorkerController
{
    @GetMapping("/add")
    public String addWorker()
    {
        return "";
    }

    @GetMapping("/delete")
    public String deleteWorker()
    {
        return "";
    }
}
