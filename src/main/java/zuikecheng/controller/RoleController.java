package zuikecheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zuikecheng.bean.Role_Menu;
import zuikecheng.bean.pageBean_Role;
import zuikecheng.service.RoleService;
import zuikecheng.bean.Menu;
import zuikecheng.bean.Role;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping("queRole")
    public void queRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询数据库表Role,将数据返回到role页面！
        //默认按照角色名查询


        //接受页面的页码参数
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));

        //接受页面的传递参数
        String conditionName = request.getParameter("conditionName");
        String conditionValue = request.getParameter("conditionValue");
        conditionValue=conditionValue.trim();



        request.getSession().setAttribute("pageNum",pageNum);
        request.getSession().setAttribute("conditionName",conditionName);
        request.getSession().setAttribute("conditionValue",conditionValue);


        //返回封装了分页查询数据的pageBean_Role对象；
        pageBean_Role pageBeanRole = roleService.queRole(pageNum,conditionName,conditionValue);


        pageBeanRole.setConditionName(conditionName);
        pageBeanRole.setConditionValue(conditionValue);


        //将返回的数据传递给前端jsp显示
        request.setAttribute("pageBeanRole",pageBeanRole);
        request.getRequestDispatcher("/role.jsp").forward(request,response);

    }
    @RequestMapping("queMenuAndtoRoleAddjsp")
    public void queMenuAndtoRoleAddjsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Menu> list = roleService.queMenuAndtoRoleAddjsp();

        request.getSession().setAttribute("queMenuAndtoRoleAddjsp",list);
        //将页面转到role-add.jsp当页面加载完成时，加载查询玩的Menu表的值，，放在赋菜单资源处！
        /*for (Menu m:list
             ) {
            System.out.println(m+"查询到的菜单表");
        }*/
        request.getRequestDispatcher("/role-add.jsp").forward(request,response);

    }

    @RequestMapping("addRole")
    public void addRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取前台的数据
        //获取前台Role_table表的数据的数据
        String r_id = request.getParameter("r_id");
        String roleName = request.getParameter("roleName");
        String state = request.getParameter("state");

        String remarks = request.getParameter("remarks");



        //获取menu_table的数据//还有需要存到中间表的r_id_id的值
        String[] m_id = request.getParameterValues("menu");

        //封装Role的数据
        Role role = new Role();
        role.setR_id(r_id);
        role.setRoleName(roleName);
        role.setState(state);
        role.setRemarks(remarks);



        //调用service业务层去添加
        roleService.addRole(role);

        roleService.addRole_Menu(m_id,r_id);

        //将页面转到role.jsp
        //后面改为查询

        request.getRequestDispatcher("/queRole.do?pageNum=1&&conditionName=roleName&&conditionValue=").forward(request,response);


    }
    @RequestMapping("delRole")
    public void delRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String r_id = request.getParameter("id");

        //删除完成后，调用查询
        int pageNum = (int) request.getSession().getAttribute("pageNum");
        String conditionName = (String) request.getSession().getAttribute("conditionName");
        String conditionValue = (String) request.getSession().getAttribute("conditionValue");



        //删除角色表中的角色数据
        roleService.delRoleOne(r_id);

        //删除角色权限表中此角色id对应的数据
        roleService.delRole_Menu_table(r_id);


        //删除用户角色表中此角色id的数据（将此角色的id设置为del,表示用户对应的此角色已删除！）
        String id="del";
        roleService.delUser_Role_R_id(r_id,id);

        request.getRequestDispatcher("/queRole.do?pageNum="+pageNum+"&&conditionName="+conditionName+"&&conditionValue="+conditionValue).forward(request,response);

    }
    @RequestMapping("RoleEdit")
    public void RoleEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//拿到前端传过来的角色id；
        String r_id = request.getParameter("id");



        //调用业务层去查询角色数据表，将结果返回到前端显示；
        Role role = roleService.roleEdit(r_id);

        //得到权限菜单m_id
        List<Role_Menu> m_ids= roleService.findMenu(r_id);


        //将结果存到session中！
        request.getSession().setAttribute("roleEdit",role);
        request.getSession().setAttribute("roleEdit_m_id",m_ids);

        List<Menu> list = roleService.queMenuAndtoRoleAddjsp();

        request.getSession().setAttribute("roleMenuEdit",list);

        request.getRequestDispatcher("/role-edit.jsp").forward(request,response);

    }
    @RequestMapping("updateRole")
    public void updateRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取权限m_id的值，是一个字符串数组！
        String[] m_ids = request.getParameterValues("menu");

        //封装Role的数据
        String r_id= request.getParameter("r_id");
        String roleName = request.getParameter("roleName");
        String state = request.getParameter("state");
        String remarks = request.getParameter("remarks");
        Role role = new Role();
        role.setR_id(r_id);
        role.setRoleName(roleName);
        role.setState(state);
        role.setRemarks(remarks);
        //调用service业务层去修改
        //编辑修改角色表信息
        roleService.UpdateRole(role);
        //编辑修改角色表信息时更新角色权限表删除旧的
        roleService.UpdateRole_Menu_table(r_id,m_ids);
        //编辑修改角色表信息时更新角色权限表添加新的
        roleService.UpdateRole_Menu_tableAdd(r_id,m_ids);

        //改完之后走到查询页面；
        int pageNum = (int) request.getSession().getAttribute("pageNum");
        String conditionName = (String) request.getSession().getAttribute("conditionName");
        String conditionValue = (String) request.getSession().getAttribute("conditionValue");
        request.getRequestDispatcher("/queRole.do?pageNum="+pageNum+"&&conditionName="+conditionName+"&&conditionValue="+conditionValue).forward(request,response);
    }
    @RequestMapping("roleShow")
    public void roleShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //拿到前端传过来的id；
        String r_id = request.getParameter("id");

        //得到权限菜单m_id
        List<Role_Menu> m_ids= roleService.findMenu(r_id);
        request.getSession().setAttribute("roleShow_m_id",m_ids);
        //调用业务层去查询，将结果返回到前端role-look.jsp显示；
        Role role = roleService.roleEdit(r_id);
        request.getSession().setAttribute("roleShow",role);

        List<Menu> list = roleService.queMenuAndtoRoleAddjsp();
        request.getSession().setAttribute("roleMenuShow",list);

        request.getRequestDispatcher("/role-look.jsp").forward(request,response);

    }











    }
