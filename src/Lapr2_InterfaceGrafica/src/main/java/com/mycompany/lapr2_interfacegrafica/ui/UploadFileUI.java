package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.UploadFileController;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UploadFileUI implements Initializable {
   private  UploadFileController controller;
    
    @FXML
    private Label lblUploadFile;
    @FXML
    private Button btnImportTxt;
    @FXML
    private Button btnImportCsv;
    @FXML
    private Button btnClean;
    @FXML
    private ListView<PaymentTransaction> lstPaymentTransactions;
    @FXML
    private Button btnReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new UploadFileController();
    }
    
    @FXML
    private void importTxtAction(ActionEvent event) {
        FileChooser flChooser = FileChooserUI.criarFileChooser();
        File file = flChooser.showOpenDialog(lstPaymentTransactions.getScene().getWindow());
        if (file != null) {
            lstPaymentTransactions.getItems().clear();
            controller.getFileTxt(file);
            addTransactions();
        }
    }

    @FXML
    private void importCsvAction(ActionEvent event) {
        FileChooser flChooser = FileChooserUI.criarFileChooser();
        File file = flChooser.showOpenDialog(lstPaymentTransactions.getScene().getWindow());
        if (file != null) {
            lstPaymentTransactions.getItems().clear();
            controller.getFileCsv(file);
            addTransactions();
        }
    }
    
    public void addTransactions(){
        lstPaymentTransactions.getItems().setAll(controller.getTransactions());
    }

    @FXML
    private void cleanAction(ActionEvent event) {
        lstPaymentTransactions.getItems().clear();  
    }
    
    public void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }

    @FXML
    private void returnAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/OptionsCollaborator.fxml");
    }
}
