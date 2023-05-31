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

    public NoteDTO updateNote(NoteDTO upd_note) {
        NoteDTO note = noteRepo.getById(upd_note.getId());
        if (Objects.equals(note.getText(), upd_note.getText())) {
            return note;
        }
        note.setText(upd_note.getText());
        note.setTitle(upd_note.getTitle());
        noteRepo.save(note);
        return note;
    }

    public Boolean deleteNote(Long id) {
        NoteDTO note = noteRepo.getById(id);
        noteRepo.delete(note);
        return true;
    }

    public NoteDTO createNote(NoteDTO note) {
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
