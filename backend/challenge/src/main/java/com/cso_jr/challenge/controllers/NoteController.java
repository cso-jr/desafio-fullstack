package com.cso_jr.challenge.controllers;

import com.cso_jr.challenge.dto.NoteDTO;
import com.cso_jr.challenge.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping(value="/api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService service;


    @GetMapping
    public ResponseEntity<Page<NoteDTO>> findAll(
            @RequestParam(required = false) String site,
            @RequestParam(required = false) String equipment,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            Pageable pageable
    ){
        Page<NoteDTO> dtos = service.findAll(Pageable pageable);
        return ResponseEntity.ok((Page<NoteDTO>) dtos);
    }



}
