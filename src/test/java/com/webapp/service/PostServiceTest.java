package com.webapp.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
class PostServiceTest
{
    @Autowired
    private PostService postService;

    @Test
    void aTestOneSave()
    {
        String name = "testPost";
        Assert.assertTrue(postService.save(name));
    }

    @Test
    void findWithoutGen()
    {
        Assert.assertNotNull(postService.findWithoutGen());
    }

    @Test
    void findByName()
    {
        String name = "testPost";
        Assert.assertNotNull(postService.findByName(name));
        postService.deleteByName(name);
    }
}