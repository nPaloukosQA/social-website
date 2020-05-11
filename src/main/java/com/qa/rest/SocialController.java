package com.qa.rest;

import com.qa.domain.Social;
import com.qa.dto.SocialDTO;
import com.qa.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<SocialDTO>> getAllSocials(){
        return ResponseEntity.ok(this.service.readSocials());
    }

    @PostMapping("/createSocial")
    public ResponseEntity<SocialDTO> createSocial(@RequestBody Social social){
        return new ResponseEntity<SocialDTO>(this.service.createSocial(social), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteSocial/{id}")
    public ResponseEntity<?> deleteSocial(@PathVariable Long id){
        return this.service.deleteSocial(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getSocialById/{id}")
    public ResponseEntity<SocialDTO> getSocialById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findSocialById(id));
    }

    @PutMapping("/updateSocial/{id}")
    public ResponseEntity<SocialDTO> updateSocial(@PathVariable Long id, @RequestBody Social social) {
        return ResponseEntity.ok(this.service.updateSocial(id, social));
    }

    @PutMapping("/updateSocial2")
    public ResponseEntity<SocialDTO> updateSocial2(@PathParam("id") Long id, @RequestBody Social social) {
        return ResponseEntity.ok(this.service.updateSocial(id, social));
    }

}
