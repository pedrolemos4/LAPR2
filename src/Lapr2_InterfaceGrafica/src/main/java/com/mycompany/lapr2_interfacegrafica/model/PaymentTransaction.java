package com.mycompany.lapr2_interfacegrafica.model;

public class PaymentTransaction {

    private Task m_oTask;
    private TaskExecution m_oTaskExecution;
    private Freelancer m_oFreelancer;
    private double dPayAmount;

    public PaymentTransaction(Task task, TaskExecution taskExec, Freelancer free) {
        if ((task == null) || (taskExec == null) || (free == null)) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        this.m_oTask = task;
        this.m_oTaskExecution = taskExec;
        this.m_oFreelancer = free;
        this.dPayAmount = generatePayAmount(task, free);
    }

    public double getPayAmount() {
        return this.dPayAmount;
    }

    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %.2f", this.m_oTask.toString(), this.m_oTaskExecution.toString(), this.m_oFreelancer.toString(), this.dPayAmount);
        return str;
    }

    private double generatePayAmount(Task task, Freelancer free) {
        double payAmount = 0;
        if (free.getLvlExp().equalsIgnoreCase("Junior")) {
            //payAmount = task.getDuration() * task.getCostPerHour();
        }
        if (free.getLvlExp().equalsIgnoreCase("Senior")) {
            //payAmount = (task.getDuration() * task.getCostPerHour()) * 2;
        }
        return payAmount;
    }
}
