/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.model;

/**
 *
 * @author pedro
 */
public class NotifyFreelancerTask extends Timer {
    
    private FreelancersRecord freelRec;
    private Platform plat;
    
    public NotifyFreelancerTask(){
        freelRec=plat.getRegistoFreelancer();
    }
    
    @Override
    public void run(){
        sendEmail();
        nextNotification();
    }
    
    private void sendEmail(){
        
    }
    
    private void nextNotification(){
        freelRec.scheduleAutomaticEmail();
    }
    
}
