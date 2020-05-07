package com.qa.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Post;
import com.qa.dto.PostDTO;
import com.qa.repo.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private PostRepository repository;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Post testPost;

    private Post testPostWithID;

    private long pid;

    private PostDTO postDTO;

    private PostDTO mapToDTO(Post post){
        return this.mapper.map(post, PostDTO.class);
    }

    @Before
    public void setUp(){
        this.repository.deleteAll();
        this.testPost = new Post("another perfect picturelink");
        this.testPostWithID = this.repository.save(testPost);
        this.pid = testPostWithID.getPid();
        this.postDTO = this.mapToDTO(testPostWithID);
    }

    @Test
    public void getAllPostsTest() throws Exception{
        List<PostDTO> postDTOList = new ArrayList<>();
        postDTOList.add(postDTO);
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAllPosts")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(postDTOList));
    }

    @Test
    public void getPostByID() throws Exception{
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getPostById/" + this.pid)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(postDTO));
    }

    @Test
    public void createPostTest() throws Exception{
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createPost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(testPost))
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(postDTO));
    }


}