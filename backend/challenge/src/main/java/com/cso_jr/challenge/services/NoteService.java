package com.cso_jr.challenge.services;


import com.cso_jr.challenge.entities.Note;
import com.cso_jr.challenge.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;


    public Page<Note> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
