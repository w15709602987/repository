package zuikecheng.service;
import zuikecheng.bean.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuikecheng.bean.pageBean_Menu;
import zuikecheng.dao.CustomerDao;
import zuikecheng.dao.MenuDao;

import javax.swing.plaf.nimbus.State;
import java.util.List;


@Service("MenuService")
public class MenuService {
    @Autowired
    MenuDao menuDao;

    public List<Menu> queMenuAndtoRoleAddjsp() {
        return menuDao.queMenuAndtoRoleAddjsp();
    }

    public pageBean_Menu queMenu(int pageNum, String conditionName, String conditionValue) {
        //处理业务逻辑和业务处理所需的数据
        int pageSize = 5;

        //每一页的记录开始的索引
        int start = (pageNum - 1) * pageSize;

        //调用Dao层查询数据库表Menu获取当前页面的数据；
        List<Menu> list = menuDao.queMenu(start, pageSize, conditionName, conditionValue);


        //调用Dao层查询当前数据库表MEnu的总记录条数以便后面获取总的分页的页码数
        int totalCount = menuDao.findCountMenu(conditionName, conditionValue);


        //计算总的页码页数
        int totalPageNume = (totalCount + pageSize - 1) / pageSize;

        //将所有的分页查询数据分装到pageBean_User中；
        pageBean_Menu pageBeanMenu = new pageBean_Menu();
        pageBeanMenu.setPageNum(pageNum);
        pageBeanMenu.setPageSize(pageSize);
        pageBeanMenu.setTotalCount(totalCount);
        pageBeanMenu.setTotalPageNume(totalPageNume);
        pageBeanMenu.setList(list);
        return pageBeanMenu;
    }

    public void addMenu(Menu menu) {
        menuDao.addMenu(menu);
    }

    public void banMenuState(String[] ids,String state) {
        menuDao.banMenuState(ids,state);
    }

    public Menu menuEdit(String m_id) {
        return menuDao.menuEdit(m_id);
    }

    public void updateMenu(Menu menu) {
        menuDao.updateMenu(menu);
    }

    public void delMenu(String m_id) {
        menuDao.delMenu(m_id);
    }

    public void delRoleMenu(String m_id) {
        menuDao.delRoleMenu(m_id);
    }
}
