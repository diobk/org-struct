package com.webapp.controllers.worker;

import com.webapp.service.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/worker")
public class DeleteWorkerController
{
    private final WorkerService workerService;

    public DeleteWorkerController(WorkerService workerService)
    {
        this.workerService = workerService;
    }

    @GetMapping("/delete/{id}")
    public String deleteWorker(@PathVariable("id") Long id)
    {
        workerService.deleteById(id);
        return "redirect:/main";
    }
}
