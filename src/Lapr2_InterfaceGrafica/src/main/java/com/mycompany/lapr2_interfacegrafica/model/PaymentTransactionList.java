package com.mycompany.lapr2_interfacegrafica.model;

import java.util.ArrayList;
import java.util.List;
import lapr2.pot.ui.console.utils.Date;

public class PaymentTransactionList {

    private List<PaymentTransaction> m_lstPaymentTransactions;

    public PaymentTransactionList() {
        this.m_lstPaymentTransactions = new ArrayList<>();
    }

    public PaymentTransaction newPaymentTransaction(String payTId, Task task, Freelancer free, Date endDate, int delay, String workQualityDescription) {
        return new PaymentTransaction(payTId, task, free, endDate, delay, workQualityDescription);
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
        if (this.validatePaymentTransaction(payT)) {
            return addPaymentTransaction(payT);
        }
        return false;
    }
    
    public boolean exists(String transactionId){
        for(int i = 0; i< m_lstPaymentTransactions.size(); i++){
            if(m_lstPaymentTransactions.get(i).getM_strId().equalsIgnoreCase(transactionId)){
                return true;
            }
        }
        return false;
    }
}
