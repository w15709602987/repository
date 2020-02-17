package zuikecheng.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import zuikecheng.bean.Menu;

import java.awt.print.Book;
import java.util.List;

public interface UserMapper {
    @Select("select * from user inner join user_role on user.u_id=user_role.u_id inner join role on user_role.r_id=role.r_id inner join role_menu inner join menu on role_menu.m_id=menu.m_id where r_id = #{r_id}")
    @Results({
            @Result(id=true,column="menu.m_id",property="m_id"),
            @Result(column="menuName",property="menuName"),
            @Result(column="fatherMenuName",property="fatherMenuName"),
            @Result(column="menuPath",property="menuPath"),
            @Result(column="menu.remarks",property="remarks"),
            @Result(column="menu.state",property="state")
    })
    List<Menu> getMenus(@Param("u_id")String u_id);
}
