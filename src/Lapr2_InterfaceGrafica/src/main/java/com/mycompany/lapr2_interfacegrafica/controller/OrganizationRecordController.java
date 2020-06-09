package com.mycompany.lapr2_interfacegrafica.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import lapr2.pot.ui.console.utils.Utils;

public class OrganizationRecordController {

    private POTApplication m_oApp;
    private Platform m_oPlataforma;
    private Organization org;
    private OrganizationsRecord or;

    public OrganizationRecordController() {
       // this.m_oApp = POTApplication.getInstance();
        this.m_oPlataforma = m_oApp.getPlataforma();
        this.org=null;
        System.out.println("1");
    }

    public Organization newOrganization(String name, String NIF, String nameM, String emailM, String nameC, String emailC) {
//        try {
            this.or=m_oPlataforma.getOrganizationsRecord();
            return this.org = or.newOrganization(name, NIF, nameM, emailM, nameC, emailC);
//            return this.or.validateOrganization(this.org);
//        } catch (RuntimeException ex) {
//            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
//            this.org = null;
//            return false;
//        }
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
