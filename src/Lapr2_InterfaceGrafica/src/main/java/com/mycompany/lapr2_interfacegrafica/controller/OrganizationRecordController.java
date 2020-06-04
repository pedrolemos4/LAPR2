package com.mycompany.lapr2_interfacegrafica.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import lapr2.pot.model.Platform;
import lapr2.pot.ui.console.utils.Utils;

public class OrganizationRecordController {

    private AplicacaoPOT m_oApp;
    private Plataforma m_oPlataforma;
    private Organization org;
    private OrganizationsRecord or;

    public OrganizationRecordController() {
        this.m_oApp = AplicacaoPOT.getInstance();
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

    public boolean registaOrganizacao() {
        return this.or.organizationRegister(this.org);
    }

    public String getOrganizationToString() {
        return this.org.toString();
    }
}
