//package com.mycompany.lapr2_interfacegrafica.ui;
//
//import com.mycompany.lapr2_interfacegrafica.controller.OrganizationRecordController;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.stage.Stage;
//
//public class AddNewOrganizationScene_2_UI implements Initializable {
//
//    private AddNewOrganizationScene_1_UI addNewOrganizationUI;
//    private JanelaOptionsAdminScene_UI janelaOptionsAdminUI;
//    private OrganizationRecordController controller;
//
//    @FXML
//    private Button btnConfirm;
//    @FXML
//    private Button btnCancel;
//    @FXML
//    private Button btnReturn;
//    @FXML
//    private Label lblOrganization;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        this.controller = new OrganizationRecordController();
//    }
//
////    public void setAddNewOrganization(AddNewOrganizationUI addNewOrganizationUI) {
////        this.addNewOrganizationUI = addNewOrganizationUI;
////    }
//
//    public void showOrganization() {
//        this.lblOrganization.setText(this.controller.getOrganizationToString());
//    }
//
//    @FXML
//    private void btnConfirmAction(ActionEvent event) throws IOException {
//        boolean registered = this.controller.registerOrganization();
//        if(registered){
//            AlertUI.createAlert(Alert.AlertType.INFORMATION, "Success", "T4J-PAYMENTS", "Organization registered successfully").show();
//            goToScene(event,"/fxml/OptionsAdmin.fxml");
//        } else{
//            AlertUI.createAlert(Alert.AlertType.ERROR, "Error", "T4J-PAYMENTS", "Organization was not registered.").show();    
//            goToScene(event,"/fxml/AddNewOrganization_1_.fxml");
//        }
////        String notification;
////        if (registered) {
////            notification = "Organization added with sucess.";
////        } else {
////            notification = "Organization was not added.";
////        }
////        this.addNewOrganizationUI.toAddNewOrganizationScene3UI(notification);
//    }
//
//    @FXML
//    private void btnCancelAction(ActionEvent event) throws IOException {
//        goToScene(event, "/fxml/OptionsAdmin.fxml");
//        //this.addNewOrganizationUI.getMainApp().toMainScene();
//    }
//
//    @FXML
//    private void btnReturnAction(ActionEvent event) throws IOException {
//
//        goToScene(event, "/fxml/AddNewOrganization_1_.fxml");
//       // this.addNewOrganizationUI.toAddNewOrganizationScene1UI();
//    }
//
//    private void goToScene(ActionEvent event, String fxml) throws IOException {
//        Parent button = FXMLLoader.load(getClass().getResource(fxml));
//        Scene buttonScene = new Scene(button);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(buttonScene);
//        window.show();
//    }
//
//}
