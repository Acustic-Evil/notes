package acustic.notes.service;

import acustic.notes.entity.NoteDTO;
import acustic.notes.repository.INoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    INoteDAO noteDAO;

    public NoteDTO updateNote(NoteDTO note) {
        noteDAO.update(note);
        return note;
    }

    public boolean deleteNote(Long id) {
        NoteDTO note = noteDAO.getById(id);
        return noteDAO.delete(note);
    }

    public NoteDTO createNote(NoteDTO note) {
        return noteDAO.save(note);
    }

    public NoteDTO getNote(Long id) {
        return noteDAO.getById(id);
    }

    public List<NoteDTO> getAllNotes() {
        return noteDAO.getAllByOrderByIdAsc();
    }

}
