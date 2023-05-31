package acustic.notes.repository;

import acustic.notes.entity.NoteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<NoteDTO, Integer> {
    NoteDTO getById(Long id);

    List<NoteDTO> getAllByOrderByIdAsc();

}
