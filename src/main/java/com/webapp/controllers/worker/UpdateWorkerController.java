package com.webapp.controllers.worker;


import com.webapp.entity.Post;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.service.DepartmentService;
import com.webapp.service.PostService;
import com.webapp.service.WorkerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/worker")
public class UpdateWorkerController
{
    private final WorkerService workerService;
    private final DepartmentService departmentService;
    private final PostService postService;

    public UpdateWorkerController(WorkerService workerService, DepartmentService departmentService, PostService postService)
    {
        this.workerService = workerService;
        this.departmentService = departmentService;
        this.postService = postService;
    }

    @GetMapping("/update/{id}")
    public String updateWorker(@PathVariable("id") Long id,
                               Model model)
    {
        Worker worker = workerService.findById(id);
        model.addAttribute("worker", worker);
        model.addAttribute("departments", departmentService.findWithoutGen());
        model.addAttribute("posts", postService.findWithoutGen());
        return "updateWorker";
    }

    @PostMapping("/update")
    public String updateWorker(@RequestParam Long id,
                               @RequestParam String name,
                               @RequestParam String lastname,
                               @RequestParam String password,
                               @RequestParam Role role,
                               @RequestParam String department,
                               @RequestParam String post)
    {
        Worker worker = new Worker(id, name, lastname, password, role, departmentService.findByName(department), postService.findByName(post));
        workerService.save(worker);
        return "redirect:/main";
    }
}
