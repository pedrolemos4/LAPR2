package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.OrganizationRecordController;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddNewOrganizationUI {

    private final MainApp mainApp;
    private final OrganizationRecordController controller;

    public AddNewOrganizationUI(MainApp mainApp) {
        this.mainApp = mainApp;
        this.controller = new OrganizationRecordController();
    }

    public MainApp getMainApp() {
        return this.mainApp;
    }

    public OrganizationRecordController getOrganizationRecordController() {
        return this.controller;
    }

    public void toAddNewOrganizationScene1UI() {
        try {
            AddNewOrganizationScene_1_UI addOrganization1UI = (AddNewOrganizationScene_1_UI) this.mainApp.replaceSceneContent("/fxml/AddNewOrganization_1_.fxml");
            addOrganization1UI.addNewOrganization(this);
            String org1 = this.getOrganizationRecordController().getOrganizationToString();
            if (org1 != null) {
                addOrganization1UI.showOrganization();
            }
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toAddNewOrganizationScene2UI() {
        try {
            AddNewOrganizationScene_2_UI addOrganization2UI = (AddNewOrganizationScene_2_UI) this.mainApp.replaceSceneContent("/fxml/AddNewOrganization_2_.fxml");
            addOrganization2UI.setAddNewOrganization(this);
            addOrganization2UI.showOrganization();
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toAddNewOrganizationScene3UI(String notification) {
        try {
            AddNewOrganizationScene_3_UI addOrganization3UI = (AddNewOrganizationScene_3_UI) this.mainApp.replaceSceneContent("/fxml/AddNewOrganization_3_.fxml");
            addOrganization3UI.setAddNewOrganizationUI(this);
            addOrganization3UI.showNotification(notification);
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}