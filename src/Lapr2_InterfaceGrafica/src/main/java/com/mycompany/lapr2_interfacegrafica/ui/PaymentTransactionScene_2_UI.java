package com.mycompany.lapr2_interfacegrafica.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PaymentTransactionScene_2_UI implements Initializable {

    private CreatePaymentTransactionUI createPaymentTransactionUI;
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

    public void setCreatePaymentTransactionUI(CreatePaymentTransactionUI createPaymentTransactionUI) {
        this.createPaymentTransactionUI = createPaymentTransactionUI;
    }

    public void showTransaction() {
        String strTransaction = createPaymentTransactionUI.getCreatePaymentTransactionController().getPaymentTransactionToString();
        this.lblTransaction.setMinWidth(strTransaction.length());
        this.lblTransaction.setText(strTransaction);
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) {
        boolean registered = this.createPaymentTransactionUI.
                getCreatePaymentTransactionController().paymentTransactionRegister();
        String notification;
        if (registered) {
            notification = "Transaction created with Success.";
        } else {
            notification = "Transaction created Insuccess.";
        }
        this.createPaymentTransactionUI.toAddNewOrganizationScene3UI(notification);
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
        this.createPaymentTransactionUI.getMainApp().toMainScene();
    }

    @FXML
    private void btnReturnAction(ActionEvent event) {
        this.createPaymentTransactionUI.toAddNewOrganizationScene1UI();
    }

}
