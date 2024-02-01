package edu.school21.repositories;

import java.util.Optional;

public interface UsersRepository<T> extends CrudRepository<T> {
    Optional<T> findByEmail(String email);
}
