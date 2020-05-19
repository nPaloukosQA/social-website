package com.qa.rest;

import com.qa.domain.Social;
import com.qa.dto.SocialDTO;
import com.qa.repo.SocialRepository;
import com.qa.service.SocialService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
public class SocialControllerUnitTest {

    @InjectMocks
    private SocialService service;

    @Mock
    private SocialRepository repository;

    @Mock
    private ModelMapper mapper;

    private List<Social> socialList;

    private Social testSocial;

    private Long id = 1L;

    private Social testSocialWithID;

    private SocialDTO socialDTO;

    private SocialDTO maptoDTO(Social social){return this.mapper.map(social, SocialDTO.class);}

    @Before
    public void setUp(){
        this.socialList = new ArrayList<>();
        this.testSocial = new Social("Good Title", "amazing content");
        this.socialList.add(testSocial);
        this.testSocialWithID = new Social(testSocial.getTitle(), testSocial.getContent());
        this.testSocialWithID.setId(id);
        this.socialDTO = this.maptoDTO(testSocialWithID);
    }

    @Test
    public void getAllSocialsTest(){
        when(repository.findAll()).thenReturn(this.socialList);
        when(this.mapper.map(testSocialWithID, SocialDTO.class)).thenReturn(socialDTO);
        assertFalse("Service returned no Stories", this.service.readSocials().isEmpty());
        verify(repository, times(1)).findAll();
    }



}
