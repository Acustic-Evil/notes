package acustic.notes.service;

import acustic.notes.entity.NoteDTO;
import acustic.notes.repository.NoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NoteService {
    @Autowired
    NoteDAO noteDAO;

    public NoteDTO updateNote(NoteDTO note) {
        noteDAO.update(note);
        return note;
    }

    public Boolean deleteNote(Long id) {
        NoteDTO note = noteDAO.getById(id);
        noteDAO.delete(note);
        return true;
    }

    public NoteDTO createNote(NoteDTO note) {
        noteDAO.save(note);
        return note;
    }

    public NoteDTO getNote(Long id) {
        return noteDAO.getById(id);
    }

    public List<NoteDTO> getAllNotes() {
        return noteDAO.getAllByOrderByIdAsc();
    }

}
