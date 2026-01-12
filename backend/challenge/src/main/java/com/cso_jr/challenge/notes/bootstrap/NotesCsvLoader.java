package com.cso_jr.challenge.notes.bootstrap;

import com.cso_jr.challenge.entities.Note;
import com.cso_jr.challenge.repositories.NoteRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.io.Reader;
import java.time.Instant;

@Component
public class NotesCsvLoader implements CommandLineRunner {

    private final NoteRepository noteRepository;

    public NotesCsvLoader(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (noteRepository.count() > 0) {
            return;
        }

        Reader reader = new InputStreamReader(
                getClass().getResourceAsStream("/materials/notes.csv")
        );

        CSVParser parser = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withTrim()
                .parse(reader);

        for (CSVRecord record : parser) {

            Note note = new Note();
            note.setSite(record.get("site"));
            note.setEquipment(record.get("equipment"));
            note.setVariable(record.get("variable"));
            note.setTimestamp(Instant.parse(record.get("timestamp")));
            note.setAuthor(record.get("author"));
            note.setMessage(record.get("message"));

            noteRepository.save(note);
        }

        parser.close();
    }
}
