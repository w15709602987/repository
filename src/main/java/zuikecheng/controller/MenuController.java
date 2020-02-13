package zuikecheng.controller;
import zuikecheng.bean.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zuikecheng.bean.pageBean_Menu;
import zuikecheng.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;
    @RequestMapping("queMenu")
    public void getMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNum = Integer.parseInt(request.getParameter("pageNum"));

        //接受页面的传递参数
        String conditionName = request.getParameter("conditionName");
        String conditionValue = request.getParameter("conditionValue");

        //条件值去空
        conditionValue=conditionValue.trim();

        request.getSession().setAttribute("pageNum",pageNum);
        request.getSession().setAttribute("conditionName",conditionName);
        request.getSession().setAttribute("conditionValue",conditionValue);



        //返回封装了分页查询数据的pageBean_Menu对象；
        pageBean_Menu pageBeanMenu = menuService.queMenu(pageNum,conditionName,conditionValue);


        pageBeanMenu.setConditionName(conditionName);
        pageBeanMenu.setConditionValue(conditionValue);


        //将返回的数据传递给前端jsp显示
        request.setAttribute("pageBeanMenu",pageBeanMenu);
        request.getRequestDispatcher("/resource.jsp").forward(request,response);
    }
    @RequestMapping("addMenu")
    public void addMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m_id = request.getParameter("m_id");
        String menuName = request.getParameter("menuName");
        String fatherMenuName= request.getParameter("fatherMenuName");
        String menuPath= request.getParameter("menuPath");
        String remarks= request.getParameter("remarks");
        //将数据分装到Menu对象中；
        Menu menu = new Menu();
        menu.setM_id(m_id);
        menu.setMenuName(menuName);
        menu.setFatherMenuName(fatherMenuName);
        menu.setMenuPath(menuPath);
        menu.setRemarks(remarks);
        menu.setState("启用");

        //调用业务层向Menu_table表添加数据
        menuService.addMenu(menu);

        //将页面转到resource.jsp
        //request.getRequestDispatcher("/jsp/resource.jsp").forwarad(request,response);
        //后面改到查询并转发
        request.getRequestDispatcher("/queMenu.do?pageNum=1&&conditionName=menuname&&conditionValue=").forward(request,response);

    }
@RequestMapping("queFatherMenuAndtoMenuAddjsp")
    public void queFatherMenuAndtoMenuAddjsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Menu> list = menuService.queMenuAndtoRoleAddjsp();

        request.getSession().setAttribute("queMenuFatherAndtoMenuAddjsp",list);
        //将页面转到role-add.jsp当页面加载完成时，加载查询玩的Menu表的值，，放在赋菜单资源处！
       /* for (Menu m:list
        ) {
            System.out.println(m+"查询到的菜单表");
        }*/
        request.getRequestDispatcher("/resource-add.jsp").forward(request,response);
    }
    @RequestMapping("banMenuState")
    public void banMenuState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("id");
        String state="禁用";
        menuService.banMenuState(ids,state);


        //禁启用完成后，调用查询
        int pageNum = (int) request.getSession().getAttribute("pageNum");
        String conditionName = (String) request.getSession().getAttribute("conditionName");
        String conditionValue = (String) request.getSession().getAttribute("conditionValue");

        request.getRequestDispatcher("/queMenu.do?pageNum="+pageNum+"&&conditionName="+conditionName+"&&conditionValue="+conditionValue).forward(request,response);

    }
    @RequestMapping("MenuEdit")
    public void MenuEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m_id = request.getParameter("id");


        //调用业务层去查询菜单数据表，将结果返回到前端显示；
        Menu menu = menuService.menuEdit(m_id);

        //将结果存到session中！
        request.getSession().setAttribute("menuEdit", menu);


        //所有的菜单资源
        List<Menu> list = menuService.queMenuAndtoRoleAddjsp();

        request.getSession().setAttribute("MenuEditAll", list);

        request.getRequestDispatcher("/resource-edit.jsp").forward(request, response);
    }
    @RequestMapping("updateMenu")
    public void updateMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m_id = request.getParameter("m_id");
        String menuName = request.getParameter("menuName");
        String fatherMenuName= request.getParameter("fatherMenuName");
        String menuPath= request.getParameter("menuPath");
        String remarks= request.getParameter("remarks");

        //将数据分装到Menu对象中；
        Menu menu = new Menu();
        menu.setM_id(m_id);
        menu.setMenuName(menuName);
        menu.setFatherMenuName(fatherMenuName);
        menu.setRemarks(remarks);
        menu.setMenuPath(menuPath);

        //调用业务层向Menu_table表修改更新数据
        menuService.updateMenu(menu);
        System.out.println(menu.getFatherMenuName());
        int pageNum = (int) request.getSession().getAttribute("pageNum");
        String conditionName = (String) request.getSession().getAttribute("conditionName");
        String conditionValue = (String) request.getSession().getAttribute("conditionValue");

        //将页面转到resource.jsp
        //request.getRequestDispatcher("/jsp/resource.jsp").forward(request,response);
        //后面改到查询并转发
        // request.getRequestDispatcher("/queMenu?pageNum=1&&conditionName=menuname&&conditionValue=").forward(request,response);
        request.getRequestDispatcher("/queMenu.do?pageNum="+pageNum+"&&conditionName="+conditionName+"&&conditionValue="+conditionValue).forward(request,response);

    }
    @RequestMapping("delMenu")
    public void delMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取m_id
        String m_id = request.getParameter("id");

        //删除完成后，调用查询
        int pageNum = (int) request.getSession().getAttribute("pageNum");
        String conditionName = (String) request.getSession().getAttribute("conditionName");
        String conditionValue = (String) request.getSession().getAttribute("conditionValue");


        //从Menu中删除资源,
        menuService.delMenu(m_id);

        //从role_menu_table中删除m_id数据；
        menuService.delRoleMenu(m_id);


        request.getRequestDispatcher("/queMenu.do?pageNum="+pageNum+"&&conditionName="+conditionName+"&&conditionValue="+conditionValue).forward(request,response);



    }









    }
