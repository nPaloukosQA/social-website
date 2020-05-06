package com.qa.rest;


import com.qa.domain.Post;
import com.qa.dto.PostDTO;
import com.qa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/getAllPosts")
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        return ResponseEntity.ok(this.service.readPosts());
    }

    @PostMapping("/createPost")
    public ResponseEntity<PostDTO> createPost(@RequestBody Post post){
        return new ResponseEntity<PostDTO>(this.service.createPost(post), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePost/{pid}")
    public ResponseEntity<?> deletePost(@PathVariable Long pid){
        return this.service.deletePost(pid)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getPostById/{pid}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long pid){
        return ResponseEntity.ok(this.service.findPostById(pid));
    }

    @PutMapping("/updatePost/{pid}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long pid, @RequestBody Post social){
        return ResponseEntity.ok(this.service.updatePost(pid, social));
    }

    @PutMapping("/updatePost2")
    public ResponseEntity<PostDTO> updatePost2(@PathParam("pid") Long pid, @RequestBody Post social){
        return ResponseEntity.ok(this.service.updatePost(pid, social));
    }

}
