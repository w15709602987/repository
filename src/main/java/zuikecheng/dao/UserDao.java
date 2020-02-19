package zuikecheng.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import zuikecheng.bean.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserDao {

    //分页模糊查询user表
    @Select("select * from user where ${conditionName} like concat('%',#{conditionValue},'%') order By ${orderByMethod} desc limit #{pageNum1},#{pageSize}")
    List<User> queUser(@Param("pageNum1")int pageNum1,@Param("pageSize")int pageSize,@Param("conditionName") String conditionName,@Param("conditionValue") String conditionValue,@Param("orderByMethod") String orderByMethod);
    //
    @Select("select count(*) from user where #{conditionName} like concat('%',#{conditionValue},'%')")
    int findCountUser(@Param("conditionName")String conditionName, @Param("conditionValue")String conditionValue);
    //查询所有的role角色，在增加user时显示
    @Select("select * from role")
    List<Role> queRoleAndtoUserAddjsp();
    //增加user数据，并增加表user_role数据
    @Insert("insert into user values(#{user.u_id},#{user.username},#{user.position},#{user.gender},#{user.age},#{user.cellphone},#{user.initiationtime},#{user.idcard},#{user.remarks},#{user.password})")
    void addUser(@Param("user") User user);
    @Insert("insert into user_role values(#{u_id},#{r_id})")
    void addUser_Role(@Param("u_id") String u_id,@Param("r_id") String r_id);
    //删除user根据u_id集合ids，并删除其在user_role表中数据
    @Delete("<script>\n" +
            "         delete from user where u_id in\n" +
            "        <foreach collection=\"ids\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" close=\")\">\n" +
            "                #{item}       \n" +
            "        </foreach>    \n" +
            "</script>")
    void delUser(@Param("ids") String[] ids);
    @Delete("<script>\n" +
            "         delete from user_role where u_id in\n" +
            "        <foreach collection=\"ids\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" close=\")\">\n" +
            "                #{item}       \n" +
            "        </foreach>    \n" +
            "</script>")
    void delUserInRole(@Param("ids")String[] ids);

    //在更新界面查询user数据，并查询对应的r_id
    @Select("select * from user where u_id= #{id}")
    User userEdit(@Param("id") String id);
    @Select("select r_id from user_role where u_id= #{id}")
    String finfindRole(@Param("id")String id);
    //更新数据时，更新对应的user_role表数据
    @Update("update user set position= #{user.position},gender= #{user.gender},age= #{user.age}," +
            "cellphone=#{user.cellphone},initiationtime= #{user.initiationtime},idcard= #{user.idcard},remarks= #{user.remarks}where u_id= #{user.u_id}")
    void Update(@Param("user")User user);
    @Update("update user_role set r_id= #{r_id} where u_id= #{u_id}")
    void UpdateUser_Role(@Param("u_id") String u_id,@Param("r_id") String r_id);

    //异步校验查询user校验
    @Select("select * from user where username= #{username} and password= #{password} ")
    List<User> findUserByUsername(@Param("username")String username,@Param("password")String password);


    //登录时通过用户名密码验证登录，登录时通过用户名查询roleName，通过roleName查询对应权限下的menu。
    @Select("select * from user inner join user_role on user.u_id=user_role.u_id inner join role on user_role.r_id=role.r_id where username=#{username} and password=#{password}")
    @Results({
            @Result(id = true, column = "user.u_id", property = "u_id"),
            @Result(column = "username", property = "username"),
            @Result(column = "position", property = "position"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "age", property = "age"),
            @Result(column = "cellphone", property = "cellphone"),
            @Result(column = "initiationtime", property = "initiationtime"),
            @Result(column = "idcard", property = "idcard"),
            @Result(column = "user.remarks", property = "remarks"),
            @Result(column = "password", property = "password"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleName", property = "Menus", many = @Many(select = "zuikecheng.dao.UserMapper.getMenusById", fetchType = FetchType.DEFAULT))
    })
    User loginQue(@Param("username")String username, @Param("password") String password);
//    inner join role_menu on role.r_id=role_menu.r_id inner join menu on role_menu.m_id=menu.m_id
//    @Select("select roleName from role where r_id= (select r_id from user_role where u_id =(select u_id from user where username= #{username}))")
//    String findRoleName(@Param("username")String username);

//    @Select("select menu.u_id,menuName,fartherMenuName,menuPath,remarks,menu.state,roleName from ((((user inner join user_role on user.u_id=user_role.u_id) inner join role on user_role.r_id=role.r_id) inner join role_menu on role.r_id=role_menu.r_id) inner join menu on role_menu.m_id=menu.m_id) where username=#{username} and password=#{password}")
//    List queMenuAndtoRoleAddjsp(@Param("roleName")String roleName,@Param("password") String password);
////
////
//    @Select("select roleName from ((((user inner join user_role on user.u_id=user_role.u_id) inner join role on user_role.r_id=role.r_id) inner join role_menu on role.r_id=role_menu.r_id) inner join menu on role_menu.m_id=menu.m_id) where username=#{username}")
//    String findRoleName(@Param("username")String username);


}
