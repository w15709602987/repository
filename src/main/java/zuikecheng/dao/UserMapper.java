package zuikecheng.dao;

import org.apache.ibatis.annotations.*;
import zuikecheng.bean.Menu;

import java.util.List;
@Mapper
public interface UserMapper {

//    @Select("select role.remarks from user inner join user_role on user.u_id=user_role.u_id inner role on user_role.r_id=role.r_id where user.u_id = #{u_id}")
//    String getMenusById(@Param("u_id")String u_id);
    @Select("select * from user inner join user_role on user.u_id=user_role.u_id inner join role on user_role.r_id=role.r_id inner join role_menu on role.r_id=role_menu.r_id inner join menu on role_menu.m_id=menu.m_id where roleName = #{roleName}")
    @Results({
            @Result(id=true,column="menu.m_id",property="m_id"),
            @Result(column="menuName",property="menuName"),
            @Result(column="fatherMenuName",property="fatherMenuName"),
            @Result(column="menuPath",property="menuPath"),
            @Result(column="menu.remarks",property="remarks"),
            @Result(column="menu.state",property="state")
    })
    public  List<Menu> getMenusById(@Param("roleName")String roleName);
}
