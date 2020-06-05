package com.mycompany.lapr2_interfacegrafica.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentTransactionList {

    private List<PaymentTransaction> m_lstPaymentTransactions = new ArrayList<>();

    public PaymentTransaction newPaymentTransaction(String payTId, Task task, Freelancer free, String endDate, int delay, String workQualityDescription) {
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

    public boolean addPaymentTransaction(PaymentTransaction payT) {
        return m_lstPaymentTransactions.add(payT);
    }

    public boolean paymentTransactionRegister(PaymentTransaction payT) {
        if (this.validatePaymentTransaction(payT)) {
            return addPaymentTransaction(payT);
        }
        return false;
    }
}
