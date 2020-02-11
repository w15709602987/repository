package zuikecheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zuikecheng.bean.Role;
import zuikecheng.bean.User;
import zuikecheng.bean.pageBean_User;
import zuikecheng.service.UserService;
import zuikecheng.utils.Md5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("queUser")
    public void queUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//接受页面的页码参数
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        //接受页面的传递参数
        String conditionName = request.getParameter("conditionName");
        String conditionValue = request.getParameter("conditionValue");
        conditionValue = conditionValue.trim();
        String orderByMethod = request.getParameter("orderByMethod");
        request.getSession().setAttribute("pageNum", pageNum);
        request.getSession().setAttribute("conditionName", conditionName);
        request.getSession().setAttribute("conditionValue", conditionValue);
        request.getSession().setAttribute("orderByMethod", orderByMethod);

        // System.out.println(request.getSession().getAttribute("conditionname"));

        //传递给业务层进行查询

        //返回封装了分页查询数据的pageBean对象；

        pageBean_User pageBeanUser = userService.queUser(pageNum, conditionName, conditionValue, orderByMethod);
        pageBeanUser.setConditionName(conditionName);
        pageBeanUser.setConditionValue(conditionValue);
        pageBeanUser.setOrderByMethod(orderByMethod);

        //将返回的数据传递给前端jsp显示
        request.setAttribute("pageBeanUser", pageBeanUser);
        request.getRequestDispatcher("/user.jsp").forward(request, response);
    }

    @RequestMapping("queRoleAndtoUserAddjsp")
    public void queRoleAndtoUserAddjsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Role> list = userService.queRoleAndtoUserAddjsp();

        request.getSession().setAttribute("queRoleAndtoUserAddjsp", list);
        //将页面转到user-add.jsp当页面加载完成时，加载查询玩的Role表的值，，放在赋角色处！
        request.getRequestDispatcher("/user-add.jsp").forward(request, response);

    }

    @RequestMapping("addUser")
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取前台User_table表的数据的数据
        String position = request.getParameter("position");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String cellPhone = request.getParameter("cellPhone");
        String addTime = request.getParameter("addTime");
        String idCard = request.getParameter("idCard");
        String remarks = request.getParameter("remarks");
        String u_id = "u_" + String.valueOf(System.currentTimeMillis()).substring(4, 13);

        //获取Role_table的数据//还有需要存到中间表的user_id的值
        String r_id = request.getParameter("role");

        //封装User的数据
        User user = new User();
        user.setPosition(position);
        user.setUsername(userName);
        user.setGender(gender);
        user.setAge(age);
        user.setCellphone(cellPhone);
        user.setInitiationtime(addTime);
        user.setIdcard(idCard);
        user.setRemarks(remarks);

        //默认密码六个六  //666666
        user.setPassword(Md5.md5("666666"));

        //生成默认的用户id；加时间戳，保证用户id不重复！
        user.setU_id(u_id);

        //调用service业务层去添加
        userService.addUser(user);

        userService.addUser_Role(u_id, r_id);

        //将页面转到user.jsp
        //后面改为查询
        request.getRequestDispatcher("/queUser.do?pageNum=1&&conditionName=username&&conditionValue=&&orderByMethod=initiationtime").forward(request, response);
    }

    @RequestMapping("delUser")
    public void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先获取前端返回的数据，再有业务层去调动执行；
        String[] ids = request.getParameterValues("id");
        userService.delUser(ids);

        //删除完成后，调用查询
        int pageNum = (int) request.getSession().getAttribute("pageNum");
        String conditionName = (String) request.getSession().getAttribute("conditionName");
        String conditionValue = (String) request.getSession().getAttribute("conditionValue");
        String orderByMethod = (String) request.getSession().getAttribute("orderByMethod");

      /*  //测试代码
        System.out.println(pageNum+"删除模块的页数");
        System.out.println(conditionvalue+"删除模块的关键字");
        System.out.println(conditionname+"删除模块的名字");
        System.out.println(orderByMethod+"删除模块的排序");*/

        request.getRequestDispatcher("/queUser.do?pageNum=" + pageNum + "&&conditionName=" + conditionName + "&&conditionValue=" + conditionValue + "&&orderByMethod=" + orderByMethod).forward(request, response);

    }

    @RequestMapping("userEdit")
    public void userEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //拿到前端传过来的id；
        String id = request.getParameter("id");


        //调用业务层去查询，将结果返回到前端customer.jsp显示；
        User user = userService.userEdit(id);

        //得到角色id
        String r_id = userService.findRole(id);

        //将结果存到session中！
        request.getSession().setAttribute("userEdit", user);
        request.getSession().setAttribute("userEdit_r_id", r_id);

        List<Role> list = userService.queRoleAndtoUserAddjsp();

        request.getSession().setAttribute("userRoleEdit", list);

        request.getRequestDispatcher("/user-edit.jsp").forward(request, response);
    }

    @RequestMapping("updateUser")
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前台数据
        String u_id = request.getParameter("u_id");
        String r_id = request.getParameter("role");

        String position = request.getParameter("position");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String cellPhone = request.getParameter("cellPhone");
        String addTime = request.getParameter("addTime");
        String idCard = request.getParameter("idCard");
        String remarks = request.getParameter("remarks");

        //封装User的数据
        User user = new User();
        user.setPosition(position);
        user.setUsername(userName);
        user.setGender(gender);
        user.setAge(age);
        user.setCellphone(cellPhone);
        user.setInitiationtime(addTime);
        user.setIdcard(idCard);
        user.setRemarks(remarks);
        user.setU_id(u_id);

        //调用service业务层去添加
        userService.Update(user);

        userService.UpdateUser_Role(u_id, r_id);

        //改完之后走到查询页面；
        int pageNum = (int) request.getSession().getAttribute("pageNum");
        String conditionName = (String) request.getSession().getAttribute("conditionName");
        String conditionValue = (String) request.getSession().getAttribute("conditionValue");
        String orderByMethod = (String) request.getSession().getAttribute("orderByMethod");
        request.getRequestDispatcher("/queUser.do?pageNum=" + pageNum + "&&conditionName=" + conditionName + "&&conditionValue=" + conditionValue + "&&orderByMethod=" + orderByMethod).forward(request, response);

    }

    @RequestMapping("userShow")
    public void userShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");


        //调用业务层去查询，将结果返回到前端customer-look.jsp显示；
        User user = userService.userEdit(id);
        request.getSession().setAttribute("userShow",user);
        request.getRequestDispatcher("/user-look.jsp").forward(request,response);
    }
}