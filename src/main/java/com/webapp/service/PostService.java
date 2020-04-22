package com.webapp.service;

import com.webapp.entity.Post;
import com.webapp.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService
{
    private final PostRepo postRepo;

    public PostService(PostRepo postRepo)
    {
        this.postRepo = postRepo;
    }

    public void save(Post post)
    {
        postRepo.save(post);
    }

    public Post findByName(String name)
    {
        return postRepo.findByName(name);
    }
}
