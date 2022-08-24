package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class MyController {
    private final UserService userService;

    public MyController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping("/")
    public String showUser(Model model) {
        model.addAttribute("allusers", userService.getAllUsers());
        return "/index";

    }

    @GetMapping("/new")
    public String newUser2(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }
    @PostMapping("/new")
    public String creatUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findById(id));
        return "/update";
    }

    @PatchMapping("update/{id}")
    public String patchUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}





