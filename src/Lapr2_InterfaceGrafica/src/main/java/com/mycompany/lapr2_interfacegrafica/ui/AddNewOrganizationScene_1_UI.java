package com.mycompany.lapr2_interfacegrafica.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

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

    public void addNewOrganization(AddNewOrganizationUI addNewOrganization) {
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
    private void btnNextAction(ActionEvent event) {
        try {
            this.addNewOrganization.getOrganizationRecordController().newOrganization(txtName.getText(),
                    txtNIF.getText(), txtManagerName.getText(), txtManagerEmail.getText(), txtCollaboratorName.getText(), txtCollaboratorEmail.getText());
            this.addNewOrganization.toAddNewOrganizationScene2UI();
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
    private void btnCancelAction(ActionEvent event) {
        this.addNewOrganization.getMainApp().toMainScene();
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

}
