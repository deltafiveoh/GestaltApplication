package com.gestaltscheduling.GestaltApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;

@Controller
@RequestMapping("messages")
public class MessagesController {

    @RequestMapping(value = "")
    public String messages(Model model) {

        HashMap<String, String> userChoices = new HashMap<>();
        userChoices.put("user1", "User 1");
        userChoices.put("user2", "User 2");

        model.addAttribute("users", userChoices);

        return "messages";
    }

}