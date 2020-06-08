package com.mycompany.lapr2_interfacegrafica.model;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import java.util.List;

public class Platform {

    private String m_strDesignacao;
    private final FacadeAuthorization m_oAutorizacao;
    private FreelancersRecord freelRec;
    private Organization org;
    private OrganizationsRecord orgRec;
    private PaymentTransactionList paymentTrans;

    
    private final TaskList taskRecord = new TaskList();

    public Platform(String strDesignacao) {
        if ((strDesignacao == null)
                || (strDesignacao.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }
        this.m_strDesignacao = strDesignacao;
        this.m_oAutorizacao = new FacadeAuthorization();
    }

    public FacadeAuthorization getFacadeAuthorization() {
        return this.m_oAutorizacao;
    }

    public FreelancersRecord getRegistoFreelancer() {
        return freelRec;
    }
    
    public TaskList getTaskRecord(){
        return taskRecord;
    }
    
    public Organization getOrganization(){
        return org;
    }
    
    public void agendNotification(){
        
    }
    
    public OrganizationsRecord getOrganizationsRecord(){
        return orgRec;
    }
    
    public PaymentTransactionList getPaymentTransactionList(){
        return paymentTrans;
    }
}
