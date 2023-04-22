package me.ruana.testing2;

import me.ruana.testing2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private DAO dao;

    //    public boolean checkUserExist(User user) {
//        List<User> userList = dao.getAllUsersList();
//        return userList.contains(user); // - сокращённый вариант без if, true и false
//    }
    public boolean checkUserExist(String name) {
        List<User> userList = dao.getAllUsersList();
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
