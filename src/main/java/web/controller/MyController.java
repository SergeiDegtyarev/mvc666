package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.ServiceDao;
import java.util.ArrayList;
import java.util.List;

@Controller
@ComponentScan("web")
@RequestMapping("/")
public class MyController {


    private final ServiceDao serviceDao;

    @Autowired
    public MyController( ServiceDao serviceDao) {
        this.serviceDao = serviceDao;

    }
    @GetMapping("/")
    public String add(Model model) {
        model.addAttribute("name",serviceDao.getAllUsers());
        return "/index";

    }



}
