package com.webapp.sql;

import com.webapp.entity.Department;
import com.webapp.entity.Post;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.service.DepartmentService;
import com.webapp.service.PostService;
import com.webapp.service.WorkerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Add
{
    private final WorkerService workerService;

    private final PostService postService;

    private final DepartmentService departmentService;

    private final PasswordEncoder passwordEncoder;

    public Add(DepartmentService departmentService, PostService postService, WorkerService workerService, PasswordEncoder passwordEncoder)
    {
        this.departmentService = departmentService;
        this.postService = postService;
        this.workerService = workerService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/add")
    public String add()
    {
        departmentService.save("отдел генерального");
        departmentService.save("отдел веб разработки");
        departmentService.save("отдел финансов");


        postService.save("Генеральный директор");
        postService.save("директор отдела веб разработки");
        postService.save("директор отдела финансов");
        postService.save("программист");
        postService.save("экономист");

        workerService.save(
                new Worker("name",
                        "lastname",
                        passwordEncoder.encode("password"),
                        Role.GEN_DIR,
                        departmentService.findByName("отдел генерального"),
                        postService.findByName("Генеральный директор")));

        workerService.save(
                new Worker("имя2",
                        "lastname",
                        passwordEncoder.encode("password"),
                        Role.DIR,
                        departmentService.findByName("отдел веб разработки"),
                        postService.findByName("директор отдела веб разработки")));

        workerService.save(
                new Worker("имя3",
                        "lastname",
                        passwordEncoder.encode("password"),
                        Role.DIR,
                        departmentService.findByName("отдел финансов"),
                        postService.findByName("директор отдела финансов")));


        workerService.save(
                new Worker("имя4",
                        "lastname",
                        passwordEncoder.encode("password"),
                        Role.WORKER,
                        departmentService.findByName("отдел веб разработки"),
                        postService.findByName("программист")));

        workerService.save(
                new Worker("имя5",
                        "lastname",
                        passwordEncoder.encode("password"),
                        Role.WORKER,
                        departmentService.findByName("отдел финансов"),
                        postService.findByName("экономист")));



        return "redirect:/login";
    }

}
