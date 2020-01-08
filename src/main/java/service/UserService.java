package service;

import bean.User;
import dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User Dao(String id, String name){
        UserDao userDao = new UserDao();
        return userDao.Dao(id, name);
    }
}
