package com.mycompany.lapr2_interfacegrafica.model;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import java.io.Serializable;
import java.util.List;

public class Platform implements Serializable {

    private String m_strDesignacao;
    private final FacadeAuthorization m_oAutorizacao;
    public FreelancersRecord freelRec;
    public OrganizationsRecord orgRec;
    public PaymentTransactionList paymentTransList;
    public Organization org;
    public ExternalAlgorithm1API alg;

    public Platform() {
//        if ((strDesignacao == null)
//                || (strDesignacao.isEmpty())) {
//            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
//        }
//        this.m_strDesignacao = strDesignacao;
        this.m_oAutorizacao = new FacadeAuthorization();
        this.orgRec = new OrganizationsRecord();
        this.freelRec = new FreelancersRecord();
    }

    public FacadeAuthorization getFacadeAuthorization() {
        return this.m_oAutorizacao;
    }

    public FreelancersRecord getFreelancersRecord() {
        return this.freelRec;
    }

    public Organization getOrganization() {
        return this.org;
    }

    public OrganizationsRecord getOrganizationsRecord() {
        return this.orgRec;
    }

    public PaymentTransactionList getPaymentTransactionList() {
        return this.paymentTransList;
    }

    public ExternalAlgorithm1API getPasswordGeneratorAlgorithm() {
        return this.alg;
    }

    public void agendNotification() {

    }
}
