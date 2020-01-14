package zuikecheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test")
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
   @RequestMapping("/uu")
public void getCustomers(){
    System.out.println("进来了");
   // mav.setViewName("123.jsp");
    //mav.addObject("abc","123");
   // return mav;
}
}
