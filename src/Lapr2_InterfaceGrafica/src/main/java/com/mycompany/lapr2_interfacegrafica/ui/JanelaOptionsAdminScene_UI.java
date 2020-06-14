package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.SendEmailController;
import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

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
        sendEmailController = new SendEmailController();
        sendEmailController.getListFreelancersAdapt();
        for (Freelancer freel : sendEmailController.getListFreelancersAdapt()) {
            sendEmailController.sendEmail(freel);
            AlertUI.createAlert(Alert.AlertType.INFORMATION,"T4J-PAYMENTS" ,
                    "Success" , "Check the email.txt file").show();
        }
    }
}
