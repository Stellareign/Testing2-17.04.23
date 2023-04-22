package me.ruana.testing2;


import me.ruana.testing2.model.User;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service

public class UserDaoImpl implements DAO {
    private List<User> usersList;

    public UserDaoImpl() {
        this.usersList = Arrays.asList(
                new User("Иванов И.И."),
                new User("Петров П.П."),
                new User("Сидоров С.С."),
                new User("Васечкин В.В.")
        );
    }


    // ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЯ:
    @Override
    public User addUserToList(String name) {
        for (User user : usersList)
            if (user.getName().equals(name)) {
                throw new RuntimeException("Пользователь уже был добавлен в базу ранее!");
            } else {
                usersList.add(user);
            }
        return new User(name);
    }


    // ПОИСК ЮЗЕРА ПО ИМЕНИ:
    @Override
    public User getUserByName(String name) throws NameNotFoundException {
        for (User user : usersList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new NameNotFoundException("Пользователь не найден в базе!");
    }


    // СПИСОК ВСЕХ ПОЛЬЗОВАТЕЛЕЙ:
    @Override
    public List<User> getAllUsersList() {
        if (usersList.isEmpty()) {
            throw new NoSuchElementException("Список пользователей пуст!");
        } else
            return usersList;
    }

    //======================================================================================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDaoImpl userDao)) return false;
        return Objects.equals(usersList, userDao.usersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersList);
    }

    public UserDaoImpl setUsersList(List<User> usersList) {
        this.usersList = usersList;
        return this;
    }
}

