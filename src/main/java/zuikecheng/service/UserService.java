package zuikecheng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuikecheng.bean.Role;
import zuikecheng.bean.User;
import zuikecheng.bean.pageBean_User;
import zuikecheng.dao.UserDao;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public pageBean_User queUser(int pageNum, String conditionName, String conditionValue, String orderByMethod) {
        int pageSize = 5;

        //每一页的记录开始的索引
        int pageNum1 = (pageNum - 1) * pageSize;

        //调用Dao层查询数据库获取当前页面的数据；
        List<User> list = userDao.queUser(pageNum1, pageSize, conditionName, conditionValue, orderByMethod);


        //调用Dao层查询当前数据库的总记录条数以便后面获取总的分页的页码数

        int totalCount = userDao.findCountUser(conditionName, conditionValue);

        //计算总的页码页数
        int totalPageNume = (totalCount + pageSize - 1) / pageSize;

        //将所有的分页查询数据分装到pageBean_User中；
        pageBean_User pageBeanUser = new pageBean_User();
        pageBeanUser.setPageNum(pageNum);
        pageBeanUser.setPageSize(pageSize);
        pageBeanUser.setTotalCount(totalCount);
        pageBeanUser.setTotalPageNume(totalPageNume);
        pageBeanUser.setList(list);

     /*   PageBean pageBean = new PageBean();
        pageBean.setPageNum(pageNum);                   // 当前页码的页数
        pageBean.setPageSize(pageSize);                //每页显示的记录条数
        pageBean.setTotalCount(totalCount);           //总的记录条数
        pageBean.setTotalPageNume(totalPageNume);    //总的页码数
        pageBean.setUser(list);                     //查询后的customer的集合*/
        return pageBeanUser;
    }

    public List<Role> queRoleAndtoUserAddjsp() {
        return userDao.queRoleAndtoUserAddjsp();
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void addUser_Role(String u_id, String r_id) {
        userDao.addUser_Role(u_id, r_id);
    }

    public void delUser(String[] ids) {
        userDao.delUser(ids);
        userDao.delUserInRole(ids);
    }

    public User userEdit(String id) {
        return userDao.userEdit(id);
    }

    public String findRole(String id) {
        return userDao.finfindRole(id);
    }

    public void Update(User user) {
        userDao.Update(user);
    }

    public void UpdateUser_Role(String u_id, String r_id) {
        userDao.UpdateUser_Role(u_id, r_id);
    }
}
