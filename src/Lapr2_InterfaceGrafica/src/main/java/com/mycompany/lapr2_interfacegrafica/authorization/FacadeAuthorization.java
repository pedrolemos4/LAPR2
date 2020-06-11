package com.mycompany.lapr2_interfacegrafica.authorization;

import com.mycompany.lapr2_interfacegrafica.authorization.model.User;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserRole;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserRolesRecord;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UsersRecord;
import com.mycompany.lapr2_interfacegrafica.model.ExternalAlgorithm1API;
import com.mycompany.lapr2_interfacegrafica.model.PasswordGeneratorAlgorithm;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import java.io.Serializable;

public class FacadeAuthorization implements Serializable {

    private UserSession m_oSession;

    //  private ExternalAlgorithm1API exAlgApi;
    private Platform plat;

    private UsersRecord usersRecord;

    public FacadeAuthorization() {
        this.usersRecord = new UsersRecord();
        this.m_oSession = new UserSession();
    }
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

    public boolean registesUserWithRole(String strName, String strEmail, String strRole) {
        // ExternalAlgorithm1API alg = plat.getPasswordGeneratorAlgorithm();
        ExternalAlgorithm1API exAlgApi = new ExternalAlgorithm1API();
        String pwdM = exAlgApi.generatePassword(strName, strEmail);

        //String password = exAlgApi.generatePassword(strName, strEmail);
        System.out.println("password");
        UserRole papel = this.m_oRoles.searchRole(strRole);
        User utlz = this.m_oUsers.newUser(strName, strEmail, pwdM);
        utlz.setRole(strRole);
        return this.m_oUsers.addUser(utlz);
    }

    public boolean registesUserWithRole(String strName, String strEmail, String strPassword, String role) {
        User user = this.m_oUsers.newUser(strName, strEmail, strPassword);
        UserRole papel = this.m_oRoles.searchRole(role);
        user.setRole(role);
        return this.m_oUsers.addUser(user);
    }

    public boolean UserExists(String strId) {
        return this.m_oUsers.hasUser(strId);
    }

    public boolean doLogin(String strId, String strPwd) {
        User user = this.m_oUsers.searchUser(strId);
        if (user == null) {
            return false;
        }

        if (user.hasPassword(strPwd)) {
            this.m_oSession = new UserSession(user);
            return true;
        } else {
            return false;
        }
    }

    public UserSession getCurrentSession() {
        return this.m_oSession;
    }

    public void doLogout() {
        if (this.m_oSession != null) {
            this.m_oSession.doLogout();
        }
        //this.m_oSession = null;
    }

}
