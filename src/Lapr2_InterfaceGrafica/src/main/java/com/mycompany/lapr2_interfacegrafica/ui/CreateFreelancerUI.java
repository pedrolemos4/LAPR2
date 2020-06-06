/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CreateFreelancerController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class CreateFreelancerUI {
    
    private final MainApp mainApp;
    private final CreateFreelancerController controller;
    
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
    
    public void CreateFreelancerScene1UI(){
        try {
            CreateFreelancerScene_1_UI createFreelancer1UI = (CreateFreelancerScene_1_UI) this.mainApp.replaceSceneContent("/fxml/CreateFreelancer_1_UI.fxml");
            createFreelancer1UI.setFreelancer(this);
            String freel = this.getCreateFreelancerController().getFreelancerString();
            if(freel!=null){
               createFreelancer1UI.showFreelancer();
            }
        } catch(Exception ex){
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CreateFreelancerScene2UI(){
        try {
            CreateFreelancerScene_2_UI createFreelancer2UI = (CreateFreelancerScene_2_UI) this.mainApp.replaceSceneContent("/fxml/CreateFreelancer_2_UI.fxml");
            createFreelancer2UI.setFreelancer(this);
            createFreelancer2UI.showFreelancer();
        } catch(Exception ex){
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CreateFreelancerScene3UI(String notification){
        try {
            CreateFreelancerScene_3_UI createFreelancer3UI = (CreateFreelancerScene_3_UI) this.mainApp.replaceSceneContent("/fxml/CreateFreelancer_3_UI.fxml");
            createFreelancer3UI.setFreelancer(this);
            createFreelancer3UI.showNotification(notification);
        } catch(Exception ex){
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
