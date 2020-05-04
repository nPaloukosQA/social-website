package com.qa.service;

import com.qa.domain.Social;
import com.qa.exceptions.SocialNotFoundException;
import com.qa.repo.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    private final SocialRepository repo;

    @Autowired
    public SocialService(SocialRepository repo) {
        this.repo = repo;
    }

    public List<Social> readSocials(){
        return this.repo.findAll();
    }

    public Social createSocial(Social social){
        return this.repo.save(social);
    }

    public Social findSocialById(Long id){
        return this.repo.findById(id).orElseThrow(SocialNotFoundException::new);
    }

    public Social updateSocial(Long id, Social social){
        Social update = findSocialById(id);
        update.setTitle(social.getTitle());
        update.setContent(social.getContent());
        return this.repo.save(update);
    }

    public boolean deleteSocial(Long id){
        if(!this.repo.existsById(id)){
            throw new SocialNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }


}
