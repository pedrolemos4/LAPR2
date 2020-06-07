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
 * @author pedro
 */
public class JanelaLoginUI {
    
    private final MainApp mainApp;
    
    public JanelaLoginUI(MainApp mA){
        this.mainApp=mA;
    }
    
    public void toJanelaLogin1UI(){
        try {
          JanelaLogin_1_UI janelaLogin1UI = (JanelaLogin_1_UI) this.mainApp.replaceSceneContent("/fxml/JanelaLogin.fxml");
        } catch (Exception e){
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
