package com.mycompany.lapr2_interfacegrafica.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AddNewOrganizationScene_2_UI implements Initializable {

    private AddNewOrganizationUI addNewOrganizationUI;

    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnReturn;
    @FXML
    private Label lblOrganization;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setAddNewOrganization(AddNewOrganizationUI addNewOrganizationUI) {
        this.addNewOrganizationUI = addNewOrganizationUI;
    }

    public void showOrganization() {
        this.lblOrganization.setText(this.addNewOrganizationUI.getOrganizationRecordController().getOrganizationToString());
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) {
        boolean registered = this.addNewOrganizationUI.getOrganizationRecordController().registerOrganization();
        String notification;
        if (registered) {
            notification = "Organization added with sucess.";
        } else {
            notification = "Organization was not added.";
        }
        this.addNewOrganizationUI.toAddNewOrganizationScene3UI(notification);
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
        this.addNewOrganizationUI.getMainApp().toMainScene();
    }

    @FXML
    private void btnReturnAction(ActionEvent event) {
        this.addNewOrganizationUI.toAddNewOrganizationScene1UI();
    }

}
