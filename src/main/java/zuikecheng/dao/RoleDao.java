package zuikecheng.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import zuikecheng.bean.Menu;
import zuikecheng.bean.Role;
import zuikecheng.bean.Role_Menu;

import java.util.List;
@Repository
public interface RoleDao {

    @Select("select * from role where ${conditionName} like concat('%',#{conditionValue},'%') limit #{start},#{pageSize}")
    List<Role> queRole(@Param("start") int start,@Param("pageSize")  int pageSize,@Param("conditionName")  String conditionName,@Param("conditionValue")  String conditionValue);

    @Select("select count(*) from role where #{conditionName} like concat('%',#{conditionValue})")
    int findCountRole(@Param("conditionName") String conditionName,@Param("conditionValue")  String conditionValue);

    @Select("select * from menu")
    List<Menu> queMenuAndtoRoleAddjsp();

    @Insert("insert into role values(#{role.r_id},#{role.roleName},#{role.state},#{role.remarks})")
    void addRole(@Param("role") Role role);

    @Insert("<script>\n" +
            "insert into role_menu values <foreach collection=\"m_id\" index=\"index\" item=\"item\" separator=\",\" >(#{r_id},${item})</foreach> </script>")
    void addRole_Menu(@Param("r_id") String r_id,@Param("m_id") String[] m_id);

    @Delete("delete from role where r_id= #{r_id}")
    void delRoleOne(@Param("r_id")String r_id);

    @Delete("delete from role_menu where r_id= #{r_id}")
    void delRole_Menu_table(@Param("r_id")String r_id);

    @Update("update user_role set r_id= #{id} where r_id= #{r_id}")
    void delUser_Role_R_id(@Param("r_id")String r_id,@Param("id") String id);

    @Select("select * from role where r_id= #{r_id}")
    @Results({
            @Result(id=true,column = "r_id", property = "r_id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "state",property = "state"),
            @Result(column = "remarks",property = "remarks"),
            @Result(column = "m_id", property = "r_id", one = @One(select = "com.zuikecheng.dao.RoleDao.findMenu", fetchType = FetchType.DEFAULT))
    })
    Role roleEdit(@Param("r_id")String r_id);

    @Select("select m_id from role_menu where r_id= #{r_id}")
    List<Role_Menu> findMenu(@Param("r_id")String r_id);

    @Update("update role set roleName= #{role.roleName},state= #{role.state},remarks= #{role.remarks} where r_id= #{role.r_id}")
    void UpdateRole(@Param("role")Role role);

    @Delete("delete from role_menu where r_id= #{r_id}")
    @Insert("<script>\n" +
            "insert into role_menu values <foreach collection=\"m_ids\" index=\"index\" item=\"item\" separator=\",\" >(#{r_id},${item})</foreach> </script>")
    void UpdateRole_Menu_table(@Param("r_id")String r_id,@Param("m_ids") String[] m_ids);

    @Insert("<script>\n" +
            "insert into role_menu values <foreach collection=\"m_ids\" index=\"index\" item=\"item\" separator=\",\" >(#{r_id},${item})</foreach> </script>")
    void UpdateRole_Menu_tableAdd(@Param("r_id")String r_id,@Param("m_ids") String[] m_ids);
}
