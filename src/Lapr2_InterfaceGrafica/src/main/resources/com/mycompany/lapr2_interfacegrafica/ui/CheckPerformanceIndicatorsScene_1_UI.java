/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author beatr
 */
public class CheckPerformanceIndicatorsScene_1_UI implements Initializable {

    @FXML
    private Label lblCheckPerformance;
    @FXML
    private Button btnMeanDelay;
    @FXML
    private Button btnDeviationDelay;
    @FXML
    private Button btnMeanPayment;
    @FXML
    private Button btnDeviationPayment;
    @FXML
    private Button btnClean;
    @FXML
    private Label lblProbability;
    @FXML
    private TextField txtNormalDistribution;
    @FXML
    private ListView<?> lstFreelancerAndInfo;
    @FXML
    private BarChart<?, ?> barChartHistograms;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void meanDelay(ActionEvent event) {
    }

    @FXML
    private void deviationDelay(ActionEvent event) {
    }

    @FXML
    private void meanPayment(ActionEvent event) {
    }

    @FXML
    private void deviationPayment(ActionEvent event) {
    }

    @FXML
    private void cleanAll(ActionEvent event) {
    }

    @FXML
    private void normalDistribution(ActionEvent event) {
    }
    
}
