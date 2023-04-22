package me.ruana.testing2;

import me.ruana.testing2.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.naming.NameNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserDaoImpl userDao;
    @InjectMocks
    private UserService out;
    List<User> userList = Arrays.asList(
            new User("Иванов И.И."),
            new User("Петров П.П."));

    @Test
    public void shouldCheckUserExist() throws NameNotFoundException {
        when(userDao.getAllUsersList()).thenReturn(userList);
        assertTrue(out.checkUserExist("Иванов И.И."));
    }

    @Test
    public void shouldCheckUserNoExist() throws NameNotFoundException {
        when(userDao.getAllUsersList()).thenReturn(userList);
        assertFalse(out.checkUserExist("Васечкин А.Е."));
    }
}