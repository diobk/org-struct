package com.webapp.service;

import com.webapp.entity.Post;
import com.webapp.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService
{
    private final PostRepo postRepo;

    public PostService(PostRepo postRepo)
    {
        this.postRepo = postRepo;
    }

    public boolean save(String post)
    {
        if (post != null && !post.isEmpty())
        {
            postRepo.save(new Post(post));
            return true;
        }
        return false;
    }

    public Post findByName(String name)
    {
        return postRepo.findByName(name);
    }

    public List<Post> findWithoutGen()
    {
        List<Post> posts = postRepo.findAll();
        posts.removeIf(post -> post.getName().equals("Генеральный директор"));
        return posts;
    }

    public void deleteByName(String post)
    {
        postRepo.delete(findByName(post));
    }
}
