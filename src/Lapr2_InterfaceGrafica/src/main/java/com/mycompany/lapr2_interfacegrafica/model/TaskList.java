package com.mycompany.lapr2_interfacegrafica.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskList implements Serializable {

    private List<Task> tasks;
    private Task task;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public Task newTask(String id, String briefDescription, int timeDuration, double costPerHour, String category) {
        this.task = new Task(id, briefDescription, timeDuration, costPerHour, category);
        return this.task;
    }

    public Task getTask() {
        System.out.println("To String: " + this.task.toString());
        return this.task;
    }

    public Task getOtherTask(Task task1){
        if(this.task== task1){
            return this.task;
        }
        return null;
    }
    
    public boolean registerTask(Task task) {
        //if (task!=null) {
        return tasks.add(task);
        //   return true;
        // }
        //   return false;

    }

    public boolean validateTask(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).equals(task)) {
                return false;
            }
        }
        return true;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
//        try {
//            task.validate();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public Task findById(String taskId) {
        for (Task task : tasks) {
            if (task.hasId(taskId)) {
                return task;
            }
        }
        return null;
    }

    public boolean hasTask(String taskId) {
        return findById(taskId) != null;
    }

//    public Task getTaskById(String taskId) {
//        for (Task task : tasks) {
//            if (task.toString().equals(taskId)) {
//                return task;
//            }
//        }
//        throw new IllegalArgumentException("Invalid " + taskId);
//    }
    public Task getTaskByStringValue(String taskString) {
        for (Task task : tasks) {
            if (task.toString().equals(taskString)) {
                return task;
            }
        }
        throw new IllegalArgumentException("Invalid " + taskString);
    }

    public List<Task> getTasks() {
//        if (this.tasks == null) {
//            System.out.println("Lista null (TASK LIST)");
//        }
        return tasks;
    }

    public List<String> getTasksAsStringList() {
        List<String> setTasksAsString = new ArrayList<>();
        for (Task task : tasks) {
            setTasksAsString.add(task.toString());
        }
        if (setTasksAsString == null) {
            System.out.println("LIST NUll (taskList)");
        }
        return setTasksAsString;
    }
}
