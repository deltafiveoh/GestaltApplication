package com.gestaltscheduling.GestaltApplication.controllers;

import com.gestaltscheduling.GestaltApplication.models.TaskData;
import com.gestaltscheduling.GestaltApplication.models.DatesSelected;
import com.gestaltscheduling.GestaltApplication.models.Task;
import com.gestaltscheduling.GestaltApplication.models.data.CrewRepository;
import com.gestaltscheduling.GestaltApplication.models.data.DatesSelectedRepository;
import com.gestaltscheduling.GestaltApplication.models.data.RigRepository;
import com.gestaltscheduling.GestaltApplication.models.data.TaskRepository;
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
    private TaskRepository taskRepository;

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private RigRepository rigRepository;

    @Autowired
    private DatesSelectedRepository dateRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public TaskController() {

        columnChoices.put("all", "All");
        columnChoices.put("task","Task");
        columnChoices.put("crew", "Crew");
        columnChoices.put("rig","Rig");
        columnChoices.put("date", "Date");

    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("title", "Tasks");
        model.addAttribute("task", taskRepository.findAll());
        model.addAttribute("crew", crewRepository.findAll());
        model.addAttribute("rigs", rigRepository.findAll());
        model.addAttribute("date", dateRepository.findAll());
        return "tasks";
    }

    @RequestMapping(value = "addTask")
    public String displayAddTaskForm(Model model) {
        return "addTask";
    }

    @RequestMapping(value = "jobs")
    public String listTasksByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Task> tasks;
        if (column.toLowerCase().equals("all")){
            tasks = taskRepository.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            tasks = TaskData.findByColumnAndValue(column, value, taskRepository.findAll());
            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("tasks", tasks);

        return "tasklist";
    }
}
