/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author Tiago
 */
public class JanelaOptionsAdminScene_UI implements Initializable {

    private MainApp mainApp;

    private JanelaOptionsAdminUI janelaOptionsAdminUI;
    
    @FXML
    private Button btnCheckPerformance;
    @FXML
    private Button btnAddNewOrganization;
    @FXML
    private Button btnLogout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setNewOptionsAdminUI(JanelaOptionsAdminUI janelaOptionsAdminUI){
        this.janelaOptionsAdminUI=janelaOptionsAdminUI;
    }
    
    @FXML
    private void btnCheckPerformanceAction(ActionEvent event) {
    }

    @FXML
    private void btnAddNewOrganizationAction(ActionEvent event) {
        AddNewOrganizationUI addNewOrganizationUI = new AddNewOrganizationUI(this.mainApp);
        addNewOrganizationUI.toAddNewOrganizationScene1UI();
    }

    @FXML
    private void btnLogoutAction(ActionEvent event) {
    }

}
