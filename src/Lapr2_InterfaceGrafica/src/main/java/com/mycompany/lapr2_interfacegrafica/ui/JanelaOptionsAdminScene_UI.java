/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Tiago
 */
public class JanelaOptionsAdminScene_UI implements Initializable {

//    private MainApp mainApp;
//    private JanelaOptionsAdminUI janelaOptionsAdminUI;
    
    private AddNewOrganizationScene_1_UI addNewOrganizationUI;
    private JanelaLogin_1_UI janelaLoginUI;
    
    @FXML
    private Button btnCheckPerformance;
    @FXML
    private Button btnAddNewOrganization;
    @FXML
    private Button btnLogout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setNewOptionsAdminUI(JanelaLogin_1_UI janelaLoginUI){
        this.janelaLoginUI=janelaLoginUI;
    }
    
    @FXML
    private void btnCheckPerformanceAction(ActionEvent event) throws IOException {
        Parent checkPerformance = FXMLLoader.load(getClass().getResource("/fxml/CheckPerformanceIndicators.fxml"));
        Scene checkPerfomanceScene = new Scene(checkPerformance);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(checkPerfomanceScene);
        window.show();
    }

    @FXML
    private void btnAddNewOrganizationAction(ActionEvent event) throws IOException {
        Parent addOrganization = FXMLLoader.load(getClass().getResource("/fxml/AddNewOrganization_1_.fxml"));
        Scene addOrganizationScene = new Scene(addOrganization);
        Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addOrganizationScene);
        window.show();
       // AddNewOrganizationUI addNewOrganizationUI = new AddNewOrganizationUI(this.mainApp);
        //addNewOrganizationUI.toAddNewOrganizationScene1UI();
    }

    @FXML
    private void btnLogoutAction(ActionEvent event) throws IOException {
        Parent logout = FXMLLoader.load(getClass().getResource("/fxml/JanelaLogin.fxml"));
        Scene logoutScene = new Scene(logout);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(logoutScene);
        window.show();
    }

}
