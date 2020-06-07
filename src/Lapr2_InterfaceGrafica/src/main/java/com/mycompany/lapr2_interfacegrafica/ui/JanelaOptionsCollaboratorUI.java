/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author pedro
 */
public class JanelaOptionsCollaboratorUI {
    
    private MainApp mainApp;

    @FXML
    private Button btnCreateFreelancer;
    @FXML
    private Button btnCreateTask;
    @FXML
    private Button btnCreatePayment;
    @FXML
    private Button btnUploadFile;
    @FXML
    private Button btnCheckStatistics;
    @FXML
    private Button btnLogout;

    @FXML
    private void btnCreateFreelanceerAction(ActionEvent event) {
        CreateFreelancerUI createFreelancerUI = new CreateFreelancerUI(this.mainApp);
        createFreelancerUI.toCreateFreelancerScene1UI();
    }

    @FXML
    private void btnCreateTaskAction(ActionEvent event) {
        CreateTaskUI createTaskUI = new CreateTaskUI(this.mainApp);
        createTaskUI.toCreateTaskScene1UI();
    }

    @FXML
    private void btnCreatePaymentAction(ActionEvent event) {
        
    }

    @FXML
    private void btnUploadFileAction(ActionEvent event) {
    }

    @FXML
    private void btnCheckStatisticsAction(ActionEvent event) {
    }

    @FXML
    private void btnLogoutAction(ActionEvent event) {
        
    }
    
}
