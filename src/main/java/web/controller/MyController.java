package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.ServiceDao;

@Controller
public class MyController {
    private final ServiceDao serviceDao;

    public MyController( ServiceDao serviceDao) {
        this.serviceDao = serviceDao;

    }
    @GetMapping("/")
    public String showUser(Model model) {
        model.addAttribute("allusers",serviceDao.getAllUsers());
        return "/index";

    }

    @GetMapping("/new")
    public String newUser2 (Model model){
        model.addAttribute("user",new User());
        return "/new";
    }
    @PostMapping("/new")
    public String creatUser (@ModelAttribute("user") User user){
        serviceDao.addUser(user);
        return "redirect:/";
    }

@GetMapping("/update/{id}")
public String updateUser (Model model, @PathVariable("id") int id){
        model.addAttribute("user", serviceDao.findById(id));
        return "/update";
}

@PatchMapping("update/{id}")
public String patchUser (@ModelAttribute("user") User user){
        serviceDao.updateUser(user);
        return "redirect:/";

}


    @DeleteMapping ("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        serviceDao.deleteUser(id);
        return "redirect:/";
    }

}





