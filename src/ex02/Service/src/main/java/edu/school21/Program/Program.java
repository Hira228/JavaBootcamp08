package edu.school21.Program;

import edu.school21.configuration.Config;
import edu.school21.models.User;
import edu.school21.models.UsersRepositoryJdbcImpl;
import edu.school21.models.UsersRepositoryJdbcTemplateImpl;
import edu.school21.models.UsersServiceImpl;
import edu.school21.repositories.UsersRepository;
import edu.school21.repositories.UsersService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@ComponentScan(basePackages = "edu.school21")
public class Program {
    public static void main(String[] args) throws SQLException {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Program.class)) {
            UsersRepository usersRepository = context.getBean("usersRepositoryJdbcImpl", UsersRepository.class);
            System.out.println(usersRepository.findAll());

            usersRepository = context.getBean("usersRepositoryJdbcTemplateImpl", UsersRepository.class);
            System.out.println(usersRepository.findAll());

            UsersService usersService = context.getBean("usersServiceImpl", UsersService.class);
            System.out.println(usersService.SignUp("chmonya@mail.ru"));
        }
    }
}
