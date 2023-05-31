package acustic.notes.repository;

import acustic.notes.entity.NoteDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoteDAO {
   NoteDTO save(NoteDTO note);
   void update(NoteDTO note);
   boolean delete(NoteDTO note);
   NoteDTO getById(Long id);
   List<NoteDTO> getAllByOrderByIdAsc();
}
