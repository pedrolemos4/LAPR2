package lapr2.pot.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentTransactionList {

    private List<PaymentTransaction> m_lstPaymentTransactions = new ArrayList<PaymentTransaction>();

    public PaymentTransaction newPaymentTransaction(Task task, TaskExecution taskExec, Freelancer free, double payAmount) {
        return new PaymentTransaction(task, taskExec, free, payAmount);
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
