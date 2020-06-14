package com.mycompany.lapr2_interfacegrafica.authorization.model;

import java.io.Serializable;

public class UserSession implements Serializable {

    private User m_oUser;

    public UserSession() {
        this.m_oUser = null;
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
            System.out.println(this.m_oUser.getEmail());
        }
        System.out.println("está null na user session outra vez");
        return null;
    }

    public User getUser() {
        if(this.m_oUser==null){
            System.out.println("Erro no método getUser(UserSession)");
        } 
        return this.m_oUser;
    }
}
