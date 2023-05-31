package acustic.notes.service;

import acustic.notes.entity.Notes;
import acustic.notes.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NoteService {
    @Autowired
    NoteRepo noteRepo;

    public Notes updateNote(Long id, String text) {
        Notes note = noteRepo.findById(id);
        if (Objects.equals(note.getText(), text)) {
            return note;
        }
        note.setText(text);
        noteRepo.save(note);
        return note;
    }

    public Boolean deleteNote(Long id) {
        Notes note = noteRepo.findById(id);
        noteRepo.delete(note);
        return true;
    }

    public Notes createNote(String text) {
        Notes note = new Notes();
        note.setText(text);
        noteRepo.save(note);
        return note;
    }

    public Notes getNote(Long id) {
        return noteRepo.findById(id);
    }

    public List<Notes> getAllNotes() {
        return noteRepo.getAllByOrderByIdAsc();
    }

}
