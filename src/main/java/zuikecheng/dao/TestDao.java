package zuikecheng.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import zuikecheng.bean.Customer;
import zuikecheng.bean.Test;

import java.util.List;
@Repository
public interface TestDao {
    @Select("select * from test")
    List<Test> findTest();
    @Delete("<script>\n" +
            "         delete from test where tid in\n" +
            "         <foreach collection=\"ids\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" close=\")\">\n" +
            "         #{item}       \n" +
            "         </foreach>    \n" +
            "</script>")
    void delTest(@Param("ids")String[] ids);
}
