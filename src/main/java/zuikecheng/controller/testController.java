package zuikecheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zuikecheng.bean.Test;
import zuikecheng.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class testController {
    @Autowired
    TestService testService;
    @RequestMapping("test")
    public void Role(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Test> list = testService.findTest();
        request.getSession().setAttribute("test",list);
        request.getRequestDispatcher("/test.jsp").forward(request,response);


    }
    @RequestMapping("deltest")
    public void Deltest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("tid");
        System.out.println(ids);
        testService.sendTest(ids);
        request.getRequestDispatcher("/test.do").forward(request,response);
    }

}
