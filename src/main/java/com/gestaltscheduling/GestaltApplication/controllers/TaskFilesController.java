package com.gestaltscheduling.GestaltApplication.controllers;

import com.gestaltscheduling.GestaltApplication.models.Job;
import com.gestaltscheduling.GestaltApplication.models.JobData;
import com.gestaltscheduling.GestaltApplication.models.data.DateRepository;
import com.gestaltscheduling.GestaltApplication.models.data.EmployeeRepository;
import com.gestaltscheduling.GestaltApplication.models.data.JobRepository;
import com.gestaltscheduling.GestaltApplication.models.data.RigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "taskFiles")
public class TaskFilesController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RigRepository rigRepository;

    @Autowired
    private DateRepository dateRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public TaskFilesController() {

        columnChoices.put("all", "All");
        columnChoices.put("job","Job");
        columnChoices.put("employee", "Employee");
        columnChoices.put("rig","Rig");
        columnChoices.put("date", "Date");
    }

    @RequestMapping("")
    public String list(Model model) {
        return "tasks";
    }

    @RequestMapping(value = "add")
    public String displayAddTaskForm(Model model) {
        return "taskFiles/addTask";
    }

}
