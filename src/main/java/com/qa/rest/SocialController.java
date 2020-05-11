package com.qa.rest;

import com.qa.domain.Social;
import com.qa.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class SocialController {

    private final SocialService service;

    @Autowired
    public SocialController(SocialService service) {
        this.service = service;
    }

    @GetMapping("/getAllSocials")
    public List<Social> getAllSocials(){
        return this.service.readSocials();
    }

    @PostMapping("/createSocial")
    public Social createSocial(@RequestBody Social social){
        return this.service.createSocial(social);
    }

    @DeleteMapping("/deleteSocial/{id}")
    public boolean deleteSocial(@PathVariable Long id){
        return this.service.deleteSocial(id);
    }

    @GetMapping("/getSocialById/{id}")
    public Social getSocialById(@PathVariable Long id){
        return this.service.findSocialById(id);
    }

    @PutMapping("/updateSocial/{id}")
    public Social updateSocial(@PathVariable Long id, @RequestBody Social social){
        return this.service.updateSocial(id, social);
    }

    @PutMapping("/updateSocial2")
    public Social updateSocial2(@PathParam("id") Long id, @RequestBody Social social){
        return this.service.updateSocial(id, social);
    }

}
