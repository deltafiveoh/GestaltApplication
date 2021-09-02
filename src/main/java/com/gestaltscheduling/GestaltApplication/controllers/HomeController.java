package com.gestaltscheduling.GestaltApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("home")
public class HomeController {

    @RequestMapping(value = "")
    public String index(Model model) {

        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("calendar", "Calendar");
        actionChoices.put("messages", "Messages");
        actionChoices.put("tasks", "Tasks");

        model.addAttribute("actions", actionChoices);

        return "home";
    }

}
