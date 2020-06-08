package com.mycompany.lapr2_interfacegrafica.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AddNewOrganizationScene_3_UI implements Initializable {

    private AddNewOrganizationUI addNewOrganizationUI;

    @FXML
    private Label lblNotification;
    @FXML
    private Button btnOK;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setAddNewOrganizationUI(AddNewOrganizationUI addNewOrganizationUI) {
        this.addNewOrganizationUI = addNewOrganizationUI;
    }

    public void showNotification(String notification) {
        this.lblNotification.setText(notification);
    }

    @FXML
    private void btnOKAction(ActionEvent event) {
        this.addNewOrganizationUI.getMainApp().toMainScene();
    }

}
