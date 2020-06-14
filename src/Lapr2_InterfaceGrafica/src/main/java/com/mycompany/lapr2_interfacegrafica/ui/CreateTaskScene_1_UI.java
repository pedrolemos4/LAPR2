package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreateTaskController;
import com.mycompany.lapr2_interfacegrafica.model.Task;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Tiago
 */
public class CreateTaskScene_1_UI implements Initializable {

    private JanelaOptionsCollaboratorScene_UI optionsCollaboratorUI;

    private CreateTaskController createTaskController;

    //  private CreateTaskUI createTaskUI;
    @FXML
    private TextField txtTaskID;
    @FXML
    private TextField txtTaskDescription;
    @FXML
    private TextField txtTimeDuration;
    @FXML
    private TextField txtCostPerHour;
    @FXML
    private TextField txtTaskCategory;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnNext;
    @FXML
    private Label lblAlert;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.createTaskController = new CreateTaskController();
    }

    public TextField getTaskID() {
        return this.txtTaskID;
    }

//    public void setCreateTask(CreateTaskUI createTaskUI) {
//        this.createTaskUI = createTaskUI;
//    }
    public void showTask() {
//        this.txtTaskID.setText(this.createTaskController.getTaskId());
//        this.txtTaskDescription.setText(this.createTaskController.getTaskDescription);
//        this.txtTimeDuration.setText(this.createTaskController.getTimeDuration);
//        this.txtCostPerHour.setText(this.createTaskController.getCostPerHour);
//        this.txtTaskCategory.setText(this.createTaskController.getTaskCategory);
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/OptionsCollaborator.fxml");
        //     this.createTaskUI.getMainApp().toMainScene();
    }

    @FXML
    private void btnNextAction(ActionEvent event) throws IOException {
        try {
            Task task = createTaskController.newTask(txtTaskID.getText(), txtTaskDescription.getText(),
                    Integer.parseInt(txtTimeDuration.getText()), Double.parseDouble(txtCostPerHour.getText()),
                    txtTaskCategory.getText());
            boolean registered = this.createTaskController.registerTask(task);
            if (registered) {
                AlertUI.createAlert(Alert.AlertType.INFORMATION,"T4J-PAYMENTS", 
                        "Success", "Task created successfully.").show();
                goToScene(event, "/fxml/OptionsCollaborator.fxml");
            } else {
                AlertUI.createAlert(Alert.AlertType.ERROR, "T4J-PAYMENTS" ,"Error",
                        "Task was not registered").show();
                goToScene(event, "/fxml/CreateTask_1_.fxml");
            }
            //goToScene(event,"/fxml/CreateTask_2.fxml");
//            this.createTaskUI.getController().newTask(txtTaskID.getText(), txtTaskDescription.getText(),
//                    txtTimeDuration.getText(), txtCostPerHour.getText(), txtTaskCategory.getText());
//            this.createTaskUI.toCreateTaskScene2();
        } catch (IllegalArgumentException ex) {
            lblAlert.setText(ex.getMessage());
            if (ex.getMessage().toLowerCase().contains(" id")) {
                txtTaskID.requestFocus();
            } else if (ex.getMessage().toLowerCase().contains(" description")) {
                txtTaskDescription.requestFocus();
            } else if (ex.getMessage().toLowerCase().contains("?")) {
                txtTimeDuration.requestFocus();
            } else if (ex.getMessage().toLowerCase().contains("?")) {
                txtCostPerHour.requestFocus();
            } else {
                txtTaskCategory.requestFocus();
            }
        }
    }

    @FXML
    private void txtTaskIDKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtTaskDescriptionKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);

    }

    @FXML
    private void txtTimeDurationKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtCostPerHourKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtTaskCategoryKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    public void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }

}
