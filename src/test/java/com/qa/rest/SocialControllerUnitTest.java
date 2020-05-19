package com.qa.rest;

import com.qa.domain.Social;
import com.qa.dto.PostDTO;
import com.qa.dto.SocialDTO;
import com.qa.service.SocialService;
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
public class SocialControllerUnitTest {

    @InjectMocks
    private SocialController socialController;

    @Mock
    private SocialService service;

    private List<Social> socials;

    private Social testSocial;

    private Social testSocialWithID;

    private long id =1L;

    private SocialDTO socialDTO;

    private final ModelMapper mapper = new ModelMapper();

    private SocialDTO mapToDTO(Social social){ return this.mapper.map(social, SocialDTO.class);}

    @Before
    public void setUp(){
        this.socials = new ArrayList<>();
        this.testSocial = new Social("WOW, what a title", "just a common content :<(");
        this.socials.add(testSocial);
        this.testSocialWithID = new Social(testSocial.getTitle(), testSocial.getContent());
        this.testSocialWithID.setId(this.id);
        this.socialDTO = this.mapToDTO(testSocialWithID);
    }

    @Test
    public void getAllSocialsTest(){
        when(service.readSocials()).thenReturn(this.socials.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No socials found", this.socialController.getAllSocials().getBody().isEmpty());
        verify(service, times(1)).readSocials();
    }

    @Test
    public void createSocialTest(){
        when(this.service.createSocial(testSocial)).thenReturn(this.socialDTO);
        assertEquals(this.socialController.createSocial(testSocial), new ResponseEntity<SocialDTO>(this.socialDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createSocial(testSocial);
    }

    @Test
    public void deleteSocialTestFalse(){
        this.socialController.deleteSocial(id);
        verify(service, times(1)).deleteSocial(id);
    }

    @Test
    public void deleteSocialByIdTrue(){
        when(service.deleteSocial(3L)).thenReturn(true);
        this.socialController.deleteSocial(3L);
        verify(service, times(1)).deleteSocial(3L);
    }

    @Test
    public void getSocialByIdTest(){
        when(this.service.findSocialById(id)).thenReturn(this.socialDTO);
        assertEquals(this.socialController.getSocialById(id), new ResponseEntity<SocialDTO>(this.socialDTO, HttpStatus.OK));
        verify(service, times(1)).findSocialById(id);
    }


}
