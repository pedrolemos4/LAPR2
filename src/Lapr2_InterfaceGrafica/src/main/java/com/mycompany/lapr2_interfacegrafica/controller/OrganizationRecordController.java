package com.mycompany.lapr2_interfacegrafica.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import lapr2.pot.ui.console.utils.Utils;

public class OrganizationRecordController {

    
    private Platform m_oPlatform;
    private Organization org;
    private OrganizationsRecord or;

    public OrganizationRecordController() {
        // this.m_oApp = POTApplication.getInstance();
        this.m_oPlatform = POTApplication.getPlatform();
        this.or=m_oPlatform.getOrganizationsRecord();
    }

    public Organization newOrganization(String name, String NIF, String nameM, String emailM, String nameC, String emailC) {
        this.or = m_oPlatform.getOrganizationsRecord();
        this.org = or.newOrganization(name, NIF, nameM, emailM, nameC, emailC);
        if (this.or.validateOrganization(this.org)) {
            return this.org;
        }
        return null;
    }

    public boolean registerOrganization() {
        return this.or.organizationRegister(this.org);
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
