package zuikecheng.service;
import zuikecheng.bean.Menu;
import zuikecheng.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuikecheng.bean.Role_Menu;
import zuikecheng.bean.pageBean_Role;
import zuikecheng.dao.RoleDao;


import java.util.List;

@Service("RoleService")
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public List<Menu> queMenuAndtoRoleAddjsp() {
        return roleDao.queMenuAndtoRoleAddjsp();
    }


    public pageBean_Role queRole(int pageNum, String conditionName, String conditionValue) {
//处理业务逻辑和业务处理所需的数据

        int pageSize = 5;

        //每一页的记录开始的索引
        int start = (pageNum - 1) * pageSize;

        //调用Dao层查询数据库获取当前页面的数据；
        List<Role> list = roleDao.queRole(start, pageSize, conditionName, conditionValue);


        //调用Dao层查询当前数据库的总记录条数以便后面获取总的分页的页码数
        int totalCount = roleDao.findCountRole(conditionName, conditionValue);


        //计算总的页码页数
        int totalPageNume = (totalCount + pageSize - 1) / pageSize;


        //将所有的分页查询数据分装到pageBean_User中；
        pageBean_Role pageBeanRole = new pageBean_Role();
        pageBeanRole.setPageNum(pageNum);
        pageBeanRole.setPageSize(pageSize);
        pageBeanRole.setTotalCount(totalCount);
        pageBeanRole.setTotalPageNume(totalPageNume);
        pageBeanRole.setList(list);

        return pageBeanRole;
    }


    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    public void addRole_Menu(String[] m_id, String r_id) {
        roleDao.addRole_Menu(r_id, m_id);
    }

    public void delRoleOne(String r_id) {
        roleDao.delRoleOne(r_id);
    }

    public void delRole_Menu_table(String r_id) {
        roleDao.delRole_Menu_table(r_id);
    }

    public void delUser_Role_R_id(String r_id,String id) {
        roleDao.delUser_Role_R_id(r_id,id);
    }

    public Role roleEdit(String r_id) {
        return roleDao.roleEdit(r_id);
    }

    public List<Role_Menu> findMenu(String r_id) {
        return roleDao.findMenu(r_id);
    }

    public void UpdateRole(Role role) {
        roleDao.UpdateRole(role);
    }

    public void UpdateRole_Menu_table(String r_id, String[] m_ids) {
        roleDao.UpdateRole_Menu_table(r_id,m_ids);
    }

    public void UpdateRole_Menu_tableAdd(String r_id, String[] m_ids) {
        roleDao.UpdateRole_Menu_tableAdd(r_id,m_ids);
    }
}
