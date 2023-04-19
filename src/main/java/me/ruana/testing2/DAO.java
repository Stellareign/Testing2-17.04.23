package me.ruana.testing2;

import me.ruana.testing2.model.User;

import javax.naming.NameNotFoundException;
import java.util.ArrayList;

public interface DAO {
    ArrayList<User> userArrayList = new ArrayList<>();


    // ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЯ:
    ArrayList<User> addUserToList(String name);

    // ПОИСК ЮЗЕРА ПО ИМЕНИ
    User getUserByName(String name) throws NameNotFoundException;


    // СПИСОК ВСЕХ ПОЛЬЗОВАТЕЛЕЙ:
    ArrayList<User> getAllUsersList();
}

