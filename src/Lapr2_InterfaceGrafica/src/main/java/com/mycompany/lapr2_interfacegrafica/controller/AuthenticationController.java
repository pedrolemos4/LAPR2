package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.authorization.model.UserRole;
import java.util.List;

public class AuthenticationController {

    private POTApplication m_oApp;

    public AuthenticationController() {
     //   this.m_oApp = POTApplication.getInstance();
    }

    public boolean doLogin(String strId, String strPwd) {
        return this.m_oApp.doLogin(strId, strPwd);
    }

    public List<UserRole> getPapeisUtilizador() {
        if (this.m_oApp.getCurrentSession().isLoggedIn()) {
            return this.m_oApp.getCurrentSession().getUser().getRoles();
        }
        return null;
    }

    public void doLogout() {
        this.m_oApp.doLogout();
    }
}
