package com.mycompany.lapr2_interfacegrafica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class Organization {

    private String m_strName;
    private String m_strNIF;
    private Manager m_oManager;
    private Collaborator m_oCollaborator;
    private TaskList taskList;
    private PaymentTransactionList m_oPaymentTransactionList;

    public Organization(String name, String NIF, Manager manager, Collaborator collaborator) {
        setName(name);
        setNIF(NIF);
        setManager(manager);
        setCollaborator(collaborator);
    }

    public TaskList getTaskList() {
        return this.taskList;
    }

    public Collaborator newCollaborator(String name, String email) {
        return new Collaborator(name, email);
    }

    public Manager newManager(String name, String email) {
        return new Manager(name, email);
    }

    public Manager getManager() {
        return this.m_oManager;
    }

    public Collaborator getCollaborator() {
        return this.m_oCollaborator;
    }

    public String getOrgName() {
        return this.m_strName;
    }

    public String getOrgNIF() {
        return this.m_strNIF;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Organization Name!");
        }
    }

    public void setNIF(String nif) {
        if (nif == null || nif.trim().length() < 9) {
            throw new IllegalArgumentException("Invalid Organization NIF!");
        }
        this.m_strNIF = nif;
    }

    public void setManager(Manager m) {
        if (m == null) {
            throw new IllegalArgumentException("Invalid Manager!");
        }
        this.m_oManager = m;
    }

    public void setCollaborator(Collaborator c) {
        if (c == null) {
            throw new IllegalArgumentException("Invalid Collaborator!");
        }
        this.m_oCollaborator = c;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.m_strNIF);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        Organization obj = (Organization) o;
        return (Objects.equals(m_strNIF, obj.m_strNIF));
    }

    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %s", this.m_strName, this.m_strNIF, this.m_oManager.toString(), this.m_oCollaborator.toString());
        return str;
    }

    //UC6
    public TreeMap<String, List<Double>> determinatePayOrg(TreeMap<String, List<Double>> mapOrgPayment) {
        List<PaymentTransaction> transactionList = m_oPaymentTransactionList.getPaymentTransactions();
        for (PaymentTransaction transaction : transactionList) {
            Freelancer free = transaction.getFreelancer();
            String freeId = free.getId();
            Task task = transaction.getTask();
            double transactionAmount = transaction.generatePayAmount(task, free);
            if (mapOrgPayment.get(freeId) == null) {
                mapOrgPayment.put(freeId, new ArrayList<Double>());
            }
            mapOrgPayment.get(freeId).add(transactionAmount);
        }
        return mapOrgPayment;
    }

    public TreeMap<String, List<Double>> determinateDelayOrg(TreeMap<String, List<Double>> mapOrgDelay) {
        List<PaymentTransaction> transactionList = m_oPaymentTransactionList.getPaymentTransactions();
        for (PaymentTransaction transaction : transactionList) {
            Freelancer free = transaction.getFreelancer();
            String freeId = free.getId();
            double transactionAmount = transaction.getPayAmount();
            if (mapOrgDelay.get(freeId) == null) {
                mapOrgDelay.put(freeId, new ArrayList<Double>());
            }
            mapOrgDelay.get(freeId).add(transactionAmount);
        }
        return mapOrgDelay;
    }

    public int calcCounterDelays() {
        int counter = 0;
        List<PaymentTransaction> transactionList = m_oPaymentTransactionList.getPaymentTransactions();
        for (PaymentTransaction transaction : transactionList) {
            int t = transaction.getDelay();
            counter++;
        }
        return counter;
    }

    public PaymentTransactionList getPaymentTransactionList() {
        return m_oPaymentTransactionList;
    }
}
