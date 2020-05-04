package com.qa.rest;

import com.qa.domain.Social;
import com.qa.service.Socialservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class SocialController {

    private final Socialservice service;

    @Autowired
    public SocialController(Socialservice service) {
        this.service = service;
    }

    @GetMapping("/getAllSocials")
    public List<Social> getAllSocials(){
        return this.service.readNotes();
    }

    @PostMapping("/createSocial")
    public Social createSocial(@RequestBody Social social){
        return this.service.createNote(social);
    }

    @DeleteMapping("/deleteSocial/{id}")
    public boolean deleteSocial(@PathVariable Long id){
        return this.service.deleteNote(id);
    }

    @GetMapping("/getSocialById/{id}")
    public Social getSocialById(@PathVariable Long id){
        return this.service.findNoteById(id);
    }

    @PutMapping("/updateSocial/{id}")
    public Social updateSocial(@PathVariable Long id, @RequestBody Social social){
        return this.service.updateNote(id, social);
    }

    @PutMapping("/updateSocial2")
    public Social updateNote2(@PathParam("id") Long id, @RequestBody Social social){
        return this.service.updateNote(id, social);
    }

}
