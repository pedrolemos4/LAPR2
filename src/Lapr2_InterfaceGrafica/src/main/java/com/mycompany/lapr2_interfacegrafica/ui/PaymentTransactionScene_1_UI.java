package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreatePaymentTransactionController;
import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.Task;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PaymentTransactionScene_1_UI implements Initializable {

    private JanelaOptionsCollaboratorScene_UI optionCollabUI;
    private CreatePaymentTransactionController controller;
    private Stage transactionStage;
    private static Freelancer frl;
    private static Task task;

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
    }

    public void setComboBoxFreelancer(Stage stage, Scene scene) throws IOException {
        this.controller = new CreatePaymentTransactionController();

        List<Task> tasks = controller.getTasks();
        this.cmbTask = new ComboBox(FXCollections.observableArrayList(controller.getTasks()));
        this.cmbFreelancer = new ComboBox(FXCollections.observableArrayList(controller.getFreelancers()));

        TilePane tile_pane = new TilePane(cmbTask, cmbFreelancer);
        Scene scene2 = new Scene(tile_pane, 400, 400);
        transactionStage.setScene(scene2);
        transactionStage.showAndWait();
        frl = cmbFreelancer.getSelectionModel().getSelectedItem();
        task = cmbTask.getSelectionModel().getSelectedItem();
        transactionStage.setScene(scene);
        transactionStage.show();
    }

    public void setComboBoxTask() {
        this.cmbTask = new ComboBox(FXCollections.observableArrayList(controller.getTasks()));
        TilePane tile_pane = new TilePane(cmbTask);
        Scene scene = new Scene(tile_pane, 400, 400);
        transactionStage.setScene(scene);
        transactionStage.show();
    }

    @FXML
    private void btnNextAction(ActionEvent event) throws IOException {
        try {
            controller = new CreatePaymentTransactionController();
            String payTId = this.txtTransactionID.getText();
            String endDate = this.txtTaskEndDate.getText();
            int taskDelay = Integer.parseInt(this.txtTaskDelay.getText());
            String workDescription = this.txtWorkDescription.getText();
            controller.newPaymentTransaction(payTId, task,
                    endDate, taskDelay, workDescription, frl);
            boolean registered = this.controller.paymentTransactionRegister();
            if (registered) {
                AlertUI.createAlert(Alert.AlertType.INFORMATION, "T4J-PAYMENTS", "Success",
                        "Payment Transaction registered successfully").show();
                goToScene(event, "/fxml/OptionsCollaborator.fxml");
            } else {
                AlertUI.createAlert(Alert.AlertType.ERROR, "T4J-PAYMENTS", "Error",
                        "Payment Transaction was not registered.").show();
                goToScene(event, "/fxml/PaymentTransaction_1.fxml");
            }
        } catch (NumberFormatException ex) {
            this.lblAlert.setText("Invalid delay!");
            this.txtTaskDelay.requestFocus();
        }
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/OptionsCollaborator.fxml");
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

    public void goToSceneAlt(JanelaOptionsCollaboratorScene_UI menuCollaboratorUI) throws IOException {
        this.optionCollabUI = menuCollaboratorUI;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PaymentTransaction_1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        transactionStage = new Stage();
        transactionStage.initModality(Modality.APPLICATION_MODAL);
        transactionStage.setScene(scene);
        loader.setController(this);
        setComboBoxFreelancer(transactionStage, scene);
    }

}
