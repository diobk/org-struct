package com.webapp.service;

import com.webapp.Application;
import com.webapp.entity.Department;
import com.webapp.entity.Post;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repo.DepartmentRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
class DepartmentServiceTest
{
    @Autowired
    private DepartmentService departmentService;

    @Test
    void testOneSave()
    {
        String name = "testDepartment";
        Assert.assertTrue(departmentService.save(name));
    }

    @Test
    void findAll()
    {
        Assert.assertNotNull(departmentService.findAll());
    }

    @Test
    void findByName()
    {
        String name = "testDepartment";
        Assert.assertNotNull(departmentService.findByName(name));
        departmentService.deleteByName(name);
    }

    @Test
    void findWithoutGen()
    {
        Assert.assertNotNull(departmentService.findWithoutGen());
    }
}