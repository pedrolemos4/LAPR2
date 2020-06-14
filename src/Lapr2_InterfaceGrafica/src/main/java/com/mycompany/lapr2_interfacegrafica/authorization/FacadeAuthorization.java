package com.mycompany.lapr2_interfacegrafica.authorization;

import com.mycompany.lapr2_interfacegrafica.authorization.model.User;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.authorization.model.UsersRecord;
import com.mycompany.lapr2_interfacegrafica.model.ExternalAlgorithm1API;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import com.mycompany.lapr2_interfacegrafica.ui.AlertUI;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import javafx.scene.control.Alert;

public class FacadeAuthorization implements Serializable {

    private UserSession m_oSession;

    private Platform plat;

    private UsersRecord usersRecord;
    
    private final UsersRecord m_oUsers = new UsersRecord();

    public FacadeAuthorization() {
        this.usersRecord = new UsersRecord();
        this.m_oSession = new UserSession();
    }

    public boolean registesUserWithRole(String strName, String strEmail, String strRole) {
        ExternalAlgorithm1API exAlgApi = new ExternalAlgorithm1API();
        String pwdA = exAlgApi.generatePassword(strName, strEmail);
        User utlz = this.m_oUsers.newUser(strName, strEmail, pwdA);
        utlz.setRole(strRole);
        sendEmail(strEmail, pwdA, strRole);
        return this.m_oUsers.addUser(utlz);
    }

    public void sendEmail(String email, String pwd, String role) {
        try (FileWriter writer = new FileWriter("email.txt", true)) {
            writer.write("Role: " + role + "\nEmail: " + email + "\nPassword: " + pwd + "\n");
            writer.close();
        } catch (IOException ex) {
            AlertUI.createAlert(Alert.AlertType.ERROR, "T4J-PAYMENTS", "Unsuccess",
                    "Error sending email!").show();
        }
    }

    public boolean registesUserWithRole(String strName, String strEmail, String strPassword, String role) {
        User user = this.m_oUsers.newUser(strName, strEmail, strPassword);
        user.setRole(role);
        return this.m_oUsers.addUser(user);
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
    }

}
