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
        this.or = m_oPlatform.getOrganizationsRecord();
    }

    public Organization newOrganization(String name, String NIF, String nameM, String emailM, String nameC, String emailC) {
        OrganizationsRecord r = m_oPlatform.getOrganizationsRecord();
        Organization org1 = r.newOrganization(name, NIF, nameM, emailM, nameC, emailC);
        this.org = org1;
        if (this.or.validateOrganization(org1)) {
            System.out.println("Validou Controller");
            this.or.addOrganization(org1);
            return org1;
        }
        return null;
    }

    public boolean registerOrganization() {
        OrganizationsRecord g = m_oPlatform.getOrganizationsRecord();
        Organization y = g.getOrganization();
        //this.or.getOrganizationToString(this.org);

//        this.or.getOrganizations().get(0);
//        System.out.println("Org: " + this.or.getOrganizations().get(0).toString());
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
