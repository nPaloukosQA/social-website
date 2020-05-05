package com.qa.service;

import com.qa.domain.Social;
import com.qa.dto.SocialDTO;
import com.qa.exceptions.SocialNotFoundException;
import com.qa.repo.SocialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialService {

    private final SocialRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public SocialService(SocialRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private SocialDTO mapToDTO(Social social) {
        return this.mapper.map(social, SocialDTO.class);
    }

    public List<SocialDTO> readSocials(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public SocialDTO createSocial(Social social){
        Social tempSocial = this.repo.save(social);
        return this.mapToDTO(tempSocial);
    }

    public SocialDTO findSocialById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(SocialNotFoundException::new));
    }

    public SocialDTO updateSocial(Long id, Social social){
        Social update = this.repo.findById(id).orElseThrow(SocialNotFoundException::new);
        update.setTitle(social.getTitle());
        update.setContent(social.getContent());
        Social tempSocial = this.repo.save(social);
        return this.mapToDTO(tempSocial);
    }

    public boolean deleteSocial(Long id){
        if(!this.repo.existsById(id)){
            throw new SocialNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
