package com.qa.service;


import com.qa.domain.Post;
import com.qa.dto.PostDTO;
import com.qa.repo.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceIntegrationTest {

    @Autowired
    private PostService service;

    @Autowired
    private PostRepository repository;

    @Autowired
    private ModelMapper mapper;

    private Post testPost;

    private Post testPostWithID;

    private PostDTO mapToDTO(Post post){
        return this.mapper.map(post, PostDTO.class);
    }

    @Before
    public void setUp(){
        this.testPost = new Post("anotherotherpicturelink");
        this.repository.deleteAll();
        this.testPostWithID = this.repository.save(this.testPost);
    }

    @Test
    public void readPostsTest(){
        assertThat(this.service.readPosts())
                .isEqualTo(
                        Stream.of(this.mapToDTO(testPostWithID)).collect(Collectors.toList())
                );
    }

    @Test
    public void createPostTest(){
        assertEquals(this.mapToDTO(this.testPostWithID), this.service.createPost(testPost));
    }

    @Test
    public void findPostByIdTest(){
        assertThat(this.service.findPostById(this.testPostWithID.getPid())).isEqualTo(this.mapToDTO(this.testPostWithID));
    }





}
