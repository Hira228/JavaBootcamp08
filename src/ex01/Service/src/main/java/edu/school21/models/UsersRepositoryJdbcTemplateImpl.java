package edu.school21.models;

import edu.school21.repositories.UsersRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository<User> {
    JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?", (rs, rowNum) -> {
            return new User(rs.getLong("id" ), rs.getString("email"));
        }, id).stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> {
            return new User(rs.getLong("id" ), rs.getString("email"));
        });
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO users(email) VALUES (?)", entity.getEmail());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE users SET email = ? WHERE id = ?", entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    @Override
    public Optional findByEmail(String email) {
        return jdbcTemplate.query("SELECT * FROM users WHERE email = ?", (rs, rowNum) -> {
            return new User(rs.getLong("id" ), rs.getString("email"));
        }, email).stream().findAny();
    }
}
