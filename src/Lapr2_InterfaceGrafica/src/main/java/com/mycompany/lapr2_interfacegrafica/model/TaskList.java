package com.mycompany.lapr2_interfacegrafica.model;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public Task newTask(String id, String briefDescription, int timeDuration, double costPerHour, String category) {
        return new Task(id, briefDescription, timeDuration, costPerHour, category);
    }

    public boolean registerTask(Task task) {
        if (validateTask(task)) {
            tasks.add(task);
            return true;
        } else {
            return false;
        }
    }

    public boolean validateTask(Task task) {
        try {
            task.validate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

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

    public Task getTaskById(String taskId) {
        for (Task task : tasks) {
            if (task.toString().equals(taskId)) {
                return task;
            }
        }
        throw new IllegalArgumentException("Invalid " + taskId);
    }

    public Task getTaskByStringValue(String taskString) {
        for (Task task : tasks) {
            if (task.toString().equals(taskString)) {
                return task;
            }
        }
        throw new IllegalArgumentException("Invalid " + taskString);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public List<String> getTasksAsStringList() {
        List<String> setTasksAsString = new ArrayList<>();
        for (Task task : tasks) {
            setTasksAsString.add(task.toString());
        }
        return setTasksAsString;
    }
}
