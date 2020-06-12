package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreatePaymentTransactionController;
import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.Task;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class PaymentTransactionScene_1_UI implements Initializable {

    private JanelaOptionsAdminScene_UI optionsAdminUI;
    private CreatePaymentTransactionController controller;

    @FXML
    private Button btnNext;
    @FXML
    private Button btnCancel;
    @FXML
    private Label lblAlert;
    @FXML
    private TextField txtTaskEndDate;
    @FXML
    private TextField txtTaskDelay;
    @FXML
    private TextField txtWorkDescription;
    @FXML
    private ComboBox<Task> cmbTask;
    @FXML
    private ComboBox<Freelancer> cmbFreelancer;
    @FXML
    private TextField txtTransactionID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controller = new CreatePaymentTransactionController();
        for (Freelancer frl : controller.getFreelancers()) {
           cmbFreelancer.getItems().add(frl);
        }
        for (Task task : controller.getTasks()) {
            cmbTask.getItems().add(task);
        }
    }

//    public void setPaymentTransactionUI(CreatePaymentTransactionUI createPaymentTransactionUI) {
//        this.createPaymentTransactionUI = createPaymentTransactionUI;
//    }
    public void initComboBox() {
//        CreatePaymentTransactionController controller = this.createPaymentTransactionUI.
//                getCreatePaymentTransactionController();
//        ObservableList<String> tasks
//                = FXCollections.observableArrayList(controller.getTasks());
//        this.cmbTask.setItems(tasks);
//        ObservableList<String> freelancers
//                = FXCollections.observableArrayList(controller.getFreelancers());
//        this.cmbFreelancer.setItems(freelancers);
    }

    public void showTransaction() {
//        this.txtTransactionID.setText(this.controller.getPayTId());
//        this.cmbTask.setValue(this.controller.getTask());
//        this.txtTaskDelay.setText(this.controller.getTaskDelay());
//        this.txtTaskEndDate.setText(this.controller.getEndDate());
//        this.txtWorkDescription.setText(this.controller.getWorkDescription());
//        this.cmbFreelancer.setValue(this.controller.getFreelancer());
    }

    @FXML
    private void btnNextAction(ActionEvent event) throws IOException {
        try {
            String payTId = this.txtTransactionID.getText();
            String endDate = this.txtTaskEndDate.getText();
            int taskDelay = Integer.parseInt(this.txtTaskDelay.getText());
            String workDescription = this.txtWorkDescription.getText();
            Task task = this.cmbTask.getSelectionModel().getSelectedItem();
            Freelancer freelancer = this.cmbFreelancer.getSelectionModel().getSelectedItem();
            controller.newPaymentTransaction(payTId, task, endDate, taskDelay, workDescription, freelancer);
            goToScene(event, "/fxml/PaymentTransaction_2.fxml");
//            this.createPaymentTransactionUI.getCreatePaymentTransactionController().newPaymentTransaction(payTId, task, endDate,
//                    taskDelay, workDescription, freelancer);
//            this.createPaymentTransactionUI.toPaymentTransactionScene2UI();
        } catch (NumberFormatException ex) {
            this.lblAlert.setText("Invalid number!");
            this.txtTaskDelay.requestFocus();
        } catch (IllegalArgumentException ex) {
            this.lblAlert.setText(ex.getMessage());
            if (ex.getMessage().toLowerCase().contains("work")) {
                this.txtWorkDescription.requestFocus();
            } else if (ex.getMessage().toLowerCase().contains("task")) {
                this.cmbTask.requestFocus();
            } else {
                this.cmbFreelancer.requestFocus();
            }
        }
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/OptionsCollaborator.fxml");
        //this.createPaymentTransactionUI.getMainApp().toMainScene();
    }

    @FXML
    private void txtTaskEndDateKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtTaskDelayKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtWorkDescriptionKeyPressed(KeyEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void cmbTaskAction(ActionEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void cmbFreelancerAction(ActionEvent event) {
        this.lblAlert.setText(null);
    }

    @FXML
    private void txtTransactionIDKeyPressed(KeyEvent event) {
    }

    public void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }

}
