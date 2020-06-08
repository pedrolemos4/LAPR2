package com.mycompany.lapr2_interfacegrafica.authorization;

import com.mycompany.lapr2_interfacegrafica.authorization.model.User;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserRole;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserRolesRecord;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UsersRecord;

public class FacadeAuthorization {

    private UserSession m_oSession = null;

    private final UserRolesRecord m_oRoles = new UserRolesRecord();
    private final UsersRecord m_oUsers = new UsersRecord();

    public boolean registesUserRole(String strRole) {
        UserRole papel = this.m_oRoles.newUserRole(strRole);
        return this.m_oRoles.addRole(papel);
    }

    public boolean registesUserRole(String strRole, String strDescription) {
        UserRole role = this.m_oRoles.newUserRole(strRole, strDescription);
        return this.m_oRoles.addRole(role);
    }

    public boolean registesUser(String strName, String strEmail, String strPassword) {
        User user = this.m_oUsers.newUser(strName, strEmail, strPassword);
        return this.m_oUsers.addUser(user);
    }

    public boolean registesUserWithRole(String strName, String strEmail, String strPassword, String strRole) {
        UserRole papel = this.m_oRoles.searchRole(strRole);
        User utlz = this.m_oUsers.newUser(strName, strEmail, strPassword);
        utlz.addRole(papel);
        return this.m_oUsers.addUser(utlz);
    }

    public boolean registesUserWithRoles(String strName, String strEmail, String strPassword, String[] roles) {
        User user = this.m_oUsers.newUser(strName, strEmail, strPassword);
        for (String strPapel : roles) {
            UserRole papel = this.m_oRoles.searchRole(strPapel);
            user.addRole(papel);
        }
        return this.m_oUsers.addUser(user);
    }

    public boolean UserExists(String strId) {
        return this.m_oUsers.hasUser(strId);
    }

    public UserSession doLogin(String strId, String strPwd) {
        User user = this.m_oUsers.searchUser(strId);
        if (user != null) {
            if (user.hasPassword(strPwd)) {
                this.m_oSession = new UserSession(user);
            }
        }
        return getCurrentSession();
    }

    public UserSession getCurrentSession() {
        return this.m_oSession;
    }

    public void doLogout() {
        if (this.m_oSession != null) {
            this.m_oSession.doLogout();
        }
        this.m_oSession = null;
    }
}
