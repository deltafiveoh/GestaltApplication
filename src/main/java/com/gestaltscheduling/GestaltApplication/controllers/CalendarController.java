package com.gestaltscheduling.GestaltApplication.controllers;

import com.gestaltscheduling.GestaltApplication.models.Task;
import com.gestaltscheduling.GestaltApplication.models.data.CrewRepository;
import com.gestaltscheduling.GestaltApplication.models.data.RigRepository;
import com.gestaltscheduling.GestaltApplication.models.data.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("calendar")
public class CalendarController {

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private RigRepository rigRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public CalendarController() {

        columnChoices.put("all", "All");
        columnChoices.put("task","Task");
        columnChoices.put("crew", "Crew");
        columnChoices.put("rig","Rig");
        columnChoices.put("date", "Date");

    }

    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    @RequestMapping(value = "")
    public String calendar(Model model) {
        //hashmaps of total year and current calendar view
        //shows current day of year and equivalent day in the month
        HashMap<Integer, Integer> yearDayToMonthDay = new HashMap<>();
        LinkedHashMap<Integer, Integer> calendarDaysVisible = new LinkedHashMap<>();

        //linkedhashmaps for each week
        LinkedHashMap<Integer, Integer> week1 = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> week2 = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> week3 = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> week4 = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> week5 = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> week1y = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> week2y = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> week3y = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> week4y = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> week5y = new LinkedHashMap<>();

        //get current date and set today's day in the year
        Calendar currentDate = Calendar.getInstance();
        int todayDay = currentDate.get(Calendar.DAY_OF_YEAR);
        int currentDayOfYear = currentDate.get(Calendar.DAY_OF_YEAR);
        int currentMonthOfYear = currentDate.get(Calendar.MONTH);

        //set hashmap of every day of the year and it's associated month day
        for (int x = 1; x <= 365; x++){
            Calendar dayOne = Calendar.getInstance();
            dayOne.set(Calendar.DAY_OF_YEAR, x);
            int dayOfMonth = dayOne.get(Calendar.DAY_OF_MONTH);
            yearDayToMonthDay.put(x, dayOfMonth);
        }

        //set hashmap for visible calendar using full year hashmap from today's date
        for (int y = 0; y < 35; y++){
            int dayToday = todayDay + y;
            calendarDaysVisible.put(dayToday, yearDayToMonthDay.get(dayToday));
        }

        //set hashmaps for each week
        for (int y = 0; y < 7; y++){
            int dayToday = todayDay + y;
            week1.put(dayToday, calendarDaysVisible.get(dayToday));
            week1y.put(dayToday, dayToday);
        }
        for (int y = 7; y < 14; y++){
            int dayToday = todayDay + y;
            week2.put(dayToday, calendarDaysVisible.get(dayToday));
            week2y.put(dayToday, dayToday);
        }
        for (int y = 14; y < 21; y++){
            int dayToday = todayDay + y;
            week3.put(dayToday, calendarDaysVisible.get(dayToday));
            week3y.put(dayToday, dayToday);
        }
        for (int y = 21; y < 28; y++){
            int dayToday = todayDay + y;
            week4.put(dayToday, calendarDaysVisible.get(dayToday));
            week4y.put(dayToday, dayToday);
        }
        for (int y = 28; y < 35; y++){
            int dayToday = todayDay + y;
            week5.put(dayToday, calendarDaysVisible.get(dayToday));
            week5y.put(dayToday, dayToday);
        }

        model.addAttribute("week1dates", week1);
        model.addAttribute("week2dates", week2);
        model.addAttribute("week3dates", week3);
        model.addAttribute("week4dates", week4);
        model.addAttribute("week5dates", week5);
        model.addAttribute("week1dayYear", week1y);
        model.addAttribute("week2dayYear", week2y);
        model.addAttribute("week3dayYear", week3y);
        model.addAttribute("week4dayYear", week4y);
        model.addAttribute("week5dayYear", week5y);
        model.addAttribute("dayTodayValid", currentDayOfYear);
        model.addAttribute("MonthValid", currentMonthOfYear);
        model.addAttribute("tasks", taskRepository.findAll());

        Iterable<Task> tasks = taskRepository.findAll();


        return "calendar";
    }

}