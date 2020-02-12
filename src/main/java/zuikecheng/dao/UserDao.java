package zuikecheng.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import zuikecheng.bean.*;

import java.util.List;

@Repository
public interface UserDao {


    @Select("select * from user where ${conditionName} like concat('%',#{conditionValue},'%') order By ${orderByMethod} desc limit #{pageNum1},#{pageSize}")
    List<User> queUser(@Param("pageNum1")int pageNum1,@Param("pageSize")int pageSize,@Param("conditionName") String conditionName,@Param("conditionValue") String conditionValue,@Param("orderByMethod") String orderByMethod);
    @Select("select count(*) from user where #{conditionName} like concat('%',#{conditionValue},'%')")
    int findCountUser(@Param("conditionName")String conditionName, @Param("conditionValue")String conditionValue);

    @Select("select * from role")
    List<Role> queRoleAndtoUserAddjsp();

    @Insert("insert into user values(#{user.u_id},#{user.username},#{user.position},#{user.gender},#{user.age},#{user.cellphone},#{user.initiationtime},#{user.idcard},#{user.remarks},#{user.password})")
    void addUser(@Param("user") User user);

    @Insert("insert into user_role values(#{u_id},#{r_id})")
    void addUser_Role(@Param("u_id") String u_id,@Param("r_id") String r_id);

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


    @Select("select * from user where u_id= #{id}")
    User userEdit(@Param("id") String id);

    @Select("select r_id from user_role where u_id= #{id}")
    String finfindRole(@Param("id")String id);

    @Update("update user set position= #{user.position},gender= #{user.gender},age= #{user.age}," +
            "cellphone=#{user.cellphone},initiationtime= #{user.initiationtime},idcard= #{user.idcard},remarks= #{user.remarks}where u_id= #{user.u_id}")
    void Update(@Param("user") User user);

    @Update("update user_role set r_id= #{r_id} where u_id= #{u_id}")
    void UpdateUser_Role(@Param("u_id") String u_id,@Param("r_id") String r_id);

    @Select("select * from user where username= #{username} and password= #{password} ")
    User loginQue(@Param("username")String username,@Param("password") String password);

    @Select("select r_id from user_role where u_id =(select u_id from user where username= #{username})")
    String findR_id(@Param("username")String username);

    @Select("select roleName from role where r_id= #{r_id}")
    String findRoleName(@Param("r_id")String r_id);

    @Select("select m_id from role_menu where r_id= #{r_id}")
    List<R_id_M_id> findM_ids(@Param("r_id")String r_id);

    @Select("select * from menu")
    List<Menu> queMenuAndtoRoleAddjsp();

//
//



}
