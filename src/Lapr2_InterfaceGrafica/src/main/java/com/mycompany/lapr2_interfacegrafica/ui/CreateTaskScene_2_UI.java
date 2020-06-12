/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreateTaskController;
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
 * @author Tiago
 */
public class CreateTaskScene_2_UI implements Initializable {

    //  private CreateTaskUI createTaskUI;
    private CreateTaskScene_1_UI createTaskUI;
    private JanelaOptionsCollaboratorScene_UI optionsCollaborator;
    private CreateTaskController createTaskController;

    @FXML
    private Button btnCancel;
    @FXML
    private Button btnReturn;
    @FXML
    private Label lblTask;
    @FXML
    private Button btnConfirm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.createTaskController = new CreateTaskController();
    }

//    public void setCreateTaskUI(CreateTaskUI createTaskUI) {
//        this.createTaskUI = createTaskUI;
//    }
    public void showTask() {
        this.lblTask.setText(this.createTaskController.getTaskAsString());
        //this.lblTask.setText(this.createTaskUI.getController().getCategory());
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) throws IOException {
        if(this.createTaskController==null){
           
        }
        boolean registered = this.createTaskController.registerTask();
        if (registered) {
            AlertUI.createAlert(Alert.AlertType.INFORMATION, "Success", "T4J-PAYMENTS", "Task created successfully.").show();
            goToScene(event, "/fxml/OptionsCollaborator.fxml");
        } else{
            AlertUI.createAlert(Alert.AlertType.ERROR, "Error", "T4J-PAYMENTS", "Task was not registered");
            goToScene(event,"/fxml/CreateTask_1_.fxml");
        }
//            notification = "Task created with Success.";
//        } else {
//            notification = "The task was not created.";
//        }
//        this.createTaskUI.toSpecifyCategoryScene3(notification);
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
        goToScene(event,"/fxml/OptionsCollaborator.fxml");
        //    this.createTaskUI.getMainApp().toMainScene();
    }

    @FXML
    private void btnReturnAction(ActionEvent event) throws IOException {
        goToScene(event,"/fxml/CreateTask_1_.fxml");
        //     this.createTaskUI.toCreateTaskScene1();
    }

    private void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }

}
