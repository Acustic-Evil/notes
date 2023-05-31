/*
package acustic.notes.repository;

import acustic.notes.entity.Notes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteDAO implements INoteDAO {

    private final JdbcTemplate jdbcTemplate;

    public NoteDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Notes getById(Long id) {
        String query = "SELECT * FROM notes WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new NoteRowMapper());
    }

    @Override
    public List<Notes> getAll() {
        String query = "SELECT * FROM notes";
        return jdbcTemplate.query(query, new NoteRowMapper());
    }

    @Override
    public void save(Notes note) {
        String query = "INSERT INTO notes (title, content) VALUES (?, ?)";
        jdbcTemplate.update(query, note.getTitle(), note.getContent());
    }

    @Override
    public void update(Notes note) {
        String query = "UPDATE notes SET title = ?, content = ? WHERE id = ?";
        jdbcTemplate.update(query, note.getTitle(), note.getContent(), note.getId());
    }

    @Override
    public void delete(Notes note) {
        String query = "DELETE FROM notes WHERE id = ?";
        jdbcTemplate.update(query, note.getId());
    }
}
*/
