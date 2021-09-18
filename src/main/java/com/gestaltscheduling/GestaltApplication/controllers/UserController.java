package com.gestaltscheduling.GestaltApplication.controllers;

import com.gestaltscheduling.GestaltApplication.models.User;
import com.gestaltscheduling.GestaltApplication.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/functionalLogin";
    }

    @GetMapping("/user/add")
    public String displayAddUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        
        return "user/add";
    }

    @RequestMapping(value = "login")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if (user.getPassword().equals(verify)) {
           return "home";
        }
        else {
            model.addAttribute("error", "Passwords do not match");
            return "user/functionalLogin";
        }

    }

}
