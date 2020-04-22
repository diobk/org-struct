package com.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/post")
public class PostController
{
    @GetMapping("add")
    public String addPost()
    {
        return "";
    }

    @GetMapping("/delete")
    public String deletePost()
    {
        return "";
    }
}
