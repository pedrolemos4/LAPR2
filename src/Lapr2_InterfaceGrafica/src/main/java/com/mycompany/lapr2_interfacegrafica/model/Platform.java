package com.mycompany.lapr2_interfacegrafica.model;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import java.util.List;

public class Platform {

    private String m_strDesignacao;
    private final FacadeAuthorization m_oAutorizacao;
    private FreelancersRecord freelRec;
    private OrganizationsRecord orgRec;
    private PaymentTransactionList paymentTransList;
    private Organization org;
    private PasswordGeneratorAlgorithm alg;

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

    public PasswordGeneratorAlgorithm getPasswordGeneratorAlgorithm() {
        return this.alg;
    }

    public void agendNotification() {

    }
}
