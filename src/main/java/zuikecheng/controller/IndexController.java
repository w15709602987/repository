package zuikecheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import zuikecheng.bean.Customer;
import zuikecheng.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@Controller
public class IndexController {
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
@RequestMapping("uu")
public void getCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     System.out.println("进来了");

    List<Customer> customerList = customerService.getCustomer();
    request.getSession().setAttribute("customers",customerList);
    request.getRequestDispatcher("123.jsp").forward(request,response);

//   @RequestMapping("uu")
//public void getCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////       System.out.println("进来了");
////       Customer customer = new Customer();
////       customer = customerService.getCustomer(customer);
////       request.getSession().setAttribute("customer",customer);
////       request.getRequestDispatcher("index.jsp").forward(request,response);
//       request.getSession().setAttribute("abc","123");
//       request.getRequestDispatcher("123.jsp").forward(request,response);

}
}
