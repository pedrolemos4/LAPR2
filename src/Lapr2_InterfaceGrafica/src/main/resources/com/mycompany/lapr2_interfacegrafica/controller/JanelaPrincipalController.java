/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Tiago
 */
public class JanelaPrincipalController implements Initializable {

    @FXML
    private Label labelT4J;
    @FXML
    private Button btnAddNewOrganizations;
    @FXML
    private Button btnCheckPerformance;
    @FXML
    private Label labelAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAddNewOrganizationsAction(ActionEvent event) {
    }

    @FXML
    private void btnCheckPerformanceAction(ActionEvent event) {
    }
    
}
