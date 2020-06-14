package com.mycompany.lapr2_interfacegrafica.model;

import java.io.Serializable;
import lapr2.pot.ui.console.utils.Date;

public class PaymentTransaction implements Serializable {

    private Organization org;
    private String id;
    private Task task;
    private Freelancer freelancer;
    private Date endDate;
    private int delay;
    private String workQualityDescription;
    private double dPayAmount;

    public PaymentTransaction(Organization org, String payTId, Task task,
            Freelancer free, Date endDate, int delay, String workQualityDescription) {
        setOrg(org);
        setId(payTId);
        setTask(task);
        setFreelancer(free);
        setEndDate(endDate);
        setDelay(delay);
        setWorkQualityDescription(workQualityDescription);
        this.dPayAmount = generatePayAmount(this.task, this.freelancer);
    }

    public PaymentTransaction(String payTId, Task task,
            Freelancer free, Date endDate, int delay, String workQualityDescription) {
        setId(payTId);
        setTask(task);
        setFreelancer(free);
        setEndDate(endDate);
        setDelay(delay);
        setWorkQualityDescription(workQualityDescription);
        this.dPayAmount = generatePayAmount(this.task, this.freelancer);
    }

    @Override
    public String toString() {
        String str = String.format("ID: %s - %s - End Date: %s - Delay: %d hours - Work Quality Description: %s - %s - Payment Amount: %.2f", this.id, this.task.toString(), this.endDate.toYearMonthDayString(), this.delay, this.workQualityDescription, this.freelancer.toString(), this.dPayAmount);
        return str;
    }

    public double generatePayAmount(Task task, Freelancer free) {
        double payAmount = 0;
        if (free.getLvlExp().equalsIgnoreCase("Junior")) {
            payAmount = task.getTimeDuration() * task.getCostPerHour();
        }
        if (free.getLvlExp().equalsIgnoreCase("Senior")) {
            payAmount = (task.getTimeDuration() * task.getCostPerHour()) * 2;
        }
        return payAmount;
    }

    public Organization getOrg() {
        return this.org;
    }

    public String getId() {
        return this.id;
    }

    public Task getTask() {
        return this.task;
    }

    public Freelancer getFreelancer() {
        return this.freelancer;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public int getDelay() {
        return this.delay;
    }

    public String getWorkQualityDescription() {
        return this.workQualityDescription;
    }

    public double getPayAmount() {
        return this.dPayAmount;
    }

    public void setOrg(Organization org) {
        if (org == null) {
            throw new IllegalArgumentException("Invalid Organization!");
        }
        this.org = org;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Payment Transation ID!");
        }
        this.id = id;
    }

    public void setTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Invalid Task!");
        }
        this.task = task;
    }

    public void setFreelancer(Freelancer free) {
        if (free == null) {
            throw new IllegalArgumentException("Invalid Freelancer!");
        }
        this.freelancer = free;
    }

    public void setEndDate(Date eDate) {
        if (eDate == null || eDate.toString().trim().isEmpty() || eDate.toYearMonthDayString().trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Date!");
        }
        this.endDate = eDate;
    }

    public void setDelay(int delay) {
        try {
            this.delay = delay;
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Invalid delay!");
        }
    }

    public void setWorkQualityDescription(String workQualityDescription) {
        if (workQualityDescription == null || workQualityDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Work Quality Description!");
        }
        this.workQualityDescription = workQualityDescription;
    }

    public double convertPayAmount(PaymentTransaction payT) {
        double payAmount = payT.getPayAmount();
        if (payT.getFreelancer().getCountry().equalsIgnoreCase("USA")) {
            payAmount = payT.getPayAmount() * 1.13;
        }
        if (payT.getFreelancer().getCountry().equalsIgnoreCase("UK")) {
            payAmount = payT.getPayAmount() * 0.90;
        }
        if (payT.getFreelancer().getCountry().equalsIgnoreCase("Brasil")) {
            payAmount = payT.getPayAmount() * 5.68;
        }
        if (payT.getFreelancer().getCountry().equalsIgnoreCase("Japan")) {
            payAmount = payT.getPayAmount() * 120.83;
        }
        if (payT.getFreelancer().getCountry().equalsIgnoreCase("China")) {
            payAmount = payT.getPayAmount() * 7.97;
        }
        return payAmount;
    }
}
