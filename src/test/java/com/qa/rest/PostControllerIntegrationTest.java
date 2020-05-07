package com.qa.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Post;
import com.qa.dto.PostDTO;
import com.qa.repo.PostRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
}