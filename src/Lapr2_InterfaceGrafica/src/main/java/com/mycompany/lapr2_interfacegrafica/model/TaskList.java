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
        return this.task;
    }

    public Task getOtherTask(Task task1){
        if(this.task== task1){
            return this.task;
        }
        return null;
    }
    
    public boolean registerTask(Task task) {
        return tasks.add(task);
    }

    public boolean validateTask(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).equals(task)) {
                return false;
            }
        }
        return true;
    }

    public Task findById(String taskId) {
        for (Task task : tasks) {
            if (task.hasId(taskId)) {
                return task;
            }
        }
        return null;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
