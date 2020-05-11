package com.webapp.service;

import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/workerTestAdd.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/workerTestDel.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class WorkerServiceTest
{
    @Autowired
    private WorkerService workerService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PostService postService;

    @Test
    void save()
    {
        Worker worker = new Worker(
                "name",
                "lastname",
                "password",
                Role.WORKER,
                departmentService.findByName("testDepartment"),
                postService.findByName("testPost")
        );
        Assert.assertTrue(workerService.save(worker));
    }

    @Test
    void findByName()
    {
        Assert.assertNotNull(workerService.findByName("testName"));
    }

    @Test
    void findByRole()
    {
        Assert.assertNotNull(workerService.findByRole(Role.GEN_DIR));
    }

    @Test
    void findAll()
    {
        Assert.assertNotNull(workerService.findAll());
    }

    @Test
    void findById()
    {
        Assert.assertNotNull(workerService.findById(10L));
    }
}