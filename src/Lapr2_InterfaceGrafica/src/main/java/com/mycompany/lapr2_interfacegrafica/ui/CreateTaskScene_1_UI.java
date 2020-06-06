
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

/**
 *
 * @author Tiago
 */
public class CreateTaskScene_1_UI implements Initializable {

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
    }

    public TextField getTaskID() {
        return this.txtTaskID;
    }

//    public void setCreateTask(CreateTaskUI createTaskUI) {
//        this.createTaskUI = createTaskUI;
//    }

    public void showTask() {
//        this.txtTaskID.setText(this.createTaskUI.getController().getTaskId());
//        this.txtTaskDescription.setText(this.createTaskUI.getController().getTaskDescription);
//        this.txtTimeDuration.setText(this.createTaskUI.getController().getTimeDuration);
//        this.txtCostPerHour.setText(this.createTaskUI.getController().getCostPerHour);
//        this.txtTaskCategory.setText(this.createTaskUI.getController().getTaskCategory);
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
   //     this.createTaskUI.getMainApp().toMainScene();
    }

    @FXML
    private void btnNextAction(ActionEvent event) {
        try {
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

}
