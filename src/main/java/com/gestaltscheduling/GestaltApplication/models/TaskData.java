package com.gestaltscheduling.GestaltApplication.models;

import java.util.ArrayList;

public class TaskData {

    /**
     * Returns the results of searching the Jobs data by field and search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Job field that should be searched.
     * @param value Value of the field to search for.
     * @param allTasks The list of jobs to search.
     * @return List of all jobs matching the criteria.
     */

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
            theValue = task.getRig().toString();
        } else if (fieldName.equals("crew")){
            theValue = task.getCrew().toString();
        } else {
            theValue = task.getDates().toString();
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     * @param value The search term to look for.
     * @param allTasks The list of jobs to search.
     * @return List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Task> findByValue(String value, Iterable<Task> allTasks) {
        String lower_val = value.toLowerCase();

        ArrayList<Task> results = new ArrayList<>();

        for (Task task : allTasks) {

            if (task.getName().toLowerCase().contains(lower_val)) {
                results.add(task);
            } else if (task.getRig().toString().toLowerCase().contains(lower_val)) {
                results.add(task);
            } else if (task.getCrew().toString().toLowerCase().contains(lower_val)) {
                results.add(task);
            } else if (task.getDates().toString().toLowerCase().contains(lower_val)) {
                results.add(task);
            } else if (task.toString().toLowerCase().contains(lower_val)) {
                results.add(task);
            }

        }

        return results;
    }


}

