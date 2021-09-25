package com.gestaltscheduling.GestaltApplication.controllers;

import com.gestaltscheduling.GestaltApplication.models.Crew;
import com.gestaltscheduling.GestaltApplication.models.Rig;
import com.gestaltscheduling.GestaltApplication.models.data.CrewRepository;
import com.gestaltscheduling.GestaltApplication.models.data.RigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("crew")
public class CrewController {

    @Autowired
    private CrewRepository crewRepository;

    @GetMapping("add")
    public String displayAddCrewForm(Model model) {
        model.addAttribute(new Crew());
        return "crew/add";
    }

    @PostMapping("add")
    public String processAddCrewForm(@ModelAttribute @Valid Crew newCrew,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "crew/add";
        }
        crewRepository.save(newCrew);
        return "redirect:../taskFiles/addTask";
    }

    @GetMapping("view/{crewId}")
    public String displayViewCrew(Model model, @PathVariable int crewId) {

        Optional optCrew = crewRepository.findById(crewId);
        if (((Optional<?>) optCrew).isPresent()) {
            Crew crew = (Crew) optCrew.get();
            model.addAttribute("crew", crew);
            return "crew/view";
        } else {
            return "redirect:../";
        }
    }
}
