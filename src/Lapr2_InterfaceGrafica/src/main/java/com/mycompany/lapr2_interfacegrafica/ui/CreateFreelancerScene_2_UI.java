/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Tiago
 */
public class CreateFreelancerScene_2_UI {
    
    public CreateFreelancerUI freel;

    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnReturn;
    @FXML
    private Label lblFreelancer;
    
    
    public CreateFreelancerScene_2_UI(){
        setFreelancer(freel);
    }
    
    public void setFreelancer(CreateFreelancerUI freel){
       this.freel=freel;
    }
    
    public void showFreelancer(){
        this.lblFreelancer.setText(this.freel.getCreateFreelancerController().getFreelancerString());
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) {
//        boolean registered = this.freel.getCreateFreelancerController().registerFreelancer();
        String notification;
        if (freel.getCreateFreelancerController().registerFreelancer()==true) {
            notification = "Specify Category Success.";
        } else {
            notification = "Specify Category Insuccess.";
        }
        this.freel.toCreateFreelancerScene3UI(notification);
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
        //this.freel.getMainApp().toMainScene();
    }

    @FXML
    private void btnReturnAction(ActionEvent event) {
        this.freel.toCreateFreelancerScene1UI(); 
    }
    
}
