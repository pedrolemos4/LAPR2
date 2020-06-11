/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.controller.POTApplication;
import com.mycompany.lapr2_interfacegrafica.model.Constants;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Tiago
 */
public class JanelaLogin_1_UI implements Initializable {

    //private MainApp mainApp;
    private Stage menuAdminStage;
    private JanelaOptionsAdminScene_UI optionsAdminUI;
    private Stage menuCollaboratorStage;
    private JanelaOptionsCollaboratorScene_UI optionsCollaboratorUI;
    private Stage menuManagerStage;
    private JanelaOptionsManagerScene_UI optionsManagerUI;
    private Stage loginStage;
    private FacadeAuthorization facadeAuthorization;

    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OptionsAdmin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            menuAdminStage = new Stage();
            menuAdminStage.initModality(Modality.APPLICATION_MODAL);
            menuAdminStage.setTitle("Administrator");
            menuAdminStage.setResizable(false);
            menuAdminStage.setScene(scene);
            optionsAdminUI = loader.getController();
            optionsAdminUI.setNewOptionsAdminUI(this);
            menuAdminStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                @Override
                public void handle(WindowEvent event) {
                    logout();
                }
                
            });

            scene.getStylesheets().add("/styles/Styles.css");

        } catch (IOException ex) {
            AlertUI.createAlert(Alert.AlertType.ERROR, "Error", "T4J-PAYMENTS", ex.getMessage());
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OptionsCollaborator.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            menuCollaboratorStage = new Stage();
            menuCollaboratorStage.initModality(Modality.APPLICATION_MODAL);
            menuCollaboratorStage.setTitle("Collaborator");
            menuCollaboratorStage.setResizable(false);
            menuCollaboratorStage.setScene(scene);
            optionsCollaboratorUI = loader.getController();
            optionsCollaboratorUI.setNewOptionsCollaboratorUI(this);
            menuCollaboratorStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                @Override
                public void handle(WindowEvent event) {
                    logout();
                }
                
            });

        } catch (IOException ex) {
            AlertUI.createAlert(Alert.AlertType.ERROR, "Error", "T4J-Payments", ex.getMessage());
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OptionsManager.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            menuManagerStage = new Stage();
            menuManagerStage.initModality(Modality.APPLICATION_MODAL);
            menuManagerStage.setTitle("Manager");
            menuManagerStage.setResizable(false);
            menuManagerStage.setScene(scene);
            optionsManagerUI = loader.getController();
            optionsManagerUI.setNewOptionsManagerUI(this);
            menuManagerStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                @Override
                public void handle(WindowEvent event) {
                    logout();
                }
                
            });
        } catch(IOException ex){
            AlertUI.createAlert(Alert.AlertType.ERROR, "Error", "T4J-PAYMENTS", ex.getMessage());
        } finally{
        }
//        this.btnLogin.setDisable(POTApplication.getInstance().getPlataforma().
//                getOrganizationsRecord().getOrganizations().isEmpty());
    }

     public void setStage(Stage stage) {
        this.loginStage = stage;
        facadeAuthorization = POTApplication.getFacadeAuthorization();
    }
     
    public void logout(){
        facadeAuthorization.doLogout();
        loginStage.show();
    }
//    public void setMainApp(MainApp mainApp) {
//        this.mainApp = mainApp;
//    }
    @FXML
    private void btnLoginAction(ActionEvent event) throws IOException {
        String email = this.txtEmail.getText();
        String password = this.txtPassword.getText();
        if (POTApplication.getFacadeAuthorization().doLogin(email, password)) {
           // String role = POTApplication.getFacadeAuthorization().getCurrentSession().getUser().getRoles();
            switch (POTApplication.getFacadeAuthorization().getCurrentSession().getUser().getRole())   {
                case Constants.ADMINISTRATOR_ROLE:
                    goToScene(event, "/fxml/OptionsAdmin.fxml");
                    break;
                case Constants.ORGANIZATION_COLLABORATOR_ROLE:
                    goToScene(event, "/fxml/OptionsCollaborator.fxml");
                    break;
                case Constants.ORGANIZATION_MANAGER_ROLE:
                    goToScene(event, "/fxml/OptionsManager.fxml");
                    break;
            }
        }
//        JanelaOptionsAdminUI jOAUI = new JanelaOptionsAdminUI(this.mainApp);
//        //jOAUI.toMenuAdminScene();
//        JanelaOptionsCollaboratorUI jOCUI = new JanelaOptionsCollaboratorUI(this.mainApp);
//        jOCUI.toMenuCollaboratorScene();
//        //JanelaOptionsManagerUI jOMUI = new JanelaOptionsManagerUI(this.mainApp);
//        //jOMUI.toMenuManagerScene();
    }

    @FXML
    private void txtEmailKeyPressed(KeyEvent event) {
    }

    private void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }

    public void serializeData() throws FileNotFoundException, IOException {
        ObjectOutputStream loginData = new ObjectOutputStream(new FileOutputStream("LoginData.bin"));
        loginData.writeObject(POTApplication.getFacadeAuthorization());
        ObjectOutputStream platData = new ObjectOutputStream(new FileOutputStream("PlatformData.bin"));
        platData.writeObject(POTApplication.getPlatform());

    }
}
