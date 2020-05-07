package com.qa.service;


import com.qa.domain.Post;
import com.qa.dto.PostDTO;
import com.qa.repo.PostRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class PostServiceUnitTest {

    @InjectMocks
    private PostService service;

    @Mock
    private PostRepository repository;

    @Mock
    private ModelMapper mapper;

    private List<Post> postList;

    private Post testPost;

    private long pid = 1L;

    private Post testPostWithID;

    private PostDTO postDTO;

    private PostDTO mapToDTO(Post post){
        return this.mapper.map(post, PostDTO.class);
    }

    @Before
    public void setUp(){
        this.postList = new ArrayList<>();
        this.testPost = new Post("jojooo");
        this.postList.add(testPost);
        this.testPostWithID = new Post(testPost.getPictureLink());
        this.testPostWithID.setPid(pid);
        this.postDTO = this.mapToDTO(testPostWithID);
    }
}
