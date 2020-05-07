package com.qa.service;


import com.qa.domain.Post;
import com.qa.dto.PostDTO;
import com.qa.repo.PostRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    private Post getTestPostWithID;

    private PostDTO mapToDTO(Post post){
        return this.mapper.map(post, PostDTO.class);
    }

    @Before
    public void setUp(){
        this.testPost = new Post("another other picture link");
        this.repository.deleteAll();
        this.getTestPostWithID = this.repository.save(this.testPost);
    }


}
