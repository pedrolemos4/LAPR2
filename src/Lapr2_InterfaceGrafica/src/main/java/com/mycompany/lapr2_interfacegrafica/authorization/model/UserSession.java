package com.mycompany.lapr2_interfacegrafica.authorization.model;

import java.util.List;

public class UserSession {

    private User m_oUser = null;

    private UserSession() {
    }

    public UserSession(User oUser) {
        if (oUser == null) {
            throw new IllegalArgumentException("The argument can't be null or empty.");
        }
        this.m_oUser = oUser;
    }

    public void doLogout() {
        this.m_oUser = null;
    }

    public boolean isLoggedIn() {
        return this.m_oUser != null;
    }

    public boolean isLoggedInWithRole(String strPapel) {
        if (isLoggedIn()) {
            return this.m_oUser.hasRole(strPapel);
        }
        return false;
    }

    public String getUserName() {
        if (isLoggedIn()) {
            this.m_oUser.getName();
        }
        return null;
    }

    public String getUserId() {
        if (isLoggedIn()) {
            this.m_oUser.getId();
        }
        return null;
    }

    public String getUserEmail() {
        if (isLoggedIn()) {
            this.m_oUser.getEmail();
        }
        return null;
    }

    public List<UserRole> getUserRoles() {
        return this.m_oUser.getRoles();
    }
}
