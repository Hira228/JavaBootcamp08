package edu.school21.models;

import edu.school21.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void save(Object entity) {

    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional findByEmail(String email) {
        return Optional.empty();
    }
}
