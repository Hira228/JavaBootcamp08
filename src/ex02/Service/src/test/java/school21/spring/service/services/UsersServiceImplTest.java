package school21.spring.service.services;

import edu.school21.models.UsersServiceImpl;
import edu.school21.repositories.UsersService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import school21.spring.service.config.TestApplicationConfig;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplicationConfig.class)
public class UsersServiceImplTest {

    @Autowired
    @Qualifier("usersService")UsersService usersService;

    @Test
    public void testRegistration() throws SQLException {
        Assertions.assertNotNull(usersService.SignUp("mama@mail.ru"));
    }


}
