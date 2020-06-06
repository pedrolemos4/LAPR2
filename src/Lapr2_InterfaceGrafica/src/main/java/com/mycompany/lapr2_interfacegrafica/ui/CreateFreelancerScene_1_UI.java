/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Tiago
 */
public class CreateFreelancerScene_1_UI {
    
    private CreateFreelancerUI freel;
    
    private JanelaOptionsCollaboratorUI optCollab;

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
    @FXML
    private TextField txtId;
    
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
    private void btnCancelAction(ActionEvent event) {
        try {
            this.freel.getCreateFreelancerController().newFreelancer(txtId.getText(), txtNome.getText(), txtLevelOfExpertise.getText(), txtEmail.getText(), txtNIF.getText(), txtIBAN.getText(), txtCountry.getText(), txtAddress.getText());
        } catch(IllegalArgumentException e) {
            
        }
    }

    @FXML
    private void btnNextAction(ActionEvent event) {
    }
    
}
