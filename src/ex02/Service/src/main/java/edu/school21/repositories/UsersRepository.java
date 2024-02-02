package edu.school21.repositories;

import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Optional;

@Component("usersRepository")
public interface UsersRepository<T> extends CrudRepository<T> {
    Optional<T> findByEmail(String email) throws SQLException;
}
