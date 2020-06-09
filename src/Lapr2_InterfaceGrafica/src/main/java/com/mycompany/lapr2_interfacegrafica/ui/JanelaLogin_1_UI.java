/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.POTApplication;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Tiago
 */
public class JanelaLogin_1_UI implements Initializable {

    private MainApp mainApp;

    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtEmail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        this.btnLogin.setDisable(POTApplication.getInstance().getPlataforma().
//                getOrganizationsRecord().getOrganizations().isEmpty());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void btnLoginAction(ActionEvent event) {
      JanelaOptionsAdminUI jOAUI = new JanelaOptionsAdminUI(this.mainApp);
       jOAUI.toMenuAdminScene();
    // JanelaOptionsCollaboratorUI jOCUI = new JanelaOptionsCollaboratorUI(this.mainApp);
      // jOCUI.toMenuCollaboratorScene();
//        JanelaOptionsManagerUI jOMUI = new JanelaOptionsManagerUI(this.mainApp);
//        jOMUI.toMenuManagerScene();
    }

    @FXML
    private void txtEmailKeyPressed(KeyEvent event) {
    }

}
