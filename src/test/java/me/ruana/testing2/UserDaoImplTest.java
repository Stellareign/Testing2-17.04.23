package me.ruana.testing2;

import me.ruana.testing2.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.NameNotFoundException;

class UserDaoImplTest {
    private UserDaoImpl userDaoImpl = new UserDaoImpl();
    String containsName = "Иванов И.И.";
    String noContainsName = "Андреев А.А.";

    @Test
        // пользователь есть в базе
    void shouldGetUserByNameContainsInList() throws NameNotFoundException {
        Assertions.assertEquals(new User(containsName), userDaoImpl.getUserByName(containsName));
    }

    @Test
        // исключение
    void shouldGetUserByNameNotContainsInList() {
        Assertions.assertThrows(NameNotFoundException.class, () -> {
            userDaoImpl.getUserByName(noContainsName);
        });
    }

    @Test
        // добавление существующего юзера
    void shouldAddContainsUserToList()  {
        Assertions.assertThrows(RuntimeException.class, () -> {
            userDaoImpl.addUserToList(containsName);
        });
    }


}