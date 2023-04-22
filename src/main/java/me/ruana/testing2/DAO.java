package me.ruana.testing2;

import me.ruana.testing2.model.User;

import javax.naming.NameNotFoundException;
import java.util.List;

public interface DAO {
    //  List<User> usersList = new ArrayList<>();

    // ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЯ:
    User addUserToList(String name);

    // ПОИСК ЮЗЕРА ПО ИМЕНИ
    User getUserByName(String name) throws NameNotFoundException;


    // СПИСОК ВСЕХ ПОЛЬЗОВАТЕЛЕЙ:
    List<User> getAllUsersList();
}

