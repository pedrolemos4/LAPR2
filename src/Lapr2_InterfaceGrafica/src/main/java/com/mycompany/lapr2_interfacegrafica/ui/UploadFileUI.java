package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author beatr
 */
public class UploadFileUI implements Initializable {

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

    @FXML
    private void importTxtAction(ActionEvent event) {
    }

    @FXML
    private void importCsvAction(ActionEvent event) {
    }

    @FXML
    private void cleanAction(ActionEvent event) {
        lstPaymentTransactions.getItems().clear();  
    }
    
}
