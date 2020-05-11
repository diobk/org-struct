package com.webapp.controllers;

import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.service.WorkerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{
    private final WorkerService workerService;

    public MainController(WorkerService workerService)
    {
        this.workerService = workerService;
    }

    @GetMapping("/main")
    public String getMain(@AuthenticationPrincipal Worker worker, Model model)
    {
        model.addAttribute("GEN_DIR", workerService.findByRole(Role.GEN_DIR));
        model.addAttribute("DIR", workerService.findByRole(Role.DIR));
        model.addAttribute("WORKER", workerService.findByRole(Role.WORKER));
        model.addAttribute("workers", workerService.findAll());
        model.addAttribute("auth", worker);
        return "main";
    }

    @GetMapping("/")
    public String index()
    {
        return "redirect:/main";
    }
}
