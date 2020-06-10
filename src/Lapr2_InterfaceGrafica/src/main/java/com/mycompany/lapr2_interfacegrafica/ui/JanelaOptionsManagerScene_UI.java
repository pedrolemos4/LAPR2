/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author Tiago
 */
public class JanelaOptionsManagerScene_UI implements Initializable {

    private MainApp mainApp;
    private JanelaCheckStatisticsUI statisticsUI;
    private SetDayOfPaymentScene_1_UI setDayPaymentScene1;

    private JanelaLogin_1_UI janelaLoginUI;

    @FXML
    private Button btnCheckStatistics;
    @FXML
    private Button btnSetDayOfPayment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setNewOptionsManagerUI(JanelaLogin_1_UI janelaLoginUI) {
        this.janelaLoginUI = janelaLoginUI;
    }

    @FXML
    private void btnSetDayOfPaymentAction(ActionEvent event) throws IOException {
        if (setDayPaymentScene1 == null) {
            setDayPaymentScene1 = new SetDayOfPaymentScene_1_UI();
        }
        setDayPaymentScene1.goToScene(event, "/fxml/SetDayOfPaymentScene.fxml");
    }

    @FXML
    private void btnCheckStatisticsAction(ActionEvent event) throws IOException {
        if (statisticsUI == null) {
            statisticsUI = new JanelaCheckStatisticsUI();
        }
        statisticsUI.goToScene(event, "/fxml/JanelaCheckStatistics.fxml");
    }

}
