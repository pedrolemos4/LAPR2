
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.controller.POTApplication;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JanelaLogin_1_UI implements Initializable {

    private Stage menuAdminStage;
    private JanelaOptionsAdminScene_UI optionsAdminUI;
    private Stage menuCollaboratorStage;
    private JanelaOptionsCollaboratorScene_UI optionsCollaboratorUI;
    private Stage menuManagerStage;
    private JanelaOptionsManagerScene_UI optionsManagerUI;
    private Stage loginStage;
    private FacadeAuthorization facadeAuthorization;
    private JanelaLogin_1_UI loginUI;

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
            scene.getStylesheets().add("/styles/Styles.css");

        } catch (IOException ex) {
            AlertUI.createAlert(Alert.AlertType.ERROR, "T4J-PAYMENTS", "Error", ex.getMessage());
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
        } catch (IOException ex) {
            AlertUI.createAlert(Alert.AlertType.ERROR, "T4J-PAYMENTS", "Error", ex.getMessage());
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
        } catch (IOException ex) {
            AlertUI.createAlert(Alert.AlertType.ERROR, "T4J-PAYMENTS", "Error", ex.getMessage());
        } finally {
        }
    }

    public void setStage(Stage stage) {
        this.loginStage = stage;
        facadeAuthorization = POTApplication.getFacadeAuthorization();
    }

    public void logout() throws IOException {
        facadeAuthorization = POTApplication.getFacadeAuthorization();
        facadeAuthorization.doLogout();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginWindow.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            loginStage = new Stage();
            loginStage.initModality(Modality.APPLICATION_MODAL);
            loginStage.setResizable(false);
            loginStage.setScene(scene);
            loginUI = loader.getController();
            loginUI.setNewLoginUI(this);
            loginStage.show();
        } catch (IOException ex) {
            AlertUI.createAlert(Alert.AlertType.ERROR, "T4J-Payments", "Error", ex.getMessage());
        }
    }

    @FXML
    private void btnLoginAction(ActionEvent event) throws IOException {
        String email = this.txtEmail.getText();
        String password = this.txtPassword.getText();
        if (POTApplication.getFacadeAuthorization().doLogin(email, password)) {
            switch (POTApplication.getFacadeAuthorization().getCurrentSession().getUser().getRole()) {
                case "ADMINISTRATOR":
                    goToScene(event, "/fxml/OptionsAdmin.fxml");
                    break;
                case "ORGANIZATION_COLLABORATOR":
                    goToScene(event, "/fxml/OptionsCollaborator.fxml");
                    break;
                case "ORGANIZATION_MANAGER":
                    goToScene(event, "/fxml/OptionsManager.fxml");
                    break;
            }
        }
    }

    @FXML
    private void txtEmailKeyPressed(KeyEvent event
    ) {
    }

    public void goToScene(ActionEvent event, String fxml) throws IOException {
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

    public void setNewLoginUI(JanelaLogin_1_UI janelaLoginUI) {
        this.loginUI = janelaLoginUI;
    }
}
