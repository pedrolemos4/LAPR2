package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.model.TaskList;
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

public class CreatePaymentTransactionController {

    private POTApplication m_oApp;
    private UserSession m_oSessao;
    private Platform plat;
    private Organization org;
    private PaymentTransactionList ptL;
    private PaymentTransaction payT;
    private Date date;
    private FacadeAuthorization facade;
    private FreelancersRecord regFreel;
    private OrganizationsRecord orgRec;
    private TaskList taskList;

    public CreatePaymentTransactionController() {
        this.plat = POTApplication.getPlatform();
        this.facade = POTApplication.getFacadeAuthorization();
        this.orgRec = this.plat.getOrganizationsRecord();
        this.org = this.orgRec.getOrganization();
        this.ptL = new PaymentTransactionList();
        this.regFreel = this.plat.getFreelancersRecord();
        this.taskList = this.org.getTaskList();
        this.date = new Date();
    }

    public PaymentTransaction newPaymentTransaction(String payTId, Task task,
            String eDate, int delay, String workQualityDescription, Freelancer freelancer) {
        String email = facade.getCurrentSession().getUser().getEmail();
        Organization m_Organization = this.orgRec.getOrganizationByUserEmail(email);
        PaymentTransactionList payTL = m_Organization.getPaymentTransactionList();
        OrganizationsRecord orgR = plat.getOrganizationsRecord();
        this.org = orgR.getOrganizationByUserEmail(email);
        Date endDate = date.convertStringToDate(eDate);
        this.payT = payTL.newPaymentTransaction(org, payTId, task, freelancer,
                endDate, delay, workQualityDescription);
        if (payTL.validatePaymentTransaction(this.payT)) {
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

    public List<Task> getTasks() {
        String email = facade.getCurrentSession().getUser().getEmail();
        OrganizationsRecord orgRec1 = plat.getOrganizationsRecord();
        Organization org1 = orgRec1.getOrganizationByUserEmail(email);
        List<Task> taskList1 = org1.getTaskList().getTasks();
        return taskList1;
    }

    public List<Freelancer> getFreelancers() {
        this.regFreel = this.plat.getFreelancersRecord();
        return this.regFreel.getListFreelancers();
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
