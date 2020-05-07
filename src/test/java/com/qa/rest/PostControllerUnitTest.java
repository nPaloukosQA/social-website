package com.qa.rest;


import com.qa.domain.Post;
import com.qa.dto.PostDTO;
import com.qa.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerUnitTest {

    @InjectMocks
    private PostController postController;

    @Mock
    private PostService service;

    private List<Post> posts;

    private Post testPost;

    private Post testPostWithId;

    private long pid = 1L;

    private PostDTO postDTO;

    private final ModelMapper mapper = new ModelMapper();

    private PostDTO mapToDTO(Post post){
        return this.mapper.map(post, PostDTO.class);
    }

    @Before
    public void setUp(){
        this.posts = new ArrayList<>();
        this.testPost = new Post("the best picture link");
        this.posts.add(testPost);
        this.testPostWithId = new Post(testPost.getPictureLink());
        this.testPostWithId.setPid(this.pid);
        this.postDTO = this.mapToDTO(testPostWithId);
    }

    @Test
    public void getAllPostsTest(){
        when(service.readPosts()).thenReturn(this.posts.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No posts found", this.postController.getAllPosts().getBody().isEmpty());
        verify(service, times(1)).readPosts();
    }

    @Test
    public void createPostTest(){
        when(this.service.createPost(testPost)).thenReturn(this.postDTO);
        assertEquals(this.postController.createPost(testPost), new ResponseEntity<PostDTO>(this.postDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createPost(testPost);
    }

    @Test
    public void deletePostTestFalse(){
        this.postController.deletePost(pid);
        verify(service, times(1)).deletePost(pid);
    }

    @Test
    public void deletePostByIdTrue(){
        when(service.deletePost(3L)).thenReturn(true);
        this.postController.deletePost(3L);
        verify(service, times(1)).deletePost(3L);
    }

    @Test
    public void getPostByIdTest(){
        when(this.service.findPostById(pid)).thenReturn(this.postDTO);
        assertEquals(this.postController.getPostById(pid), new ResponseEntity<PostDTO>(this.postDTO, HttpStatus.OK));
        verify(service, times(1)).findPostById(pid);
    }



}
