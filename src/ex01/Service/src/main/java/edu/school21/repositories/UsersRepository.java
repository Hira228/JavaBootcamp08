package edu.school21.repositories;

import java.sql.SQLException;
import java.util.Optional;

public interface UsersRepository<T> extends CrudRepository<T> {
    Optional<T> findByEmail(String email) throws SQLException;
}
