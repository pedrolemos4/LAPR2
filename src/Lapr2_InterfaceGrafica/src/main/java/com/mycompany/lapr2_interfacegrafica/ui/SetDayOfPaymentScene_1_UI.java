/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.SetDayOfPaymentController;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Tiago
 */
public class SetDayOfPaymentScene_1_UI implements Initializable {

   // private SetDayOfPaymentUI setDayOfPaymentUI;
    private SetDayOfPaymentController controller;

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
        this.controller = new SetDayOfPaymentController();
    }

//    public void setSetDayOfPaymentUI(SetDayOfPaymentUI setDayOfPaymentUI) {
//        this.setDayOfPaymentUI = setDayOfPaymentUI;
//    }

    public TextField getTxtDate() {
        return this.txtDate;
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) {
        controller.setProcessPaymentsDay(Integer.parseInt(this.txtDate.getText()));
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
        goToScene(event,"/fxml/OptionsManager.fxml");
    }

    public void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
        setController();
    }

    public void setController() {
        this.controller = new SetDayOfPaymentController();
    }

}
