package zuikecheng.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zuikecheng.bean.*;
import zuikecheng.bean.Menu;
import zuikecheng.dao.UserDao;
import zuikecheng.service.UserService;
import zuikecheng.utils.Md5;
import zuikecheng.utils.SqlSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        request.getSession().setAttribute("userShow", user);
        request.getRequestDispatcher("/user-look.jsp").forward(request, response);
    }

    @Autowired
    HttpServletResponse response;

    @RequestMapping("yiBu")
    public String ajax(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = Md5.md5(request.getParameter("password"));
        System.out.println(username + password);
        PrintWriter out = response.getWriter();
        if (userService.findPassword(username, password) == false) {
            out.print(false);
        } else {
            out.print(true);
        }
        return null;
    }

    @RequestMapping("login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = Md5.md5(request.getParameter("password"));
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User u = userDao.loginQue(username, password);

//            List<User> users = (List<User>) List.subList(0, 9);
//            User user = users.get(1);
////            User user = userService.loginQue(username, password);
        if (u == null) {
            //不一致，将错误信息存入session,转会到登陆页面
            request.getSession().setAttribute("msg", "用户名或者密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
//                //用户登陆时根据用户名得到对应的角色名称roleName;
////                List List = userService.findRoleName(username,password);
////                String roleName = List.get(1).toString("RoleName");
//                List<String> roleNames = (List<String>)List.subList(13, 13);
            String roleName = u.getRoleName();
            System.out.println(u);
            System.out.println(u.getMenus());
//
// 登陆时根据角色r_id得到对应的权限m_id[],将此数据保存在session中，meanTest取值显示;
            List<Menu> menuTest = u.getMenus();
            request.getSession().setAttribute("menuTest", menuTest);
            request.getSession().setAttribute("roleName", roleName);
//
//                // 一致将用户信息存入session,重定向到主页面，
            request.getSession().setAttribute("user", u);
            response.sendRedirect("/testSSMStepByStep/index.jsp");
        }
    }
}
//        String code = request.getParameter("code");
//
//        //得到session中存储的code真值
//        String CODETRUE = (String) request.getSession().getAttribute("checkcode_session");
//
//
//
//
//        //实现字母验证不区分大小写验证
//        code=code.toLowerCase();
//        CODETRUE = CODETRUE.toLowerCase();
//
//        // 验证验证码对不对，若不对，则提示不对
//        if (CODETRUE.equals(code)==false||code==null){
//
//            //将错误信息存放到session中,并将页面转会到登陆页面；
//            //request.setAttribute("msg1","验证码输入错误！");
//            request.getSession().setAttribute("msg1","验证码输入错误！");
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//
//            //return返回，结束本程序！
//            return;
//        }

        //验证码正确，则需要，将用户名和密码带到数据库中去查询是否一致，
        //不一致，将错误信息存入session,转发到登陆页面
        // 一致将用户信息存入session,重定向到主页面，

//    }
//    @RequestMapping("img")
//    public void img(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int width = 120;
//        int height = 30;
//
//        // 步骤一 绘制一张内存中图片
//        BufferedImage bufferedImage = new BufferedImage(width, height,
//                BufferedImage.TYPE_INT_RGB);
//
//        // 步骤二 图片绘制背景颜色 ---通过绘图对象
//        Graphics graphics = bufferedImage.getGraphics();// 得到画图对象 --- 画笔
//        // 绘制任何图形之前 都必须指定一个颜色
//        graphics.setColor(getRandColor(200, 250));
//        graphics.fillRect(0, 0, width, height);
//
//        // 步骤三 绘制边框
//        graphics.setColor(Color.WHITE);
//        graphics.drawRect(0, 0, width - 1, height - 1);
//
//        // 步骤四 四个随机数字
//        Graphics2D graphics2d = (Graphics2D) graphics;
//        // 设置输出字体
//        graphics2d.setFont(new Font("宋体", Font.BOLD, 18));
//
//        String words ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
//
//        Random random = new Random();// 生成随机数
//
//        StringBuffer buffer=new StringBuffer();//字符串缓冲区对象
//        // 定义x坐标
//        int x = 10;
//        for (int i = 0; i < 4; i++) {
//            // 随机颜色
//            graphics2d.setColor(new Color(20 + random.nextInt(110), 20 + random
//                    .nextInt(110), 20 + random.nextInt(110)));
//            // 旋转 -30 --- 30度
//            int jiaodu = random.nextInt(60) - 30;
//            // 换算弧度
//            double theta = jiaodu * Math.PI / 180;
//
//            // 生成一个随机数字
//            int index = random.nextInt(words.length()); // 生成随机数 0 到 length - 1
//            // 获得字母数字
//            char c = words.charAt(index);
//            buffer.append(c);//把每一个汉字加到字符串缓冲区中
//            // 将c 输出到图片
//            graphics2d.rotate(theta, x, 20);
//            graphics2d.drawString(String.valueOf(c), x, 20);
//            graphics2d.rotate(-theta, x, 20);
//            x += 30;
//        }
//        //System.out.println("checkcode_session   checkimg="+buffer.toString());
//
////        将验证码存储到session中
//        request.getSession().setAttribute("checkcode_session",buffer.toString());
//
//
//        // 步骤五 绘制干扰线
//        graphics.setColor(getRandColor(160, 200));
//        int x1;
//        int x2;
//        int y1;
//        int y2;
//        for (int i = 0; i < 10; i++) {
//            x1 = random.nextInt(width);
//            x2 = random.nextInt(12);
//            y1 = random.nextInt(height);
//            y2 = random.nextInt(12);
//            graphics.drawLine(x1, y1, x1 + x2, x2 + y2);
//        }
//
//        // 将上面图片输出到浏览器 ImageIO
//        graphics.dispose();// 释放资源
//        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
//    }
//    /**
//     * 取其某一范围的color
//     *
//     * @param fc
//     *            int 范围参数1
//     * @param bc
//     *            int 范围参数2
//     * @return Color
//     */
//    private Color getRandColor(int fc, int bc) {
//        // 取其随机颜色
//        Random random = new Random();
//        if (fc > 255) {
//            fc = 255;
//        }
//        if (bc > 255) {
//            bc = 255;
//        }
//        int r = fc + random.nextInt(bc - fc);
//        int g = fc + random.nextInt(bc - fc);
//        int b = fc + random.nextInt(bc - fc);
//        return new Color(r, g, b);
//    }
