package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import java.io.IOException;

public class OrganizationRecordController {

    private Platform m_oPlatform;
    private Organization org;
    private OrganizationsRecord or;

    public OrganizationRecordController() {
        this.m_oPlatform = POTApplication.getPlatform();
        this.or = m_oPlatform.getOrganizationsRecord();
    }

    public Organization newOrganization(String name, String NIF, String nameM, String emailM, String nameC, String emailC) {
        Organization org1 = this.or.newOrganization(name, NIF, nameM, emailM, nameC, emailC);
        this.org = org1;
        if (this.or.validateOrganization(this.org)) {
            System.out.println("Validou Controller");
            this.or.addOrganization(this.org);
            return this.org;
        }
        return null;
    }

    public boolean registerOrganization() throws IOException {
        OrganizationsRecord g = m_oPlatform.getOrganizationsRecord();
        Organization y = g.getOrganization();
        return g.organizationRegister(y);
    }

    public String getOrganizationToString() {
        return this.org.toString();
    }

    public Organization getOrganization() {
        return this.org;
    }

    public String getOrganizationName() {
        return org.getOrgName();
    }

    public String getOrganizationNIF() {
        return org.getOrgNIF();
    }
}
