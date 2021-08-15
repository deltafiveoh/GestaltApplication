package com.gestaltscheduling.GestaltApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Calendar;
import java.util.HashMap;

@Controller
@RequestMapping("calendar")
public class CalendarController {

    @RequestMapping(value = "")
    public String calendar(Model model) {
        HashMap<Integer, Integer> yearToMonthDay = new HashMap<>();

        for (int x = 1; x <= 365; x++){
            Calendar dayOfYear = Calendar.getInstance();
            dayOfYear.set(Calendar.DAY_OF_YEAR, x);
            int dayOfMonth = dayOfYear.get(Calendar.DAY_OF_MONTH);
            yearToMonthDay.put(x, dayOfMonth);
        }

        Calendar currentDate = Calendar.getInstance();

        int todayDay = currentDate.get(Calendar.DAY_OF_YEAR);

        model.addAttribute(todayDay);
        model.addAttribute("dates", yearToMonthDay);

        return "calendar";
    }

}