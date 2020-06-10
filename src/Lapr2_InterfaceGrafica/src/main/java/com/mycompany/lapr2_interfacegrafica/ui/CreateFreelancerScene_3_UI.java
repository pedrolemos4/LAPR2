/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreateFreelancerController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Tiago
 */
public class CreateFreelancerScene_3_UI implements Initializable{
    
    public CreateFreelancerController controller;

    @FXML
    private Button btnOK;
    @FXML
    private Label lblNotification;

//    public void setFreelancer(CreateFreelancerUI freel){
//       this.freel=freel;
//    }
    
    public void showNotification(String notification){
        this.lblNotification.setText(notification);
    }
    
    @FXML
    private void btnOKAction(ActionEvent event) {
        //this.freel.getMainApp().toMainScene();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controller = new CreateFreelancerController();
    }
    
}
