package com.gestaltscheduling.GestaltApplication.controllers;

import com.gestaltscheduling.GestaltApplication.models.Employee;
import com.gestaltscheduling.GestaltApplication.models.data.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("")
    public String displayAllEmployerForm(Model model) {
        model.addAttribute("title", "All Employers");
        model.addAttribute("employers", employeeRepository.findAll());
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute("title", "Add Employers");
        model.addAttribute(new Employee());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employee newEmployer,
                                    Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "employers/add";
        }
        employeeRepository.save(newEmployer);
        return "redirect:../add";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional optEmployer = employeeRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employee employee = (Employee) optEmployer.get();
            model.addAttribute("employer", employee);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }

}
