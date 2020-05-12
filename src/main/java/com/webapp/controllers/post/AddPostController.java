package com.webapp.controllers.post;

import com.webapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/post")
public class AddPostController
{
    private final PostService postService;

    public AddPostController(PostService postService)
    {
        this.postService = postService;
    }

    @GetMapping("/add")
    public String addPost()
    {
        return "addPost";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam String post)
    {
        if (postService.findByName(post) == null)
        {
            postService.save(post);
            return "redirect:/post/add";
        }
        return "redirect:/post/add?error";
    }
}
