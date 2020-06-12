/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.NotifyFreelancerTask;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author pedro
 */
public class SendEmailController {

    private Platform platform;
    private FreelancersRecord regFreel;
    private NotifyFreelancerTask notFreelTask;

    public SendEmailController() {
        this.platform = POTApplication.getPlatform();
        this.regFreel = platform.getFreelancersRecord();
    }
    
    public List<Freelancer> getListFreelancersAdapt() throws FileNotFoundException{
        return regFreel.getFreelancersAdapt();
    }

    public void sendEmail(Freelancer freel) throws FileNotFoundException {
        regFreel.sendEmail(freel);
    }
}
