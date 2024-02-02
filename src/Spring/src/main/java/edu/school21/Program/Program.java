package edu.school21.Program;

import edu.school21.models.User;
import edu.school21.models.UsersRepositoryJdbcImpl;
import edu.school21.models.UsersRepositoryJdbcTemplateImpl;
import edu.school21.repositories.UsersRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {
        try (ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml")){
            UsersRepository usersRepository = context.getBean("usersRepositoryJdbcImpl", UsersRepository.class);
            System.out.println(usersRepository.findAll());
            usersRepository = context.getBean("UsersRepositoryJdbcTemplateImpl", UsersRepository.class);
            System.out.println(usersRepository.findAll());
        }
    }
}
