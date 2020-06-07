/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.model;

import java.util.Date;

/**
 *
 * @author pedro
 */
public class Timer {
    
    private Date date;
    
    private FreelancersRecord freelRec;
    private NotifyFreelancerTask task;
    
    public Timer(){
    }
    
    public void schedule(NotifyFreelancerTask task, Date date){
        this.task=task;
        this.date=date;
    }
    
    public void run(){
        
    }
    
}
