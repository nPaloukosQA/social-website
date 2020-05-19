package com.qa.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Social;
import com.qa.dto.SocialDTO;
import com.qa.repo.SocialRepository;
import org.junit.Before;
import org.junit.Ignore;
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

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;




@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SocialControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private SocialRepository repository;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Social testSocial;

    private Social testSocialWithID;

    private long id;

    private SocialDTO socialDTO;

    private  SocialDTO mapToDTO(Social social) {return this.mapper.map(social, SocialDTO.class);}

    @Test
    public void setUp(){
        this.repository.deleteAll();
        this.testSocial = new Social("title", "genre");
        this.testSocialWithID = this.repository.save(testSocial);
        this.id = testSocialWithID.getId();
        this.socialDTO = this.mapToDTO(testSocialWithID);
    }
    @Ignore
    @Test
    public void getAllSocialsTest() throws Exception{
        List<SocialDTO> socialDTOList = new ArrayList<>();
        socialDTOList.add(socialDTO);
        String content = this.mock.perform(
          request(HttpMethod.GET, "/getAllSocials")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(socialDTOList));
    }
    @Ignore
    @Test
    public void createSocialTest() throws Exception {
        String result = this.mock.perform(request(HttpMethod.POST, "/createSocial")
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString
                        (testSocial)).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(socialDTO));
    }

}
