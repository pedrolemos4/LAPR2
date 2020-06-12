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

    public CreatePaymentTransactionController() {
        this.plat = POTApplication.getPlatform();
        this.facade = new FacadeAuthorization();
        this.orgRec = this.plat.getOrganizationsRecord();
        this.ptL = new PaymentTransactionList();
        this.regFreel = this.plat.getFreelancersRecord();
        this.m_oSessao = new UserSession(POTApplication.getFacadeAuthorization().getCurrentSession().getUser());
    }

    public PaymentTransaction newPaymentTransaction(String payTId, String taskString,
            String eDate, int delay, String workQualityDescription, Freelancer freelancerString) {
        String email = m_oSessao.getUserEmail();
        OrganizationsRecord orgR = plat.getOrganizationsRecord();
        this.org = orgR.getOrganizationByUserEmail(email);
        TaskList tLst = org.getTaskList();
        Task task = tLst.getTaskByStringValue(taskString);
//        FreelancersRecord frlR = plat.getFreelancersRecord();
//        Freelancer free = frlR.getFreelancerByStringValue(freelancerString);
        Date endDate = date.convertStringToDate(eDate);
        this.ptL = org.getPaymentTransactionList();
        this.payT = ptL.newPaymentTransaction(org, payTId, task, freelancerString,
                endDate, delay, workQualityDescription);
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
       // UserSession session = facade.getCurrentSession();
        User user = this.m_oSessao.getUser();
        String email = user.getEmail();
        OrganizationsRecord orgRec = this.plat.getOrganizationsRecord();
        this.org = orgRec.getOrganizationByUserEmail(email);
        TaskList taskList = this.org.getTaskList();
        return taskList.getTasksAsStringList();//.getTasks();
                //this.org.getTaskList().getTasks();
    }

    public List<Freelancer> getFreelancers() {
        this.regFreel = this.plat.getFreelancersRecord();
        if(this.regFreel==null){
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
