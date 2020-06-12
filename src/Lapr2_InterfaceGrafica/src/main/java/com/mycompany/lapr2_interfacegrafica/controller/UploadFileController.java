package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.authorization.model.User;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.model.CsvReader;
import com.mycompany.lapr2_interfacegrafica.model.FileReader;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransactionList;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import com.mycompany.lapr2_interfacegrafica.model.TaskList;
import com.mycompany.lapr2_interfacegrafica.model.TxtReader;
import java.io.File;
import java.util.List;

/**
 *
 * @author beatr
 */
public class UploadFileController {
    private OrganizationsRecord orgRec;
    private Platform m_Platform;
    private FacadeAuthorization facade;
    
    
    public UploadFileController() {
        this.m_Platform = POTApplication.getPlatform();
        this.facade = POTApplication.getFacadeAuthorization();
        this.orgRec = m_Platform.getOrganizationsRecord();
    }
    
    public void getFileCsv(File nameFile){
        String email = facade.getCurrentSession().getUser().getEmail();
        Organization m_Organization = this.orgRec.getOrganizationByUserEmail(email);
        PaymentTransactionList paymentTransactionList = m_Organization.getPaymentTransactionList();
        FreelancersRecord freelancerRecord = m_Platform.getFreelancersRecord();
        TaskList taskList = m_Organization.getTaskList();
        FileReader type1 = new CsvReader(paymentTransactionList, freelancerRecord, taskList);
        type1.readNewFile(nameFile);        
    }
    
    public void getFileTxt(File nameFile){
        Organization org = orgRec.getOrganization();
        PaymentTransactionList paymentTransactionList = org.getPaymentTransactionList();
        FreelancersRecord freelancerRecord = m_Platform.getFreelancersRecord();
        TaskList taskList = org.getTaskList();
        FileReader type2 = new TxtReader(paymentTransactionList, freelancerRecord, taskList);
        type2.readNewFile(nameFile);
    }
    
    public List<PaymentTransaction> getTransactions(){
        String email =facade.getCurrentSession().getUser().getEmail();
        Organization org = orgRec.getOrganizationByUserEmail(email);
        return org.getPaymentTransactionList().getPaymentTransactions();
    }
}
