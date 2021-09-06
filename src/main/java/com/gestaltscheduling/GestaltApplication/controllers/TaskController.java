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
@RequestMapping(value = "tasks")
public class TaskController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RigRepository rigRepository;

    @Autowired
    private DateRepository dateRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public TaskController() {

        columnChoices.put("all", "All");
        columnChoices.put("job","Job");
        columnChoices.put("employee", "Employee");
        columnChoices.put("rig","Rig");
        columnChoices.put("date", "Date");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("title", "List");
        model.addAttribute("job", jobRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("rigs", rigRepository.findAll());
        model.addAttribute("date", dateRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "jobs")
    public String listJobsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Job> jobs;
        if (column.toLowerCase().equals("all")){
            jobs = jobRepository.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            jobs = JobData.findByColumnAndValue(column, value, jobRepository.findAll());
            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("jobs", jobs);

        return "tasklist";
    }
}
