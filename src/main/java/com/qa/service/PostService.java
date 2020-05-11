package com.qa.service;


import com.qa.domain.Post;
import com.qa.dto.PostDTO;
import com.qa.exceptions.PostNotFoundException;
import com.qa.repo.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public PostService(PostRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private PostDTO mapToDTO(Post post) {
        return this.mapper.map(post, PostDTO.class);
    }

    public List<PostDTO> readPosts() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public PostDTO createPost(Post post) {
        Post tempPost = this.repo.save(post);
        return this.mapToDTO(tempPost);
    }

    public PostDTO findPostById(Long pid) {
        return this.mapToDTO(this.repo.findById(pid)
                .orElseThrow(PostNotFoundException::new));
    }

    public PostDTO updatePost(Long pid, Post post) {
        Post update = this.repo.findById(pid).orElseThrow(PostNotFoundException::new);
        update.setPictureLink(post.getPictureLink());
        Post tempPost = this.repo.save(update);
        return this.mapToDTO(tempPost);
    }

    public boolean deletePost(Long pid) {
        if(!this.repo.existsById(pid)) {
            throw new PostNotFoundException();
        }
        this.repo.deleteById(pid);
        return this.repo.existsById(pid);
    }
}
