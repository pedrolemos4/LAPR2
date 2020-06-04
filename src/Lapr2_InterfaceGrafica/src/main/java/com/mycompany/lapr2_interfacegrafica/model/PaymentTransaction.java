package com.mycompany.lapr2_interfacegrafica.model;

public class PaymentTransaction {

    private Task m_oTask;
    private Freelancer m_oFreelancer;
    private String m_strEndDate;
    private int m_Delay;
    private String m_strWorkQualityDescription;
    private double dPayAmount;

    public PaymentTransaction(Task task, Freelancer free, String endDate, int delay, String workQualityDescription) {
        if ((task == null) || (free == null)) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        this.m_oTask = task;
        this.m_oFreelancer = free;
        this.m_strEndDate = endDate;
        this.m_Delay = delay;
        this.m_strWorkQualityDescription = workQualityDescription;
        this.dPayAmount = generatePayAmount(task, free);
    }

    public double getPayAmount() {
        return this.dPayAmount;
    }

    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %s - %s - %.2f", this.m_oTask.toString(), this.m_strEndDate, this.m_Delay, this.m_strWorkQualityDescription, this.m_oFreelancer.toString(), this.dPayAmount);
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
