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
import javafx.scene.control.Label;

/**
 *
 * @author Tiago
 */
public class AddNewOrganizationScene_2_UI implements Initializable {

  //  private AddNewOrganizationUI addNewOrganizationUI;

    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnReturn;
    @FXML
    private Label lblOrganization;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
//
//    public void setAddNewOrganization(AddNewOrganizationUI addNewOrganizationUI) {
//        this.addNewOrganizationUI = addNewOrganizationUI;
//    }
//
//    public void showOrganization() {
//        this.lblOrganization.setText(this.addNewOrganization.getController().getOrganization());
//    }
//
//    @FXML
//    private void btnConfirmAction(ActionEvent event) {
//        boolean registered = this.AddNewOrganizationUI.getController.registerOrganization();
//        String notification;
//        if (registered) {
//            notification = "Organization added with sucess.";
//        } else {
//            notification = "Organization was not added.";
//        }
//        this.AddNewOrganizationUI.toAddNewOrganizationScene3(notification);
//    }
//
//    @FXML
//    private void btnCancelAction(ActionEvent event) {
//        this.addNewOrganizationUI.getMainApp().toMainScene();
//    }
//
//    @FXML
//    private void btnReturnAction(ActionEvent event) {
//        this.addNewOrganizationUI.toSpecifyCategoryScene1();
//    }

}
