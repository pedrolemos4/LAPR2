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
public class JanelaOptionsAdminUI {

    private final MainApp mainApp;

    public JanelaOptionsAdminUI(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public MainApp getMainApp() {
        return this.mainApp;
    }

    public void toMenuAdminScene() {
        try {
            JanelaOptionsAdminScene_UI janelaOptionsAdminScene_ui
                    = (JanelaOptionsAdminScene_UI) this.mainApp.replaceSceneContent("/fxml/JanelaOptionsAdmin.fxml");
            janelaOptionsAdminScene_ui.setNewOptionsAdminUI(this);
            
        }catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
