/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreateFreelancerController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pedro
 */
public class CreateFreelancerUI {
    
    public MainApp mainApp;
    public CreateFreelancerController controller;
    
    public CreateFreelancerUI(MainApp mainApp){
        this.mainApp = mainApp;
        this.controller = new CreateFreelancerController();
    }
    
    public MainApp getMainApp(){
        return this.mainApp;
    }
    
    public CreateFreelancerController getCreateFreelancerController(){
        return this.controller;
    }
    
    public void toCreateFreelancerScene1UI(){
        try {
            CreateFreelancerScene_1_UI createFreelancer1UI = (CreateFreelancerScene_1_UI) this.mainApp.replaceSceneContent("/fxml/CreateFreelancer_1.fxml");
            createFreelancer1UI.setFreelancer(this);
            String freel = this.getCreateFreelancerController().getFreelancerString();
            if(freel!=null){
               createFreelancer1UI.showFreelancer();
            }
        } catch(Exception ex){
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toCreateFreelancerScene2UI(){
        try {
            CreateFreelancerScene_2_UI createFreelancer2UI = (CreateFreelancerScene_2_UI) this.mainApp.replaceSceneContent("/fxml/CreateFreelancer_2.fxml");
            createFreelancer2UI.setFreelancer(this);
            createFreelancer2UI.showFreelancer();
        } catch(Exception ex){
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toCreateFreelancerScene3UI(String notification){
        try {
            CreateFreelancerScene_3_UI createFreelancer3UI = (CreateFreelancerScene_3_UI) this.mainApp.replaceSceneContent("/fxml/CreateFreelancer_3.fxml");
            createFreelancer3UI.setFreelancer(this);
            createFreelancer3UI.showNotification(notification);
        } catch(Exception ex){
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void goToScene(ActionEvent event , String fxml) throws IOException{
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
    }
}

