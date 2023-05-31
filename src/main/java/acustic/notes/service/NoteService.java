package acustic.notes.service;

import acustic.notes.entity.NoteDTO;
import acustic.notes.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NoteService {
    @Autowired
    NoteRepo noteRepo;

    public NoteDTO updateNote(Long id, String text) {
        NoteDTO note = noteRepo.getById(id);
        if (Objects.equals(note.getText(), text)) {
            return note;
        }
        note.setText(text);
        noteRepo.save(note);
        return note;
    }

    public Boolean deleteNote(Long id) {
        NoteDTO note = noteRepo.getById(id);
        noteRepo.delete(note);
        return true;
    }

    public NoteDTO createNote(String text) {
        NoteDTO note = new NoteDTO();
        note.setText(text);
        noteRepo.save(note);
        return note;
    }

    public NoteDTO getNote(Long id) {
        return noteRepo.getById(id);
    }

    public List<NoteDTO> getAllNotes() {
        return noteRepo.getAllByOrderByIdAsc();
    }

}
