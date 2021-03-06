package zuikecheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zuikecheng.bean.Customer;
import zuikecheng.bean.PageBean;
import zuikecheng.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static zuikecheng.utils.ControllerUtil.fromCustomer;
import static zuikecheng.utils.ControllerUtil.gettime;


@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
//    @RequestMapping("/index")
//        public ModelAndView getCustomers(ModelAndView mav){
//         mav.setViewName("index");
////         Customer customer = customerService.getCustomer();
////         mav.addObject("customer", customer);
//         mav.addObject("index","123");
//         return mav;
//    }
    //分页，模糊，条件查询
@RequestMapping("uu")
public void getCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int pageNum = Integer.parseInt(request.getParameter("pageNum"));
    String conditionName = request.getParameter("conditionName");
    String conditionValue = request.getParameter("conditionValue");
    String orderByMethod = request.getParameter("orderByMethod");
    conditionValue = conditionValue.trim();

    request.getSession().setAttribute("pageNum", pageNum);
    request.getSession().setAttribute("conditionName", conditionName);
    request.getSession().setAttribute("conditionValue", conditionValue);
    request.getSession().setAttribute("orderByMethod", orderByMethod);
    //返回封装了分页查询数据的pageBean对象；
    PageBean pageBean = customerService.CodAndPageQueCustomer(pageNum, conditionName, conditionValue, orderByMethod);
    pageBean.setConditionName(conditionName);
    pageBean.setConditionValue(conditionValue);
    pageBean.setOrderByMethod(orderByMethod);

    request.getSession().setAttribute("pageBean", pageBean);
    request.getRequestDispatcher("customer.jsp").forward(request, response);

}
    @RequestMapping("show")
    public void lookCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        //调用业务层去查询，将结果返回到前端customer-look.jsp显示；
        Customer customer = customerService.customerLook(id);
        request.getSession().setAttribute("customerLook", customer);
        request.getRequestDispatcher("/customer-look.jsp").forward(request, response);
    }


    @RequestMapping("add")
    public void addCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取用户输入的信息
        String customername = request.getParameter("customername");
        String companyname = request.getParameter("companyname");
        String cellphone = request.getParameter("cellphone");
        String companyaddress = request.getParameter("companyaddress");
        String landline = request.getParameter("landline");
        String introduction = request.getParameter("introduction");
        String remarks = request.getParameter("remarks");
        //获取用户添加的当前时间；
        String addtime=gettime();
        String modtime=addtime;
        Customer customer = fromCustomer(customername,companyname,cellphone,addtime,companyaddress,landline,introduction,remarks,modtime);

        //由Service层来调用方法


        customerService.addCustomer(customer);

        //添加完成后回到客户信息页面，客户信息页面的值是查询数据库得来的；
        request.getRequestDispatcher("/uu.do?pageNum=1&&conditionName=companyname&&conditionValue=&&orderByMethod=addtime").forward(request,response);

    }

    @RequestMapping("delCustomer")
    public void delCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//先获取前端返回的数据，再有业务层去调动执行；
        String[] ids = request.getParameterValues("id");
//        String id = request.getParameterValues("id");
        customerService.delCustomer(ids);
