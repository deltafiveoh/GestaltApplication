package com.gestaltscheduling.GestaltApplication.models;

import java.util.ArrayList;

public class TaskData {

    public static ArrayList<Task> findByColumnAndValue(String column, String value, Iterable<Task> allTasks) {

        ArrayList<Task> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Task>) allTasks;
        }

        if (column.equals("all")){
            results = findByValue(value, allTasks);
            return results;
        }
        for (Task task : allTasks) {

            String aValue = getFieldValue(task, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(task);
            }
        }

        return results;
    }

    public static String getFieldValue(Task task, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = task.getName();
        } else if (fieldName.equals("rig")){
            theValue = task.getRigs().toString();
        } else if (fieldName.equals("crew")){
            theValue = task.getCrew().toString();
        } else {
            theValue = task.getDateStart().toString();
        }

        return theValue;
    }

    public static ArrayList<Task> findByValue(String value, Iterable<Task> allTasks) {
        String lower_val = value.toLowerCase();

        ArrayList<Task> results = new ArrayList<>();

        for (Task task : allTasks) {

            if (task.getName().toLowerCase().contains(lower_val)) {
                results.add(task);
            } else if (task.getRigs().toString().toLowerCase().contains(lower_val)) {
                results.add(task);
            } else if (task.getCrew().toString().toLowerCase().contains(lower_val)) {
                results.add(task);
            } else if (task.getDateStart().toString().toLowerCase().contains(lower_val)) {
                results.add(task);
            } else if (task.getDateEnd().toString().toLowerCase().contains(lower_val)) {
                results.add(task);
            } else if (task.toString().toLowerCase().contains(lower_val)) {
                results.add(task);
            }

        }

        return results;
    }


}

