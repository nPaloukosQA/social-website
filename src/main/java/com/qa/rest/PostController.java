package com.qa.rest;


import com.qa.domain.Post;
import com.qa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/getAllPosts")
    public List<Post> getAllPosts() {return this.service.readPosts();}

    @PostMapping("/createPost")
    public Post createPost(@RequestBody Post post){
        return this.service.createPost(post);
    }

    @DeleteMapping("/deletePost/{pid}")
    public boolean deletePost(@PathVariable Long pid){
        return this.service.deletePost(pid);
    }

    @GetMapping("/getPostById/{pid}")
    public Post getPostById(@PathVariable Long pid){
        return this.service.findPostById(pid);
    }

    @PutMapping("/updatePost/{pid}")
    public Post updatePost(@PathVariable Long pid, @RequestBody Post post){
        return this.service.updatePost(pid, post);
    }

}
