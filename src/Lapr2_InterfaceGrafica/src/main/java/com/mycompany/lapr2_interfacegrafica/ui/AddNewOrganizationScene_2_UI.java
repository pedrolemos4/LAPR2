package com.mycompany.lapr2_interfacegrafica.ui;

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
import javafx.stage.Stage;

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
      //  showOrganization();
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
    private void btnCancelAction(ActionEvent event) throws IOException {
        goToScene(event,"/fxml/JanelaLogin.fxml");
        //this.addNewOrganizationUI.getMainApp().toMainScene();
    }

    @FXML
    private void btnReturnAction(ActionEvent event) throws IOException {
        goToScene(event,"/fxml/AddNewOrganization_1_.fxml");
        //this.addNewOrganizationUI.toAddNewOrganizationScene1UI();
    }
    
    private void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }

}
