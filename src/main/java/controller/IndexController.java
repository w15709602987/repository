package controller;

import bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;

import javax.ws.rs.GET;


@Controller
@RequestMapping("/uu")
public class IndexController {
   // @Autowired
 //   CustomerService customerService;
//    @RequestMapping("/index")
//        public ModelAndView getCustomers(ModelAndView mav){
//         mav.setViewName("index");
////         Customer customer = customerService.getCustomer();
////         mav.addObject("customer", customer);
//         mav.addObject("index","123");
//         return mav;
//    }

public void getCustomers(){
    System.out.println("进来了");
   // mav.setViewName("123.jsp");
    //mav.addObject("abc","123");
   // return mav;
}
}
