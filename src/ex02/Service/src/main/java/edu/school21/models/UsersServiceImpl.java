package edu.school21.models;

import edu.school21.repositories.UsersRepository;
import edu.school21.repositories.UsersService;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
@Component("usersServiceImpl")
public class UsersServiceImpl implements UsersService {
    UsersRepository<User> usersRepository;


    @Autowired
    public UsersServiceImpl(@Qualifier("usersRepositoryJdbcTemplateImpl")UsersRepository<User> usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public String SignUp(String email) throws SQLException {
        usersRepository.save(new User(email));
        return new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(Character::isLetterOrDigit)
                .build().generate(20);
    }
}
