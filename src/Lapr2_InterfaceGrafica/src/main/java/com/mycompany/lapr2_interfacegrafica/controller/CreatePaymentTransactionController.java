package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.TaskRecord;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransactionList;
import com.mycompany.lapr2_interfacegrafica.model.Task;
import lapr2.pot.ui.console.utils.Date;
import lapr2.pot.ui.console.utils.Utils;

public class CreatePaymentTransactionController {

    private POTApplication m_oApp;
    private UserSession m_oSessao;
    private OrganizationsRecord or;
    private TaskRecord tLst;
    private FreelancersRecord frlR;
    private PaymentTransactionList ptL;
    private PaymentTransaction payT;

    public CreatePaymentTransactionController() {
        this.m_oApp = POTApplication.getInstance();
        this.m_oSessao = m_oApp.getSessaoAtual();
    }

    public boolean newPaymentTransaction(String payTId, String taskId, String briefDescription, int timeDuration, double costPerHour, String taskCategory, Date endDate, int delay, String workQualityDescription, String frlId, String name, String expertiseLevel, String email, String NIF, String IBAN, String address, String country) {
        try {
            String emailC = m_oSessao.getUserEmail();
            Organization org = or.getOrganizationByUserEmail(emailC);
            Task task = tLst.findById(taskId);
            Freelancer free = frlR.getFreelancerById(frlId);
            this.payT = this.ptL.newPaymentTransaction(payTId, task, free, endDate, delay, workQualityDescription);
            return this.ptL.validatePaymentTransaction(this.payT);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.payT = null;
            return false;
        }
    }

    public boolean paymentTransactionRegister() {
        return this.ptL.paymentTransactionRegister(this.payT);
    }
}
