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
import java.util.List;

@Controller
@RequestMapping(value="/api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService service;

    @GetMapping
    public ResponseEntity<List<NoteDTO>> findAll() {
        List<NoteDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }
}
