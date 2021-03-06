
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetDayOfPaymentScene_1_UI implements Initializable {

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

    public TextField getTxtDate() {
        return this.txtDate;
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) throws IOException {
        try {
            controller.setProcessPaymentsDay(Integer.parseInt(this.txtDate.getText()));
            AlertUI.createAlert(Alert.AlertType.INFORMATION, "T4J-PAYMENTS", "Success",
                    "Wait for the day and time of payment and check the e-mail.txt file").show();
            goToScene(event, "/fxml/OptionsManager.fxml");
        } catch (IllegalArgumentException ex) {
            AlertUI.createAlert(Alert.AlertType.ERROR, "T4J-PAYMENTS", "Unsuccess",
                    "Pay attention to the writen information").show();
            goToScene(event, "/fxml/SetDayOfPaymentScene.fxml");
        }
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/OptionsManager.fxml");
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
