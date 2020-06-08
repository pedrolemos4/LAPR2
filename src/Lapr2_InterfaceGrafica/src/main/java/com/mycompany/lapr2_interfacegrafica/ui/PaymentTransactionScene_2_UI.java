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
public class PaymentTransactionScene_2_UI implements Initializable {

    //private CreatePaymentTransactionUI createPaymentTransactionUI; 
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnReturn;
    @FXML
    private Label lblTransaction;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

//    public void setCreatePaymentTransactionUI(CreatePaymentTransactionUI createPaymentTransactionUI) {
//        this.createPaymentTransactionUI = createPaymentTransactionUI;
//    }
    public void showTransaction() {
        //    String strTransaction = createPaymentTransactionUI.getController().getEmployee();
//        this.lblTransaction.setMinWidth(strTransaction.length());
//        this.lblTransaction.setText(strTransaction);
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) {
//        boolean registered = this.createPaymentTransactionUI.
//                getController().registerTransaction();
//        String notification;
//        if (registered) {
//            notification = "Transaction created with Success.";
//        } else {
//            notification = "Transaction created Insuccess.";
//        }
//        this.registerEmployeeUI.toRegisterEmployeeScene3(notification);
//        this.registerEmployeeUI.getController().setEmployee(null);
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
      //  this.createPaymentTransactionUI.getMainApp().toMainScene();
    }

    @FXML
    private void btnReturnAction(ActionEvent event) {
        //this.createPaymentTransactionUI.toCreatePaymentTransactionScene1();
    }

}
