package me.ruana.testing2;

import me.ruana.testing2.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

 private DAO dao;

    public boolean checkUserExist(User user) {
        ArrayList<User> userList = dao.getAllUsersList();
        return userList.contains(user);
    }
}
