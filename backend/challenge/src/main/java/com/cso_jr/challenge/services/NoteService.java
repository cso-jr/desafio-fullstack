package com.cso_jr.challenge.services;


import com.cso_jr.challenge.dto.NoteDTO;
import com.cso_jr.challenge.entities.Note;
import com.cso_jr.challenge.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;


    public List<NoteDTO> findAll() {
        return repository.findAll().stream().map(x -> new NoteDTO(x)).collect(Collectors.toList());
    }

}
