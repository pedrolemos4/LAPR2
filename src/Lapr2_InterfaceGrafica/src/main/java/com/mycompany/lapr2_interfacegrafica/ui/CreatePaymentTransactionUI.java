package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreatePaymentTransactionController;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreatePaymentTransactionUI {

    private final MainApp mainApp;
    private final CreatePaymentTransactionController controller;

    public CreatePaymentTransactionUI(MainApp mainApp) {
        this.mainApp = mainApp;
        this.controller = new CreatePaymentTransactionController();
    }

    public MainApp getMainApp() {
        return this.mainApp;
    }

    public CreatePaymentTransactionController getCreatePaymentTransactionController() {
        return this.controller;
    }

    public void toAddNewOrganizationScene1UI() {
        try {
            PaymentTransactionScene_1_UI createPaymentTransaction1UI = (PaymentTransactionScene_1_UI) this.mainApp.replaceSceneContent("/fxml/PaymentTransaction_1.fxml");
            createPaymentTransaction1UI.setPaymentTransactionUI(this);
            String payT = this.getCreatePaymentTransactionController().getPaymentTransactionToString();
            if (payT != null) {
                createPaymentTransaction1UI.showTransaction();
            }
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toAddNewOrganizationScene2UI() {
        try {
            PaymentTransactionScene_2_UI createPaymentTransaction2UI = (PaymentTransactionScene_2_UI) this.mainApp.replaceSceneContent("/fxml/PaymentTransaction_2.fxml");
            createPaymentTransaction2UI.setCreatePaymentTransactionUI(this);
            createPaymentTransaction2UI.showTransaction();
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toAddNewOrganizationScene3UI(String notification) {
        try {
            PaymentTransactionScene_3_UI createPaymentTransaction3UI = (PaymentTransactionScene_3_UI) this.mainApp.replaceSceneContent("/fxml/PaymentTransaction_3.fxml");
            createPaymentTransaction3UI.setCreatePaymentTransactionUI(this);
            createPaymentTransaction3UI.showNotification(notification);
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
