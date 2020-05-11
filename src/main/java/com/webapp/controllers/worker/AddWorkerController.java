package com.webapp.controllers.worker;

import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.service.DepartmentService;
import com.webapp.service.PostService;
import com.webapp.service.WorkerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/worker")
public class AddWorkerController
{
    private final WorkerService workerService;
    private final DepartmentService departmentService;
    private final PostService postService;
    private final PasswordEncoder passwordEncoder;

    public AddWorkerController(WorkerService workerService, DepartmentService departmentService, PostService postService, PasswordEncoder passwordEncoder)
    {
        this.workerService = workerService;
        this.departmentService = departmentService;
        this.postService = postService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/add")
    public String addWorker(Model model)
    {
        model.addAttribute("roles", Role.values());
        model.addAttribute("departments", departmentService.findWithoutGen());
        model.addAttribute("posts", postService.findWithoutGen());
        return "addWorker";
    }

    @PostMapping("/add")
    public String addWorker(@RequestParam String name,
                                @RequestParam String lastname,
                                @RequestParam String password,
                                @RequestParam Role role,
                                @RequestParam String department,
                                @RequestParam String post)
    {
        workerService.save(
                new Worker(name,
                        lastname,
                        passwordEncoder.encode(password),
                        role,
                        departmentService.findByName(department),
                        postService.findByName(post)));
        return "redirect:/worker/add";
    }
}
