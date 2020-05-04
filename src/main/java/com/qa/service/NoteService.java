package com.qa.service;

import com.qa.domain.Social;
import com.qa.exceptions.NoteNotFoundException;
import com.qa.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NotesRepository repo;

    @Autowired
    public NoteService(NotesRepository repo) {
        this.repo = repo;
    }

    public List<Social> readNotes(){
        return this.repo.findAll();
    }

    public Social createNote(Social note){
        return this.repo.save(note);
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
