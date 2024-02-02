package edu.school21.models;

import edu.school21.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("usersRepositoryJdbcImpl")
public class UsersRepositoryJdbcImpl implements UsersRepository<User> {
    DataSource hikariDataSource;

    @Autowired
    public UsersRepositoryJdbcImpl(@Qualifier("dataSourceHikari") DataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    @Override
    public Optional findById(Long id) throws SQLException {
        User user = null;
        try (Connection connection = hikariDataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                user = new User((resultSet.getLong("id")), resultSet.getString("email"));
            }
            return Optional.ofNullable(user);
        }
    }

    @Override
    public List findAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        User user = null;
        try (Connection connection = hikariDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                user = new User((resultSet.getLong("id")), resultSet.getString("email"));
                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public void save(User entity) throws SQLException {
        try (Connection connection = hikariDataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(email) VALUES (?)");
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(User entity) throws SQLException {
        try (Connection connection = hikariDataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET email = ? WHERE id = ?");
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
        }
    }


    @Override
    public void delete(Long id) throws SQLException {
        try (Connection connection = hikariDataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Optional findByEmail(String email) throws SQLException {
        User user = null;
        try (Connection connection = hikariDataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getLong("id"), resultSet.getString("email"));
            }
        }
        return Optional.ofNullable(user);
    }
}
