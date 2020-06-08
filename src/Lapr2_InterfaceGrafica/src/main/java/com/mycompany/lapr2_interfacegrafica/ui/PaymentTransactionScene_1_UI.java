/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreatePaymentTransactionController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Tiago
 */
public class PaymentTransactionScene_1_UI implements Initializable {

    //private CreatePaymentTransactionUI createPaymentTransactionUI;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnCancel;
    @FXML
    private Label lblAlert;
    @FXML
    private TextField txtTaskEndDate;
    @FXML
    private TextField txtTaskDelay;
    @FXML
    private TextField txtWorkDescription;
    @FXML
    private ComboBox<String> cmbTask;
    @FXML
    private ComboBox<String> cmbFreelancer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

//    public void setPaymentTransactionUI(CreatePaymentTransactionUI paymentTransactionUI) {
//        this.paymentTransactionUI = paymentTransactionUI;
//    }
    public void initComboBox() {
//        CreatePaymentTransactionController controller = this.createPaymentTransactionUI.
//                getController();
//        ObservableList<String> tasks
//                = FXCollections.observableArrayList(controller.getCategoriesAsStringSet());
//        this.cmbTask.setItems(tasks);
//
//        ObservableList<String> freelancers
//                = FXCollections.observableArrayList(controller.getFreelancersçAsStringSet());
//        this.cmbFreelancer.setItems(freelancers);
    }

    public void showTransaction() {
//        this.cmbFreelancer.setValue(this.CreatePaymentTransactionUI.getController.getFreelancer());
//        this.cmbTask.setValue(this.CreatePaymentTransactionUI.getController.getTask());
//        this.txtTaskDelay.setText(this.CreatePaymentTransactionUI.getController.getTaskDelay());
//        this.txtTaskEndDate.setText(this.CreatePaymentTransactionUI.getController.getTaskEndDate());
//        this.txtWorkDescription.setText(this.CreatePaymentTransactionUI.getController.getWorkDescription());
    }

    @FXML
    private void btnNextAction(ActionEvent event) {
        try {
            String endDate = this.txtTaskEndDate.getText();
            int taskDelay = Integer.parseInt(this.txtTaskDelay.getText());
            String workDescription = this.txtWorkDescription.getText();
            String task = this.cmbTask.getSelectionModel().getSelectedItem();
            String freelancer = this.cmbFreelancer.getSelectionModel().getSelectedItem();
            //   this.paymentTransactionUI.getController().newPaymentTransaction(endDate,
            //           taskDelay, workDescription, task, freelancer);
            // this.paymentTransactionUI.toCreatePaymentTransactionScene2();
        } catch (NumberFormatException ex) {
            this.lblAlert.setText("Invalid number!");
            this.txtTaskDelay.requestFocus();
        } catch (IllegalArgumentException ex) {
            this.lblAlert.setText(ex.getMessage());
            if (ex.getMessage().toLowerCase().contains("work")) {
                this.txtWorkDescription.requestFocus();
            } else if (ex.getMessage().toLowerCase().contains("task")) {
                this.cmbTask.requestFocus();
            } else {
                this.cmbFreelancer.requestFocus();
            }
        }
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
        //this.paymentTransactionUI.getMainApp().toMainScene();
    }

    @FXML
    private void txtTaskEndDateKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtTaskDelayKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtWorkDescriptionKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void cmbTaskAction(ActionEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void cmbFreelancerAction(ActionEvent event) {
        this.lblAlert.setText(null);
    }

}
