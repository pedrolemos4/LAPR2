/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreateFreelancerController;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Tiago
 */
public class CreateFreelancerScene_1_UI implements Initializable {
    
    private CreateFreelancerUI freel;
    private CreateFreelancerController controller;

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtLevelOfExpertise;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNIF;
    @FXML
    private TextField txtIBAN;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtCountry;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnNext;
    private TextField txtId;
    @FXML
    private Label invalidLbl;
    
    // Get methods
    // <editor-fold defaultstate="collapsed">
    
    public TextField getNome(){
        return this.txtNome;
    }
    
    public TextField getLvlExp(){
        return this.txtLevelOfExpertise;
    }
    
    public TextField getEmail(){
        return this.txtEmail;
    }
    
    public TextField getNif(){
        return this.txtNIF;
    }
    
    public TextField getIban(){
        return this.txtIBAN;
    }
    
    public TextField getAdress(){
        return this.txtAddress;
    }
    
    public TextField getCountry(){
        return this.txtCountry;
    }
    
    // </editor-fold> 
    
    public void setFreelancer(CreateFreelancerUI freel){
        this.freel=freel;
    }
    
    public void showFreelancer(){
        this.txtId.setText(this.freel.getCreateFreelancerController().freel.getId());
        this.txtNome.setText(this.freel.getCreateFreelancerController().freel.getName());
        this.txtAddress.setText(this.freel.getCreateFreelancerController().freel.getAdress());
        this.txtCountry.setText(this.freel.getCreateFreelancerController().freel.getCountry());
        this.txtEmail.setText(this.freel.getCreateFreelancerController().freel.getEmail());
        this.txtLevelOfExpertise.setText(this.freel.getCreateFreelancerController().freel.getLvlExp());
        this.txtNIF.setText(this.freel.getCreateFreelancerController().freel.getNif());
        this.txtIBAN.setText(this.freel.getCreateFreelancerController().freel.getIban());
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
       goToScene(event,"/fxml/JanelaLogin.fxml");
       //this.freel.getMainApp().toMainScene();
    }

    @FXML
    private void btnNextAction(ActionEvent event) throws IOException {
        try {
            String name = this.txtNome.getText();
            String lvlExp =  this.txtLevelOfExpertise.getText();
            String email = this.txtEmail.getText();
            String nif = this.txtNIF.getText();
            String iban = this.txtIBAN.getText();
            String country = this.txtCountry.getText();
            String adress = this.txtAddress.getText();
            controller.newFreelancer(name, lvlExp, email, nif, iban, country, adress);
            goToScene(event,"/fxml/CreateFreelancer_2.fxml");
           // this.freel.toCreateFreelancerScene2UI();
        } catch(IllegalArgumentException e) {
            invalidLbl.setText(e.getMessage());
        }
    }
    
     private void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controller = new CreateFreelancerController();
    }
}
