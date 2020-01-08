package dao;

import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    User user;
    public User Dao(String id, String name) {

        String sql = "select * from user where username= ? and password= ? ";
        Object[] obj = {id, name};

            return user;

    }
}
