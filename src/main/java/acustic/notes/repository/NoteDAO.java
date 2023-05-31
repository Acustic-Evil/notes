package acustic.notes.repository;

import acustic.notes.entity.NoteDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

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
    public NoteDTO save(NoteDTO note) {
        String query = "INSERT INTO notes (title, text) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, new String[]{"id"});
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getText());
            return ps;
        }, keyHolder);

        Long generatedId = keyHolder.getKey().longValue();
        note.setId(generatedId);

        return note;
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
