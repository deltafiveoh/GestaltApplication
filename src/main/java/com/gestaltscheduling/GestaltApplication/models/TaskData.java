//package com.gestaltscheduling.GestaltApplication.models;
//
//import java.util.ArrayList;
//
//public class TaskData {
//
//    public static ArrayList<Task> findByColumnAndValue(String column, String value, Iterable<Task> allTasks) {
//
//        ArrayList<Task> results = new ArrayList<>();
//
//        if (value.toLowerCase().equals("all")){
//            return (ArrayList<Task>) allTasks;
//        }
//
//        if (column.equals("all")){
//            results = findByValue(value, allTasks);
//            return results;
//        }
//        for (Task task : allTasks) {
//
//            String aValue = getFieldValue(task, column);
//
//            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
//                results.add(task);
//            }
//        }
//
//        return results;
//    }
//
//    public static String getFieldValue(Task task, String fieldName){
//        String theValue;
//        if (fieldName.equals("name")){
//            theValue = task.getOccupation();
//        } else if (fieldName.equals("employer")){
//            theValue = task.getEmployee().toString();
//        } else {
//            theValue = task.getCrew().toString();
//        }
//
//        return theValue;
//    }
//
//    /**
//     * Search all Job fields for the given term.
//     * @param value The search term to look for.
//     * @param allTasks The list of jobs to search.
//     * @return      List of all jobs with at least one field containing the value.
//     */
//    public static ArrayList<Task> findByValue(String value, Iterable<Task> allTasks) {
//        String lower_val = value.toLowerCase();
//
//        ArrayList<Task> results = new ArrayList<>();
//
//        for (Task task : allTasks) {
//
//            if (task.getOccupation().toLowerCase().contains(lower_val)) {
//                results.add(task);
//            } else if (task.getEmployee().toString().toLowerCase().contains(lower_val)) {
//                results.add(task);
//            } else if (task.getCrew().toString().toLowerCase().contains(lower_val)) {
//                results.add(task);
//            } else if (task.toString().toLowerCase().contains(lower_val)) {
//                results.add(task);
//            }
//
//        }
//
//        return results;
//    }
//
//
//}

