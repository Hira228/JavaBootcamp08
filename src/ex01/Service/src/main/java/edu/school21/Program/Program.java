package edu.school21.Program;

import edu.school21.models.User;
import edu.school21.models.UsersRepositoryJdbcImpl;
import edu.school21.models.UsersRepositoryJdbcTemplateImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {
        try (ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml")){
            UsersRepositoryJdbcImpl usersRepositoryJdbcImpl =
                    context.getBean("usersRepositoryJdbcImpl", UsersRepositoryJdbcImpl.class);

            Optional o = usersRepositoryJdbcImpl.findByEmail("lala@mail.ru");
            System.out.println(o);
        }
    }
}
