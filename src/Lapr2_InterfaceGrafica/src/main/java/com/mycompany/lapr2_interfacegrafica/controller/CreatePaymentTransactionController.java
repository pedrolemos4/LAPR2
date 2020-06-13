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
        this.facade = POTApplication.getFacadeAuthorization();//new FacadeAuthorization();
        this.orgRec = this.plat.getOrganizationsRecord();
        this.org = this.orgRec.getOrganization();
        this.ptL = new PaymentTransactionList();
        this.regFreel = this.plat.getFreelancersRecord();
        this.taskList = this.org.getTaskList();
        this.date = new Date();
        // this.m_oSessao = new UserSession(POTApplic

    }

    public PaymentTransaction newPaymentTransaction(String payTId, Task taskString,
            String eDate, int delay, String workQualityDescription, Freelancer freelancerString) {
        String email = facade.getCurrentSession().getUser().getEmail();
        Organization m_Organization = this.orgRec.getOrganizationByUserEmail(email);
        PaymentTransactionList payTL = m_Organization.getPaymentTransactionList();
        FreelancersRecord frR = plat.getFreelancersRecord();
        TaskList taskL = m_Organization.getTaskList();
        OrganizationsRecord orgR = plat.getOrganizationsRecord();
        this.org = orgR.getOrganizationByUserEmail(email);
//        TaskList tLst = org.getTaskList();
//        Task task = tLst.getTaskByStringValue(taskString);
        System.out.println("Será que escreve a data?!" + eDate);
        Date endDate = date.convertStringToDate(eDate);
        System.out.println("Data: " + endDate.toString());
        // this.ptL = org.getPaymentTransactionList();
        PaymentTransaction payT1 = payTL.newPaymentTransaction(org, payTId, taskString, freelancerString,
                endDate, delay, workQualityDescription);
        this.payT = payT1;
        //this.payT = payTL.newPaymentTransaction(org, payTId, taskString, freelancerString,
        //endDate, delay, workQualityDescription);
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
        //UserSession session = facade.getCurrentSession();
        //User user = this.m_oSessao.getUser();
//        System.out.println("User no getTask(): " + user);
        String email = facade.getCurrentSession().getUser().getEmail();//user.getEmail();
        System.out.println("Existe email" + email);
//        System.out.println("Email do user: "+email);
        OrganizationsRecord orgRec1 = plat.getOrganizationsRecord();
        System.out.println("Existe org record" + orgRec1.getClass().getSimpleName());
//        System.out.println("OrgRec no getTask: " + this.orgRec);
        Organization org1 = orgRec1.getOrganizationByUserEmail(email);
        System.out.println("Existe org" + org.toString());
//        System.out.println("this.org: "+org1);
        List<Task> taskList1 = org1.getTaskList().getTasks();
        System.out.println("taskList: " + taskList1);
        return taskList1;
    }

    public List<Freelancer> getFreelancers() {
        this.regFreel = this.plat.getFreelancersRecord();
        if (this.regFreel == null) {
            System.out.println("O regFreel(controller) tá null");
        }

        //return this.plat.getFreelancersRecord().getListFreelancers();
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
