package com.gestaltscheduling.GestaltApplication.controllers;

//import com.gestaltscheduling.GestaltApplication.models.TaskData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "tasks")
public class TaskController {

//    @Autowired
//    private TaskRepository taskRepository;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private RigRepository rigRepository;
//
//    @Autowired
//    private DateRepository dateRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public TaskController() {

        columnChoices.put("all", "All");
        columnChoices.put("task","Task");
//        columnChoices.put("employee", "Employee");
        columnChoices.put("rig","Rig");
        columnChoices.put("date", "Date");
    }

    @RequestMapping("")
    public String list(Model model) {
//        model.addAttribute("title", "List");
//        model.addAttribute("task", taskRepository.findAll());
//        model.addAttribute("employees", employeeRepository.findAll());
//        model.addAttribute("rigs", rigRepository.findAll());
//        model.addAttribute("date", dateRepository.findAll());
        return "tasks";
    }

    @RequestMapping(value = "addTask")
    public String displayAddTaskForm(Model model) {
        return "addTask";
    }

    @RequestMapping(value = "jobs")
    public String listTasksByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
//        Iterable<Task> tasks;
//        if (column.toLowerCase().equals("all")){
//            tasks = taskRepository.findAll();
//            model.addAttribute("title", "All Jobs");
//        } else {
//            tasks = TaskData.findByColumnAndValue(column, value, taskRepository.findAll());
//            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
//        }
//        model.addAttribute("tasks", tasks);

        return "tasklist";
    }
}
