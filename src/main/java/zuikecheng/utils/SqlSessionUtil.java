package zuikecheng.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

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
