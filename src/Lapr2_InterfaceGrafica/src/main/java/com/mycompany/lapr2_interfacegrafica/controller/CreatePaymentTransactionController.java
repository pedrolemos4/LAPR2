package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.authorization.model.User;
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
//        PaymentTransaction payT1 = payTL.newPaymentTransaction(org, payTId, taskString, freelancerString,
//                endDate, delay, workQualityDescription);
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
        System.out.println("Existe email" + email);
        OrganizationsRecord orgRec1 = plat.getOrganizationsRecord();
        System.out.println("Existe org record" + orgRec1.getClass().getSimpleName());
        Organization org1 = orgRec1.getOrganizationByUserEmail(email);
        System.out.println("Existe org" + org.toString());
        List<Task> taskList1 = org1.getTaskList().getTasks();
        System.out.println("taskList: " + taskList1);
        return taskList1;
    }

    public List<Freelancer> getFreelancers() {
        this.regFreel = this.plat.getFreelancersRecord();
        if (this.regFreel == null) {
            System.out.println("O regFreel(controller) tá null");
        }
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
