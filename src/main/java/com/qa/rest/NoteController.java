package com.qa.rest;

import com.qa.domain.Social;
import com.qa.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class NoteController {

    private final NoteService service;

    @Autowired
    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping("/getAllNotes")
    public List<Social> getAllNotes(){
        return this.service.readNotes();
    }

    @PostMapping("/createNote")
    public Social createNote(@RequestBody Social note){
        return this.service.createNote(note);
    }

    @DeleteMapping("/deleteNote/{id}")
    public boolean deleteNote(@PathVariable Long id){
        return this.service.deleteNote(id);
    }

    @GetMapping("/getNoteById/{id}")
    public Social getNoteById(@PathVariable Long id){
        return this.service.findNoteById(id);
    }

    @PutMapping("/updateNote/{id}")
    public Social updateNote(@PathVariable Long id, @RequestBody Social note){
        return this.service.updateNote(id, note);
    }

    @PutMapping("/updateNote2")
    public Social updateNote2(@PathParam("id") Long id, @RequestBody Social note){
        return this.service.updateNote(id, note);
    }

}
