package com.qa.service;

import com.qa.domain.Social;
import com.qa.dto.SocialDTO;
import com.qa.repo.SocialRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialServiceIntegrationTest {

    @Autowired
    private SocialService service;

    @Autowired
    private SocialRepository repository;

    @Autowired
    private ModelMapper mapper;

    private Social testSocial;

    private Social testSocialWithID;

    private SocialDTO mapToDTO(Social social){
        return this.mapper.map(social, SocialDTO.class);
    }

    @Before
    public void setUp(){
        this.testSocial = new Social("An amazing title", "a nice content");
        this.repository.deleteAll();
        this.testSocialWithID = this.repository.save(this.testSocial);
    }

    @Ignore
    @Test
    public void readSocialsTest() {
        assertThat(this.service.readSocials())
                .isEqualTo(
                    Stream.of(this.mapToDTO(testSocialWithID)).collect(Collectors.toList())
                );
    }

    @Test
    public void deleteSocialTest(){
        assertThat(this.service.deleteSocial(this.testSocialWithID.getId())).isFalse();
    }



}
