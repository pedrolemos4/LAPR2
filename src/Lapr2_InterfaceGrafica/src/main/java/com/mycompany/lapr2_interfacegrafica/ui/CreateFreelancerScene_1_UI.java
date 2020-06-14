
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreateFreelancerController;
import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
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

public class CreateFreelancerScene_1_UI implements Initializable {

    private CreateFreelancerController controller;

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtLevelOfExpertise;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNIF;
    @FXML
    private TextField txtIBAN;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtCountry;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnNext;
    @FXML
    private Label invalidLbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controller = new CreateFreelancerController();
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/OptionsCollaborator.fxml");
    }

    @FXML
    private void btnNextAction(ActionEvent event) throws IOException {
        try {
            Freelancer frl = controller.newFreelancer(this.txtNome.getText(), this.txtLevelOfExpertise.getText(),
                    this.txtEmail.getText(), this.txtNIF.getText(), this.txtIBAN.getText(),
                    this.txtCountry.getText(), this.txtAddress.getText());
            if (controller.registerFreelancer(frl)) {
                AlertUI.createAlert(Alert.AlertType.INFORMATION, "T4J-Payments",
                        "Success", "Freelancer created successfully.").show();
                goToScene(event, "/fxml/CreateFreelancer_1.fxml");
            }
        } catch (IllegalArgumentException e) {
            invalidLbl.setText(e.getMessage());
        }
    }

    public void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }

}
