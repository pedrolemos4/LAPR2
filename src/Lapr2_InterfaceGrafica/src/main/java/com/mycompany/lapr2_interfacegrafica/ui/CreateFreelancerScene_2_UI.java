/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreateFreelancerController;
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

/**
 *
 * @author pedro
 */
public class CreateFreelancerScene_2_UI implements Initializable{

    
    private static final String TITULO_APLICACAO="Pray4Us";
    
    public CreateFreelancerUI freel;
    public CreateFreelancerController controller;

    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnReturn;
    @FXML
    private Label lblFreelancer;

//    public void setFreelancer(CreateFreelancerUI freel) {
//        this.freel = freel;
//    }

    public void showFreelancer() {
        this.lblFreelancer.setText(controller.getFreelancerString());
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) throws IOException {
        String notification;
        if (controller.registerFreelancer()) {
            notification = "Specify Category Success.";
        } else {
            notification = "Specify Category Insuccess.";
        }
        goToScene(event,"/fxml/CreateFreelancer_3.fxml",notification);        
//        this.freel.toCreateFreelancerScene3UI(notification);
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
        //this.freel.getMainApp().toMainScene();
    }

    @FXML
    private void btnReturnAction(ActionEvent event) {
        this.freel.toCreateFreelancerScene1UI();
    }

    private void goToScene(ActionEvent event, String fxml, String not) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AlertUI.createAlert(Alert.AlertType.CONFIRMATION, TITULO_APLICACAO, "Arroz", not);
        window.setScene(buttonScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controller = new CreateFreelancerController();
    }

}
