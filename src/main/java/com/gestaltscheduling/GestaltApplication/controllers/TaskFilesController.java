package com.gestaltscheduling.GestaltApplication.controllers;

import com.gestaltscheduling.GestaltApplication.models.*;
import com.gestaltscheduling.GestaltApplication.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "taskFiles")
public class TaskFilesController<DateRepository> {

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private RigRepository rigRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public TaskFilesController() {

        columnChoices.put("all", "All");
        columnChoices.put("task","Task");
        columnChoices.put("crew", "Crew");
        columnChoices.put("rig","Rig");
        columnChoices.put("date", "Date");

    }

    @GetMapping("addTask")
    public String displayAddTaskForm(Model model) {
        model.addAttribute("title", "Add Task");
        model.addAttribute("crew", crewRepository.findAll());
        model.addAttribute("rigs", rigRepository.findAll());
        model.addAttribute(new Task());
        return "taskFiles/addTask";
    }

    @PostMapping("addTask")
    public String processAddTaskForm(@ModelAttribute @Valid Task newTask,
                                     Errors errors, Model model, @RequestParam List<Integer> rigs,
                                     @RequestParam List<Integer> crew) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Task");
            return "taskFiles/addTask";
        }
        List<Rig> rigsObj = (List<Rig>) rigRepository.findAllById(rigs);
        newTask.setRigs(rigsObj);
        List<Crew> crewObj = (List<Crew>) crewRepository.findAllById(crew);
        newTask.setCrew(crewObj);
        taskRepository.save(newTask);
        return "redirect:/tasks";
    }

    @GetMapping("view/{taskId}")
    public String displayViewTask(Model model, @PathVariable int taskId) {

        Optional optTask = taskRepository.findById(taskId);
        if (optTask.isPresent()) {
            Task task = (Task) optTask.get();
            model.addAttribute("task", task);
            return "/taskFiles/view";
        }else {
            return "redirect:/tasks" ;
        }
    }
}
