package com.mycompany.lapr2_interfacegrafica.model;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import java.io.Serializable;

public class Platform implements Serializable {

    private String m_strDesignacao;
    private final FacadeAuthorization m_oAutorizacao;
    public FreelancersRecord freelRec;
    public OrganizationsRecord orgRec;
    public Organization org;
    public ExternalAlgorithm1API alg;

    public Platform() {
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

    public ExternalAlgorithm1API getPasswordGeneratorAlgorithm() {
        return this.alg;
    }

  }
