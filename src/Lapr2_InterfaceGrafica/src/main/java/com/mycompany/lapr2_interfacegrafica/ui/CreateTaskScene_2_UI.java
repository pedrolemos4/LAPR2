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
public class CreateTaskScene_2_UI implements Initializable {

    //  private CreateTaskUI createTaskUI;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnReturn;
    @FXML
    private Label lblTask;
    @FXML
    private Button btnConfirm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

//    public void setCreateTaskUI(CreateTaskUI createTaskUI) {
//        this.createTaskUI = createTaskUI;
//    }

    public void showTask() {
        //this.lblTask.setText(this.createTaskUI.getController().getCategory());
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) {
//        boolean registered = this.createTaskUI.
//                getController().registerTask();
//        String notification;
//        if (registered) {
//            notification = "Task created with Success.";
//        } else {
//            notification = "The task was not created.";
//        }
//        this.createTaskUI.toSpecifyCategoryScene3(notification);
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
    //    this.createTaskUI.getMainApp().toMainScene();
    }

    @FXML
    private void btnReturnAction(ActionEvent event) {
   //     this.createTaskUI.toCreateTaskScene1();
    }

}
