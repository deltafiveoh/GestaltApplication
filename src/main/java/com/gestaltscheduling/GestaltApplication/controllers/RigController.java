package com.gestaltscheduling.GestaltApplication.controllers;

import com.gestaltscheduling.GestaltApplication.models.Rig;
import com.gestaltscheduling.GestaltApplication.models.data.RigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("rig")
public class RigController {

    @Autowired
    private RigRepository rigRepository;

    @GetMapping("add")
    public String displayAddRigForm(Model model) {
        model.addAttribute(new Rig());
        return "rig/add";
    }

    @PostMapping("add")
    public String processAddRigForm(@ModelAttribute @Valid Rig newRig,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "rig/add";
        }
        rigRepository.save(newRig);
        return "redirect:../taskFiles/addTask";
    }

    @GetMapping("view/{rigId}")
    public String displayViewRig(Model model, @PathVariable int rigId) {

        Optional optRig = rigRepository.findById(rigId);
        if (((Optional<?>) optRig).isPresent()) {
            Rig rig = (Rig) optRig.get();
            model.addAttribute("rig", rig);
            return "rig/view";
        } else {
            return "redirect:../taskFiles/addTask";
        }
    }
}
