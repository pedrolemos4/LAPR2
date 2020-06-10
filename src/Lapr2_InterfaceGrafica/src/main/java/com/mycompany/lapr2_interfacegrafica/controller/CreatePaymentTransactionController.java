package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.TaskList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransactionList;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import com.mycompany.lapr2_interfacegrafica.model.Task;
import java.util.List;
import lapr2.pot.ui.console.utils.Date;
import lapr2.pot.ui.console.utils.Utils;

public class CreatePaymentTransactionController {

    private POTApplication m_oApp;
    private UserSession m_oSessao;
    private Platform plat;
    private Organization org;
    private PaymentTransactionList ptL;
    private PaymentTransaction payT;
    private Date date;

    public CreatePaymentTransactionController() {
        // this.m_oApp = POTApplication.getInstance();
        this.m_oSessao = m_oApp.getCurrentSession();
    }

    public PaymentTransaction newPaymentTransaction(String payTId, String taskString, String eDate, int delay, String workQualityDescription, String freelancerString) {
        String email = m_oSessao.getUserEmail();
        OrganizationsRecord orgR = plat.getOrganizationsRecord();
        this.org = orgR.getOrganizationByUserEmail(email);
        TaskList tLst = org.getTaskList();
        Task task = tLst.getTaskByStringValue(taskString);
        FreelancersRecord frlR = plat.getFreelancersRecord();
        Freelancer free = frlR.getFreelancerByStringValue(freelancerString);
        Date endDate = date.convertStringToDate(eDate);
        this.ptL = org.getPaymentTransactionList();
        this.payT = ptL.newPaymentTransaction(payTId, task, free, endDate, delay, workQualityDescription);
        if (this.ptL.validatePaymentTransaction(this.payT)) {
            return this.payT;
        }
        return null;
    }

    public boolean paymentTransactionRegister() {
        return this.ptL.paymentTransactionRegister(this.payT);
    }

    public String getPaymentTransactionToString() {
        return this.payT.toString();
    }

    public List<String> getTasks() {
        return this.org.getTaskList().getTasksAsStringList();
    }

    public List<String> getFreelancers() {
        return this.plat.getFreelancersRecord().getFreelancersAsStringList();
    }

    public String getTask() {
        return this.payT.getTask().toString();
    }

    public String getFreelancer() {
        return this.payT.getFreelancer().toString();
    }

    public String getTaskDelay() {
        int delay = this.payT.getDelay();
        return String.valueOf(delay);
    }

    public String getEndDate() {
        return this.payT.getEndDate().toString();
    }

    public String getWorkDescription() {
        return this.payT.getWorkQualityDescription();
    }

    public String getPayTId() {
        return this.payT.getId();
    }

}
