//package com.gestaltscheduling.GestaltApplication.controllers;
//
//import com.gestaltscheduling.GestaltApplication.models.Crew;
//import com.gestaltscheduling.GestaltApplication.models.Employee;
//import com.gestaltscheduling.GestaltApplication.models.data.EmployeeRepository;
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
//@RequestMapping("employees")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @GetMapping("")
//    public String displayAllEmployeeForm(Model model) {
//        model.addAttribute("title", "All Employees");
//        model.addAttribute("employees", employeeRepository.findAll());
//        return "employees/index";
//    }
//
//    @GetMapping("add")
//    public String displayAddEmployeeForm(Model model) {
//        model.addAttribute("title", "Add Employees");
//        model.addAttribute(new Employee());
//        return "employees/add";
//    }
//
//    @PostMapping("add")
//    public String processAddEmployeeForm(@ModelAttribute @Valid Crew newEmployee,
//                                    Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            return "employees/add";
//        }
//        employeeRepository.save(newEmployee);
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
