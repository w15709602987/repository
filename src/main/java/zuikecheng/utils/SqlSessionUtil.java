package zuikecheng.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import zuikecheng.bean.User;
import zuikecheng.dao.UserMapper;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionUtil {
    public static SqlSession getSqlSession() {
        try {
            SqlSessionFactory factory =
                    new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
            return factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
