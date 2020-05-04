package com.qa.service;

import com.qa.domain.Social;
import com.qa.exceptions.NoteNotFoundException;
import com.qa.repo.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Socialservice {

    private final SocialRepository repo;

    @Autowired
    public Socialservice(SocialRepository repo) {
        this.repo = repo;
    }

    public List<Social> readNotes(){
        return this.repo.findAll();
    }

    public Social createNote(Social social){
        return this.repo.save(social);
    }

    public Social findNoteById(Long id){
        return this.repo.findById(id).orElseThrow(NoteNotFoundException::new);
    }

    public Social updateNote(Long id, Social note){
        Social update = findNoteById(id);
        update.setTitle(note.getTitle());
        update.setContent(note.getContent());
        return this.repo.save(update);
    }

    public boolean deleteNote(Long id){
        if(!this.repo.existsById(id)){
            throw new NoteNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }


}