//        for (int i = 0; i < ids.length; i++) {//循环遍历数集，输出排序后集合内的数
//            customerService.delCustomer(ids[i]);//打印数于前台
//        }
        //删除完成后，调用查询
        int pageNum = (int) request.getSession().getAttribute("pageNum");
        String conditionName = (String) request.getSession().getAttribute("conditionName");
        String conditionValue = (String) request.getSession().getAttribute("conditionValue");
        String orderByMethod = (String) request.getSession().getAttribute("orderByMethod");
        request.getRequestDispatcher("/uu.do?pageNum="+pageNum+"&&conditionName="+conditionName+"&&conditionValue="+conditionValue+"&&orderByMethod="+orderByMethod).forward(request,response);

    }

    @RequestMapping("updateCustomer")
    public void setCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        String companyname = request.getParameter("companyname");
        String customername=request.getParameter("customername");
        String companyaddress = request.getParameter("companyaddress");
        String cellphone = request.getParameter("cellphone");
        String landline = request.getParameter("landline");
        String introduction = request.getParameter("introduction");
        String remarks = request.getParameter("remarks");

        String modtime = gettime();
        Customer customer = new Customer();
        customer.setCustomername(customername);
        customer.setCompanyname(companyname);

        customer.setModtime(modtime);
        customer.setCellphone(cellphone);
        customer.setCompanyaddress(companyaddress);
        customer.setLandline(landline);
        customer.setIntroduction(introduction);
        customer.setRemarks(remarks);

        customerService.updateCustomer(customer,id);

        int pageNum = (int) request.getSession().getAttribute("pageNum");
        String conditionName = (String) request.getSession().getAttribute("conditionName");
        String conditionValue = (String) request.getSession().getAttribute("conditionValue");
        String orderByMethod = (String) request.getSession().getAttribute("orderByMethod");
        request.getRequestDispatcher("/uu.do?pageNum="+pageNum+"&&conditionName="+conditionName+"&&conditionValue="+conditionValue+"&&orderByMethod="+orderByMethod).forward(request,response);
    }

    @RequestMapping("customerEdit")
    public void customerEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer customer = customerService.customerEdit(id);
        request.getSession().setAttribute("customerEdit",customer);
        request.getRequestDispatcher("/customer-edit.jsp").forward(request,response);
    }

    @RequestMapping("addmany")
    public void addmanycustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //获取用户输入的信息
        String customername = request.getParameter("customername");
        String companyname = request.getParameter("companyname");
        String cellphone = request.getParameter("cellphone");
        String companyaddress = request.getParameter("companyaddress");
        String landline = request.getParameter("landline");
        String introduction = request.getParameter("introduction");
        String remarks = request.getParameter("remarks");
        int addm = Integer.parseInt(request.getParameter("addm"));



        String addtime = gettime();

        //在添加过程中，添加时间==修改时间
        String modtime =addtime;

        Customer customer = fromCustomer(customername,companyname,cellphone,companyaddress,addtime,landline,introduction,remarks,modtime);
        List<Customer> customerList=new ArrayList<>();
        for (int i = 0; i < addm; i++) {
            customerList.add(customer);
        }
        customerService.addMany(customerList);

        //添加完成后回到客户信息页面，客户信息页面的值是查询数据库得来的；
        request.getRequestDispatcher("/uu.do?pageNum=1&&conditionName=companyname&&conditionValue=&&orderByMethod=addtime").forward(request,response);


    }
//   @RequestMapping("uu")
//public void getCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////       System.out.println("进来了");
////       Customer customer = new Customer();
////       customer = customerService.getCustomer(customer);
////       request.getSession().setAttribute("customer",customer);
////       request.getRequestDispatcher("index.jsp").forward(request,response);
//       request.getSession().setAttribute("abc","123");
//       request.getRequestDispatcher("customer.jsp").forward(request,response);

////接受页面的页码参数
//    int pageNum = Integer.parseInt(request.getParameter("pageNum"));
//    //接受页面的传递参数
//    String conditionname = request.getParameter("conditionname");
//    String conditionValue = request.getParameter("conditionvalue");
//    conditionValue=conditionValue.trim();
//    String orderByMethod = request.getParameter("orderByMethod");
//    request.getSession().setAttribute("pageNum",pageNum);
//    request.getSession().setAttribute("conditionname",conditionname);
//    request.getSession().setAttribute("conditionvalue",conditionValue);
//    request.getSession().setAttribute("orderByMethod",orderByMethod);
//
//    //传递给业务层进行查询
//    UserService userService = new UserService();
//
//    //返回封装了分页查询数据的pageBean对象；
//    PageBean pageBean = userService.CodAndPageQueUser(pageNum,conditionname,conditionValue,orderByMethod);
//    pageBean.setConditionName(conditionname);
//    pageBean.setConditionValue(conditionValue);
//    pageBean.setOrderByMethod(orderByMethod);
//    //将返回的数据传递给前端jsp显示
//    request.setAttribute("pageBean",pageBean);
//    request.getRequestDispatcher("/jsp/customer.jsp").forward(request,response);
//    System.out.println(pageBean);

}
