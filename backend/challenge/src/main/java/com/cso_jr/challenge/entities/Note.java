package com.cso_jr.challenge.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@Table(name="tb_note")
public class Note {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String site;

    @Column(nullable = false)
    private String equipment;

    @Column(nullable = false)
    private String variable;

    @Column(nullable = false)
    private Instant timestamp;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(getId(), note.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}


