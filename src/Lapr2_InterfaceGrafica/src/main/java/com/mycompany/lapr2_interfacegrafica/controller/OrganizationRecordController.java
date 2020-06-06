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
        this.m_oApp = POTApplication.getInstance();
        this.m_oPlataforma = m_oApp.getPlataforma();
    }

    public boolean newOrganization(String name, String NIF, String nameM, String emailM, String nameC, String emailC) {
        try {
            this.org = this.or.newOrganization(name, NIF, nameM, emailM, nameC, emailC);
            return this.or.validateOrganization(this.org);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.org = null;
            return false;
        }
    }

    public boolean registerOrganization() {
        return this.or.organizationRegister(this.org);
    }

    public String getOrganizationToString() {
        return this.org.toString();
    }
}
