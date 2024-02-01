package edu.school21.Program;

import edu.school21.models.User;
import edu.school21.models.UsersRepositoryJdbcTemplateImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {
        try (ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml")){
            UsersRepositoryJdbcTemplateImpl usersRepositoryJdbcTemplate =
                    context.getBean("usersRepositoryJdbcImpl", UsersRepositoryJdbcTemplateImpl.class);

            List list = usersRepositoryJdbcTemplate.findAll();
            System.out.println(list);
            System.out.println(usersRepositoryJdbcTemplate.findById(1L));
            User user = new User(2L, "KAKA@MAIL.RU");
//            usersRepositoryJdbcTemplate.save(user);
            //user.setEmail("mlololol@MAIL.RU");
            //usersRepositoryJdbcTemplate.update(user);
            usersRepositoryJdbcTemplate.delete(2L);

            Optional us = usersRepositoryJdbcTemplate.findByEmail("lala@mail.ru");
            System.out.println(us);
        }
    }
}
