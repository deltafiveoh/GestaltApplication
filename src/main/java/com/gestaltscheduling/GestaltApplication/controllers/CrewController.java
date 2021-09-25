//package com.gestaltscheduling.GestaltApplication.controllers;
//
//import com.gestaltscheduling.GestaltApplication.models.Crew;
//import com.gestaltscheduling.GestaltApplication.models.data.TaskRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("taskFiles")
//public class CrewController {
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    @GetMapping("")
//    public String displayAllTasksForm(Model model) {
//        model.addAttribute("title", "All Tasks");
//        model.addAttribute("tasks", taskRepository.findAll());
//        return "employees/index";
//    }
//
//    @GetMapping("/addTask")
//    public String displayAddEmployeeForm(Model model) {
//        model.addAttribute("title", "Add Employees");
//        model.addAttribute(new Employee());
//        return "addTask";
//    }
//
//    @PostMapping("add")
//    public String processAddEmployeeForm(@ModelAttribute @Valid Crew newEmployee,
//                                    Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            return "employees/add";
//        }
//        taskRepository.save(newEmployee);
//        return "redirect:../add";
//    }
//
//    @GetMapping("view/{employerId}")
//    public String displayViewEmployer(Model model, @PathVariable int employeeId) {
//
//        Optional optEmployee = employeeRepository.findById(employeeId);
//        if (optEmployee.isPresent()) {
//            Employee employee = (Employee) optEmployee.get();
//            model.addAttribute("employee", employee);
//            return "employees/view";
//        } else {
//            return "redirect:../";
//        }
//    }
//
//}
