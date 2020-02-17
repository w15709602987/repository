package zuikecheng.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import zuikecheng.bean.Menu;

import java.util.List;

@Repository
public interface MenuDao {



    @Select("select * from menu where ${conditionName} like concat('%',#{conditionValue},'%') limit #{start},#{pageSize}")
     List<Menu> queMenu(@Param("start") int start,@Param("pageSize") int pageSize,@Param("conditionName") String conditionName,@Param("conditionValue") String conditionValue);

    @Select("select count(*) from menu where #{conditionName} like concat('%',#{conditionValue},'%')")
     int findCountMenu(@Param("conditionName") String conditionName,@Param("conditionValue") String conditionValue);

    @Insert("insert into menu values(#{menu.m_id},#{menu.menuName},#{menu.fatherMenuName},#{menu.menuPath},#{menu.remarks},#{menu.state})")
    void addMenu(@Param("menu") Menu menu);

    @Update("<script>\n" +
            "update menu set state=#{state} where m_id= <foreach collection=\"ids\" index=\"index\" item=\"item\" separator=\",\" >${item}</foreach> </script>")
    void banMenuState(@Param("ids") String[] ids,@Param("state") String state);

    @Select("select * from menu where m_id= #{m_id}")
    Menu menuEdit(@Param("m_id") String m_id);
    @Select("select * from menu")
    List<Menu> queMenuAndtoRoleAddjsp();

    @Update("update menu set menuName=#{menu.menuName},fatherMenuName=#{menu.fatherMenuName},menuPath=#{menu.menuPath},remarks=#{menu.remarks} where m_id=#{menu.m_id}")
    void updateMenu(@Param("menu") Menu menu);

    @Delete("delete from menu where m_id= #{m_id}")
    void delMenu(String m_id);

    @Delete("delete from role_menu where m_id= #{m_id}")
    void delRoleMenu(String m_id);
}
