package com.gestaltscheduling.GestaltApplication.controllers;

import com.gestaltscheduling.GestaltApplication.models.LoginDTO;
import com.gestaltscheduling.GestaltApplication.models.RegisterDTO;
import com.gestaltscheduling.GestaltApplication.models.User;
import com.gestaltscheduling.GestaltApplication.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getID());
    }

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute(new LoginDTO());
        model.addAttribute("title", "Log In");
        return "user/functionalLogin";
    }

    @PostMapping(value = "")
    public String processLoginForm(@ModelAttribute @Valid LoginDTO loginDTO,
                                   Errors errors, HttpServletRequest request,
                                   Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Log In");
//            return "redirect:/user/add";
//        }

        User theUser = userRepository.findByUsername(loginDTO.getUsername());

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            model.addAttribute("title", "Log In");
            return "user/functionalLogin";
        }

        String password = loginDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log In");
            return "user/functionalLogin";
        }
        System.out.println(theUser.isMatchingPassword(password));
        setUserInSession(request.getSession(), theUser);

        return "redirect:/home";
    }

    @GetMapping("/user/add")
    public String displayAddUser(Model model) {
        model.addAttribute(new RegisterDTO());
        model.addAttribute("title", "Register");
        return "/user/add";
    }

    @PostMapping("/user/add")
    public String processAddUser(@ModelAttribute @Valid RegisterDTO registerDTO,
                                     Errors errors, HttpServletRequest request,
                                     Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "/user/add";
        }

        User existingUser = userRepository.findByUsername(registerDTO.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "/user/add";
        }

        String password = registerDTO.getPassword();
        String verifyPassword = registerDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "/user/add";
        }

        User newUser = new User(registerDTO.getUsername(), registerDTO.getEmail(), registerDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:../";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:../";
    }

}
