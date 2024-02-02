package edu.school21.repositories;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("usersService")
public interface UsersService {
    String SignUp(String email) throws SQLException;
}
