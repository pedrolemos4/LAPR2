/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.ui;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago
 */
public class JanelaOptionsCollaboratorUI {
    private final MainApp mainApp;
    
    public JanelaOptionsCollaboratorUI(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public MainApp getMainApp() {
        return this.mainApp;
    }

      public void toMenuCollaboratorScene() {
        try {
            JanelaOptionsCollaboratorScene_UI janelaOptionsCollaboratorScene_ui
                    = (JanelaOptionsCollaboratorScene_UI) this.mainApp.replaceSceneContent("/fxml/JanelaOptionsCollaborator.fxml");
            janelaOptionsCollaboratorScene_ui.setNewOptionsCollaboratorUI(this);
            
        }catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
