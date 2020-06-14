package com.mycompany.lapr2_interfacegrafica.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr2.pot.ui.console.utils.Date;

public class PaymentTransactionList implements Serializable {

    private List<PaymentTransaction> m_lstPaymentTransactions;

    public PaymentTransactionList() {
        this.m_lstPaymentTransactions = new ArrayList<>();
    }

    public PaymentTransaction newPaymentTransaction1(String payTId,
            Task task, Freelancer free, Date endDate, int delay, String workQualityDescription) {
        if (this.exists(payTId)) {
            throw new IllegalArgumentException("There is already a transaction with the same ID as the one entered!");
        }
        return new PaymentTransaction(payTId, task, free, endDate, delay, workQualityDescription);
    }

    public PaymentTransaction newPaymentTransaction(Organization org, String payTId,
            Task task, Freelancer free, Date endDate, int delay, String workQualityDescription) {
        if (this.exists(payTId)) {
            throw new IllegalArgumentException("There is already a transaction with the same ID as the one entered!");
        }
        if (task == null) {
            throw new IllegalArgumentException("A task has not been selected");
        }
        if (free == null) {
            throw new IllegalArgumentException("A freelancer has not been selected");
        }
        return new PaymentTransaction(org, payTId, task, free, endDate, delay, workQualityDescription);
    }

    public boolean validatePaymentTransaction(PaymentTransaction payT) {
        for (int i = 0; i < m_lstPaymentTransactions.size(); i++) {
            if (m_lstPaymentTransactions.get(i).equals(payT)) {
                return false;
            }
        }
        return true;
    }

    public List<PaymentTransaction> getPaymentTransactions() {
        return this.m_lstPaymentTransactions;
    }

    public boolean addPaymentTransaction(PaymentTransaction payT) {
        return m_lstPaymentTransactions.add(payT);
    }

    public boolean paymentTransactionRegister(PaymentTransaction payT) {
        return addPaymentTransaction(payT);
    }

    public boolean exists(String transactionId) {
        for (int i = 0; i < m_lstPaymentTransactions.size(); i++) {
            if (m_lstPaymentTransactions.get(i).getId().equalsIgnoreCase(transactionId)) {
                return true;
            }
        }
        return false;
    }

    public PaymentTransaction getPaymentTransactionById(String paymentTransactionId) {
        for (PaymentTransaction paymentTransaction : m_lstPaymentTransactions) {
            if (paymentTransaction.toString().equals(paymentTransactionId)) {
                return paymentTransaction;
            }
        }
        throw new IllegalArgumentException("Invalid " + paymentTransactionId);
    }

    public PaymentTransaction getPaymentTransactionByStringValue(String paymentTransactionString) {
        for (PaymentTransaction paymentTransaction : m_lstPaymentTransactions) {
            if (paymentTransaction.toString().equals(paymentTransactionString)) {
                return paymentTransaction;
            }
        }
        throw new IllegalArgumentException("Invalid " + paymentTransactionString);
    }
}
