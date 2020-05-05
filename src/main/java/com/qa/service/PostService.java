package com.qa.service;


import com.qa.domain.Post;
import com.qa.exceptions.PostNotFoundException;
import com.qa.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repo;

    @Autowired
    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public List<Post> readPosts() {
        return this.repo.findAll();
    }

    public Post createPost(Post post) {
        return this.repo.save(post);
    }

    public Post findPostById(Long pid) {
        return this.repo.findById(pid).orElseThrow(PostNotFoundException::new);
    }

    public Post updatePost(Long pid, Post post) {
        Post update = findPostById(pid);
        update.setPictureLink(post.getPictureLink());
        return this.repo.save(update);
    }

    public boolean deletePost(Long pid) {
        if(!this.repo.existsById(pid)) {
            throw new PostNotFoundException();
        }
        this.repo.deleteById(pid);
        return this.repo.existsById(pid);
    }
}
