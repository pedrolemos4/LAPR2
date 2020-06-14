/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.SendEmailController;
import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class JanelaOptionsAdminScene_UI implements Initializable {

    private AddNewOrganizationScene_1_UI addNewOrganizationUI;
    private JanelaLogin_1_UI janelaLoginUI;
    private CheckPerformanceIndicatorsUI checkPerformanceIndicatorsUI;
    private SendEmailController sendEmailController;

    private List<Freelancer> lstFreelApt;

    @FXML
    private Button btnCheckPerformance;
    @FXML
    private Button btnAddNewOrganization;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnSendEmail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setNewOptionsAdminUI(JanelaLogin_1_UI janelaLoginUI) {
        this.janelaLoginUI = janelaLoginUI;
    }

    @FXML
    private void btnCheckPerformanceAction(ActionEvent event) throws IOException {
        if (checkPerformanceIndicatorsUI == null) {
            checkPerformanceIndicatorsUI = new CheckPerformanceIndicatorsUI();
        }
        checkPerformanceIndicatorsUI.goToScene(event, "/fxml/CheckPerformanceIndicators.fxml");
    }

    @FXML
    private void btnAddNewOrganizationAction(ActionEvent event) throws IOException {
        if (addNewOrganizationUI == null) {
            addNewOrganizationUI = new AddNewOrganizationScene_1_UI();
        }
        addNewOrganizationUI.goToScene(event, "/fxml/AddNewOrganization_1_.fxml");
    }

    @FXML
    private void btnLogoutAction(ActionEvent event) throws IOException {
        if (janelaLoginUI == null) {
            janelaLoginUI = new JanelaLogin_1_UI();
        }
        janelaLoginUI.goToScene(event, "/fxml/LoginWindow.fxml");
    }

    @FXML
    private void btnSendEmailAction(ActionEvent event) throws FileNotFoundException {
      //  try {
            System.out.println("entra no try");
            sendEmailController = new SendEmailController();
            System.out.println("linha 114");
            /*this.lstFreelApt =*/ sendEmailController.getListFreelancersAdapt();
            System.out.println("lstFreelApt: " + sendEmailController.getListFreelancersAdapt());
            if (sendEmailController.getListFreelancersAdapt() == null) {
                System.out.println("lstFreelApt=null");
            }
            for (Freelancer freel : sendEmailController.getListFreelancersAdapt()) {
                sendEmailController.sendEmail(freel);
                System.out.println("entra no for");
                AlertUI.createAlert(Alert.AlertType.INFORMATION, "Sucess", "T4J", "Check the email.txt file").show();
            }  
        }
    }