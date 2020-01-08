package controller;

import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.UserService;

import javax.xml.ws.RequestWrapper;


@Controller
public class IndexController {
     @Autowired
     UserService userService;





}
