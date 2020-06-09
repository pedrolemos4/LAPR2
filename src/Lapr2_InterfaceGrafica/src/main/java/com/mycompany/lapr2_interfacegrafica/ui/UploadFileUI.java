package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.UploadFileController;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author beatr
 */
public class UploadFileUI implements Initializable {
    private final MainApp mainApp;
    private final UploadFileController controller;
    
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public UploadFileUI(MainApp mainApp) {
        this.mainApp = mainApp;
        this.controller = new UploadFileController();
    }

    public MainApp getMainApp() {
        return this.mainApp;
    }

    public UploadFileController getOrganizationRecordController() {
        return this.controller;
    }

    @FXML
    private void importTxtAction(ActionEvent event) {
        FileChooser flChooser = FileChooserUI.criarFileChooser();
        File file = flChooser.showOpenDialog(lstPaymentTransactions.getScene().getWindow());
        if (file != null) {
            lstPaymentTransactions.getItems().clear();
//            if (controller.getFileTxt(file)) {
                lstPaymentTransactions.getItems().setAll(controller.getTransactions());
//            }
        }
    }

    @FXML
    private void importCsvAction(ActionEvent event) {
        FileChooser flChooser = FileChooserUI.criarFileChooser();
        File file = flChooser.showOpenDialog(lstPaymentTransactions.getScene().getWindow());
        if (file != null) {
            lstPaymentTransactions.getItems().clear();
//            if (controller.getFileCsv(file)) {
                addTransactions();
//            }
        }
    }
    
    public void addTransactions(){
        lstPaymentTransactions.getItems().setAll(controller.getTransactions());
    }

    @FXML
    private void cleanAction(ActionEvent event) {
        lstPaymentTransactions.getItems().clear();  
    }
    
}