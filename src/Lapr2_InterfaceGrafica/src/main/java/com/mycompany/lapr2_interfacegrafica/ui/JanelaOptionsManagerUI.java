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
public class JanelaOptionsManagerUI {

    private final MainApp mainApp;

    public JanelaOptionsManagerUI(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public MainApp getMainApp() {
        return this.mainApp;
    }

    public void toMenuManagerScene() {
        try {
            JanelaOptionsManagerScene_UI janelaOptionsManagerScene_ui
                    = (JanelaOptionsManagerScene_UI) this.mainApp.replaceSceneContent("/fxml/JanelaOptionsManager.fxml");
            janelaOptionsManagerScene_ui.setNewOptionsManagerUI(this);

        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
