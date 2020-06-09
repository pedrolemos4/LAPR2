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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AddNewOrganizationScene_1_UI implements Initializable {

    private AddNewOrganizationUI addNewOrganization;

    @FXML
    private Button btnCancel;
    @FXML
    private Label lblAlert;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtNIF;
    @FXML
    private Button btnNext;
    @FXML
    private TextField txtManagerName;
    @FXML
    private TextField txtManagerEmail;
    @FXML
    private TextField txtCollaboratorName;
    @FXML
    private TextField txtCollaboratorEmail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public TextField getTxtName() {
        return this.txtName;
    }

    public void setNewOrganizationUI(AddNewOrganizationUI addNewOrganization) {
        this.addNewOrganization = addNewOrganization;
    }

    public void showOrganization() {
        this.txtName.setText(this.addNewOrganization.getOrganizationRecordController().getOrganizationName());
        this.txtNIF.setText(this.addNewOrganization.getOrganizationRecordController().getOrganizationNIF());
        this.txtManagerName.setText(this.addNewOrganization.getOrganizationRecordController().getOrganization().getManager().getName());
        this.txtManagerEmail.setText(this.addNewOrganization.getOrganizationRecordController().getOrganization().getManager().getEmail());
        this.txtCollaboratorName.setText(this.addNewOrganization.getOrganizationRecordController().getOrganization().getCollaborator().getName());
        this.txtCollaboratorEmail.setText(this.addNewOrganization.getOrganizationRecordController().getOrganization().getCollaborator().getEmail());
    }

    @FXML
    private void btnNextAction(ActionEvent event) throws IOException {
//        if(addNewOrganization==null){
//            addNewOrganization= new AddNewOrganizationUI();
//        }
        try {
            System.out.println("zlkfjalkdfjalk");
//            this.addNewOrganization.getOrganizationRecordController().newOrganization(this.txtName.getText(),
//                    this.txtNIF.getText(), this.txtManagerName.getText(),
//                    this.txtManagerEmail.getText(), this.txtCollaboratorName.getText(),
//                    this.txtCollaboratorEmail.getText());
            goToScene(event, "/fxml/AddNewOrganization_2.fxml");
        } catch (IllegalArgumentException ex) {
            lblAlert.setText(ex.getMessage());
            if (ex.getMessage().toLowerCase().contains("name")) {
                txtName.requestFocus();
            } else if (ex.getMessage().toLowerCase().contains("NIF")) {
                txtNIF.requestFocus();
            } else if (ex.getMessage().toLowerCase().contains("manager's name")) {
                txtManagerName.requestFocus();
            } else if (ex.getMessage().toLowerCase().contains("manager's email")) {
                txtManagerEmail.requestFocus();
            } else if (ex.getMessage().toLowerCase().contains("collaborator's name")) {
                txtCollaboratorName.requestFocus();
            } else {
                txtCollaboratorEmail.requestFocus();
            }
        }
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
        goToScene(event,"/fxml/JanelaLogin.fxml");
        //this.addNewOrganization.getMainApp().toMainScene();
    }

    @FXML
    private void txtNameKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtNIFKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtManagerNameKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtManagerEmailKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtCollaboratorNameKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtCollaboratorEmailKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    
     private void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }
}
