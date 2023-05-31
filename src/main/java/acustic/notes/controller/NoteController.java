package acustic.notes.controller;

import acustic.notes.entity.NoteDTO;
import acustic.notes.exception.NoteNotFoundException;
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
    public ResponseEntity<NoteDTO> new_note(@RequestBody NoteDTO note) {
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.OK);
    }

    @DeleteMapping("/delete_note")
    public ResponseEntity<Boolean> delete_note(@RequestBody Long id) {
        try {
            return new ResponseEntity<>(noteService.deleteNote(id), HttpStatus.OK);
        } catch (NoteNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update_note")
    public ResponseEntity<NoteDTO> update_note(@RequestBody NoteDTO note) {
        try {
            return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
        } catch (NoteNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/get_note")
    public ResponseEntity<NoteDTO> get_note(@RequestBody Long id) {
        try {
            return new ResponseEntity<>(noteService.getNote(id), HttpStatus.OK);
        } catch (NoteNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get_all_notes")
    public List<NoteDTO> get_all() {
        return noteService.getAllNotes();
    }
}
