package com.mycompany.lapr2_interfacegrafica.model;

public class PaymentTransaction {

    private Task m_oTask;
    private TaskExecution m_oTaskExecution;
    private Freelancer m_oFreelancer;
    private double dPayAmount;

    public PaymentTransaction(Task task, TaskExecution taskExec, Freelancer free, double payAmount) {

        if ((task == null) || (taskExec == null) || (free == null) || (payAmount == 0)) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        this.m_oTask = task;
        this.m_oTaskExecution = taskExec;
        this.m_oFreelancer = free;
        this.dPayAmount = payAmount;
    }

    public double getPayAmount() {
        return this.dPayAmount;
    }

    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %.2f", this.m_oTask.toString(), this.m_oTaskExecution.toString(), this.m_oFreelancer.toString(), this.dPayAmount);
        return str;
    }
}
