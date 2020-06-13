package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreatePaymentTransactionController;
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
import javafx.stage.Stage;

public class PaymentTransactionScene_2_UI implements Initializable {

    private JanelaOptionsAdminScene_UI janelaOptionsAdminUI;
    private PaymentTransactionScene_1_UI paymentTransactionUI;
    private CreatePaymentTransactionController controller;

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
        this.controller = new CreatePaymentTransactionController();
    }

//    public void setCreatePaymentTransactionUI(CreatePaymentTransactionUI createPaymentTransactionUI) {
//        this.createPaymentTransactionUI = createPaymentTransactionUI;
//    }
    public void showTransaction() {
        String strTransaction = this.controller.getPaymentTransactionToString();
        this.lblTransaction.setMinWidth(strTransaction.length());
        this.lblTransaction.setText(strTransaction);
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) throws IOException {
//        boolean registered = this.controller.paymentTransactionRegister();
//        if (registered) {
//            AlertUI.createAlert(Alert.AlertType.INFORMATION, "Success", "T4J-PAYMENTS",
//                    "Payment Transaction registered successfully").show();
//            goToScene(event, "/fxml/OptionsAdmin.fxml");
//        } else {
//            AlertUI.createAlert(Alert.AlertType.ERROR, "Error", "T4J-PAYMENTS", "Organization was not registered.").show();
//            goToScene(event, "/fxml/PaymentTransaction_1.fxml");
//        }
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/OptionsCollaborator.fxml");
    }

    @FXML
    private void btnReturnAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/PaymentTransaction_1.fxml");
    }

    private void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }
}
