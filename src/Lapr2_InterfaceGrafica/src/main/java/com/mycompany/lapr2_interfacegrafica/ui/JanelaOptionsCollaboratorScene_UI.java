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
import javafx.stage.Stage;

/**
 *
 * @author pedro
 */
public class JanelaOptionsCollaboratorScene_UI implements Initializable {

    private MainApp mainApp;

    private JanelaLogin_1_UI janelaLoginUI;

    @FXML
    private Button btnCreateTask;
    @FXML
    private Button btnCreatePayment;
    @FXML
    private Button btnUploadFile;
    @FXML
    private Button btnCheckStatistics;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnCreateFreelancer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setNewOptionsCollaboratorUI(JanelaLogin_1_UI janelaLoginUI) {
        this.janelaLoginUI = janelaLoginUI;
    }

    @FXML
    private void btnCreateFreelanceerAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/CreateFreelancer_1.fxml");
//        Parent createFreelancer = FXMLLoader.load(getClass().getResource("/fxml/CreateFreelancer_1.fxml"));
//        Scene createFreelancerScene = new Scene(createFreelancer);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(createFreelancerScene);
//        window.show();
//        //CreateFreelancerUI createFreelancerUI = new CreateFreelancerUI(this.mainApp);
        //createFreelancerUI.toCreateFreelancerScene1UI();
    }

    @FXML
    private void btnCreateTaskAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/CreateTask_1_.fxml");
//        Parent createTask = FXMLLoader.load(getClass().getResource("/fxml/CreateTask_1_.fxml"));
//        Scene createTaskScene = new Scene(createTask);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(createTaskScene);
//        window.show();
//        // CreateTaskUI createTaskUI = new CreateTaskUI(this.mainApp);
        // createTaskUI.toCreateTaskScene1UI();
    }

    @FXML
    private void btnCreatePaymentAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/PaymentTransaction_1.fxml");
    }

    @FXML
    private void btnUploadFileAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/UploadFIle.fxml");
    }

    @FXML
    private void btnCheckStatisticsAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/JanelaCheckStatistics.fxml");
    }

    @FXML
    private void btnLogoutAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/JanelaLogin.fxml");
    }

    private void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }

}
