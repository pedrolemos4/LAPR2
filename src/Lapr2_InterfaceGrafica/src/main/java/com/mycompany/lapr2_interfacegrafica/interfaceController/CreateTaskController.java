/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.interfaceController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Tiago
 */
public class CreateTaskController {

    @FXML
    private Label lblCreateTask;
    @FXML
    private Label lblTaskID;
    @FXML
    private Label lblTaskDescription;
    @FXML
    private Label lblTimeDuration;
    @FXML
    private Label lblCostPerHour;
    @FXML
    private Label lblTaskCategory;
    @FXML
    private TextField txtTaskID;
    @FXML
    private TextField txtTaskDescription;
    @FXML
    private TextField txtTimeDuration;
    @FXML
    private TextField txtCostPerHour;
    @FXML
    private TextField txtTaskCategory;
    @FXML
    private Button btnCreate;
    @FXML
    private Button btnCancel;

    @FXML
    private void btnCreateAction(ActionEvent event) {
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
    }
    
}
