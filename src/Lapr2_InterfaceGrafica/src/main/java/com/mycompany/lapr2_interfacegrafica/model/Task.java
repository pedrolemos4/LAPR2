package com.mycompany.lapr2_interfacegrafica.model;

import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable {
     private String id; 
     private String briefDescription; 
     private int timeDuration; 
     private double costPerHour;
     private String category;

    public Task(String id, String briefDescription, int timeDuration, double costPerHour, String category)  throws IllegalArgumentException {
        this.id = id;
        this.briefDescription = briefDescription;
        this.timeDuration = timeDuration;
        this.costPerHour = costPerHour;
        this.category = category;
        
      //  validate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public int getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(int timeDuration) {
        this.timeDuration = timeDuration;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", briefDescription=" + briefDescription + ", timeDuration=" + timeDuration + ", costPerHour=" + costPerHour + ", category=" + category + '}';
    }

    public void validate() throws IllegalArgumentException{
        //TODO validade fields
    }

    public boolean hasId(String taskId) {
        return taskId.equals(this.id); 
    }
     
     
}
