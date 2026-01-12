package com.cso_jr.challenge.dto;

import com.cso_jr.challenge.entities.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NoteDTO {

    private UUID id;
    private String site;
    private String equipment;
    private String variable;
    private Instant timestamp;
    private String author;
    private String message;

    public NoteDTO(Note entity) {

        id = entity.getId();
        site = entity.getSite();
        equipment = entity.getEquipment();
        variable = entity.getVariable();
        timestamp = entity.getTimestamp();
        author = entity.getAuthor();
        message = entity.getMessage();

    }
}
