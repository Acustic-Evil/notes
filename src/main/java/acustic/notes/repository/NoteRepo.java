package acustic.notes.repository;

import acustic.notes.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Notes, Integer> {
    Notes findById(Long id);

    List<Notes> findAllByOrderByIdAsc();
}
