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
import javafx.scene.control.TextField;

/**
 *
 * @author Tiago
 */
public class SetDayOfPaymentScene_1_UI implements Initializable {

    private SetDayOfPaymentUI setDayOfPaymentUI;

    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtTimeOfTheDay;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;

    @FXML
    private Label lblAlert;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setSetDayOfPaymentUI(SetDayOfPaymentUI setDayOfPaymentUI) {
        this.setDayOfPaymentUI = setDayOfPaymentUI;
    }

    public TextField getTxtDate(){
        return this.txtDate;
    }
    
    @FXML
    private void btnConfirmAction(ActionEvent event) {
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
    }

}
