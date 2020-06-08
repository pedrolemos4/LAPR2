/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.model;

import java.io.FileNotFoundException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class NotifyFreelancerTask extends TimerTask {
    
    private FreelancersRecord freelRec;
    private Platform plat;
    
    public NotifyFreelancerTask(){
        freelRec=plat.getFreelancersRecord();
    }
    
    @Override
    public void run(){
        try {
            sendEmail();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NotifyFreelancerTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        nextNotification();
    }
    
    private void sendEmail() throws FileNotFoundException{
        freelRec.sendEmails();
    }
    
    private void nextNotification(){
        freelRec.scheduleAutomaticEmail();
    }
    
}
