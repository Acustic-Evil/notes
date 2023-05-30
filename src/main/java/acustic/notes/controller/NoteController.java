package acustic.notes.controller;

import acustic.notes.entity.Notes;
import acustic.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @PostMapping("/new_note")
    public ResponseEntity<Notes> new_note(@RequestBody String text) {
        return new ResponseEntity<>(noteService.createNote(text), HttpStatus.OK);
    }

    @DeleteMapping("/delete_note")
    public ResponseEntity<Boolean> delete_note(@RequestBody Long id) {
        if (id == null || noteService.getNote(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(noteService.deleteNote(id), HttpStatus.OK);
    }

    @PostMapping("/update_note")
    public ResponseEntity<Notes> update_note(@RequestBody Notes note) {
        if (note == null || noteService.getNote(note.getId()) == null || note.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(noteService.updateNote(note.getId(), note.getText()), HttpStatus.OK);
    }

    @GetMapping("/get_note")
    public ResponseEntity<Notes> get_note(@RequestBody Long id) {
        if (id == null || noteService.getNote(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(noteService.getNote(id), HttpStatus.OK);
    }

    @GetMapping("/get_all_notes")
    public List<Notes> get_all() {
        return noteService.getAllNotes();
    }
}
