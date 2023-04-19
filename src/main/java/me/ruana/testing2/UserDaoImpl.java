package me.ruana.testing2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ruana.testing2.model.User;

import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDaoImpl implements DAO {
    ArrayList<User> userArrayList = new ArrayList<>();

    // ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЯ:
    @Override
    public ArrayList<User> addUserToList(String name) {
        User user = new User(name);
        if (!userArrayList.contains(user)) {
            userArrayList.add(user);
        }
        return userArrayList;
    }

    // ПОИСК ЮЗЕРА ПО ИМЕНИ:
    @Override
    public User getUserByName(String name) throws NameNotFoundException {
        User user = new User(name);
        if (userArrayList.contains(user)) {
            return user;
        } else throw new NameNotFoundException("Пользователь не найден в базе!");
    }

    // СПИСОК ВСЕХ ПОЛЬЗОВАТЕЛЕЙ:
    @Override
    public ArrayList<User> getAllUsersList() {
        if (userArrayList.isEmpty()) {
            throw new NoSuchElementException("Список пользователей пуст!");
        } else
            return userArrayList;
    }

}

