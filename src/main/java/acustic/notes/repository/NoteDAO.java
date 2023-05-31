package acustic.notes.repository;

import acustic.notes.entity.NoteDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteDAO implements INoteDAO {

    private final JdbcTemplate jdbcTemplate;

    public NoteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public NoteDTO getById(Long id) {
        String query = "SELECT * FROM notes WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<>(NoteDTO.class));
    }

    @Override
    public List<NoteDTO> getAllByOrderByIdAsc() {
        String query = "SELECT * FROM notes";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(NoteDTO.class));
    }

    @Override
    public void save(NoteDTO note) {
        String query = "INSERT INTO notes (title, text) VALUES (?, ?)";
        jdbcTemplate.update(query, note.getTitle(), note.getText());
    }

    @Override
    public void update(NoteDTO note) {
        String query = "UPDATE notes SET title = ?, text = ? WHERE id = ?";
        jdbcTemplate.update(query, note.getTitle(), note.getText(), note.getId());
    }

    @Override
    public void delete(NoteDTO note) {
        String query = "DELETE FROM notes WHERE id = ?";
        jdbcTemplate.update(query, note.getId());
    }
}
