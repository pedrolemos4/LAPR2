package com.mycompany.lapr2_interfacegrafica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class Organization {

    private String m_strNome;
    private String m_strNIF;
    private Collaborator m_oManager;
    private Collaborator m_oCollaborator;
    private PaymentTransactionList m_oPaymentTransactionList;

    public Organization(String name, String NIF, Collaborator manager, Collaborator collaborator) {
        if ((name == null) || (NIF == null) || (manager == null) || (collaborator == null)
                || (name.isEmpty()) || (NIF.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.m_strNome = name;
        this.m_strNIF = NIF;
        this.m_oManager = manager;
        this.m_oCollaborator = collaborator;

    }

    public Collaborator getManager() {
        return this.m_oManager;
    }

    public Collaborator getCollaborator() {
        return this.m_oCollaborator;
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
        String str = String.format("%s - %s - %s - %s", this.m_strNome, this.m_strNIF, this.m_oManager.toString(), this.m_oCollaborator.toString());
        return str;
    }

    public Collaborator newCollaborator(String name, String email) {
        return new Collaborator(name, email);
    }

    //UC6
    public TreeMap<String, List<Double>> determinatePayOrg(TreeMap<String, List<Double>> mapOrgPayment) {
        List<PaymentTransaction> transactionList = m_oPaymentTransactionList.getPaymentTransactions();
        for (PaymentTransaction transaction : transactionList) {
            Freelancer free = transaction.getM_oFreelancer();
            String freeId = free.getId();
            Task task = transaction.getM_oTask();
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
            Freelancer free = transaction.getM_oFreelancer();
            String freeId = free.getId();
            double transactionAmount = transaction.getM_Delay();
            if (mapOrgDelay.get(freeId) == null) {
                mapOrgDelay.put(freeId, new ArrayList<Double>());
            }
            mapOrgDelay.get(freeId).add(transactionAmount);
        }
        return mapOrgDelay;
    }
    
    public int calcCounterFree(){
        int counter=0;
        List<PaymentTransaction> transactionList = m_oPaymentTransactionList.getPaymentTransactions();
        for (PaymentTransaction transaction : transactionList) {
            Freelancer free = transaction.getM_oFreelancer();
            counter++;
        }
        return counter;
    }
}
