/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CheckStatisticsController;
import java.io.IOException;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Tiago
 */
public class JanelaCheckStatisticsUI {

    private JanelaOptionsCollaboratorScene_UI optionCollabUI;
    private JanelaOptionsManagerScene_UI optionsManagerUI;
    private CheckStatisticsController controller;
    private Stage statisticsStage;

    @FXML
    private ListView<TreeMap<String, Double>> lstFreelancersAndInfos;
    @FXML
    private Button btnBack;
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

    public void goToSceneAlt(JanelaOptionsCollaboratorScene_UI menuCollaboratorUI) throws IOException {
        this.optionCollabUI = menuCollaboratorUI;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JanelaCheckStatistics.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        statisticsStage = new Stage();
        statisticsStage.initModality(Modality.APPLICATION_MODAL);
        statisticsStage.setScene(scene);
        System.out.println("Será que mostrou?");
        loader.setController(this);
        statisticsStage.show();
        //setComboBoxFreelancer(transactionStage, scene);
//        transactionStage.setScene(scene);
//        transactionStage.show();
    }

    public void goToSceneAlt(JanelaOptionsManagerScene_UI menuManagerUI) throws IOException {
        this.optionsManagerUI = menuManagerUI;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JanelaCheckStatistics.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        statisticsStage = new Stage();
        statisticsStage.initModality(Modality.APPLICATION_MODAL);
        statisticsStage.setScene(scene);
        System.out.println("Será que mostrou?");
        loader.setController(this);
        statisticsStage.show();
        //setComboBoxFreelancer(transactionStage, scene);
//        transactionStage.setScene(scene);
//        transactionStage.show();
    }

    public void setController() {
        this.controller = new CheckStatisticsController();
    }

    @FXML
    private void btnBackAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/OptionsCollaborator.fxml");
    }

    public void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        //  System.out.println("Será que mostrou?");
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        //System.out.println("Vais Mostrar?");
        window.show();
    }

    @FXML
    private void meanDelayAction(ActionEvent event) {
        TreeMap<String, Double> lstMeanDelay;

    }

    @FXML
    private void btnDeviationDelayAction(ActionEvent event) {
    }

    @FXML
    private void btnDeviationPaymentAction(ActionEvent event) {
    }

    @FXML
    private void btnCleanAction(ActionEvent event) {
    }
}
