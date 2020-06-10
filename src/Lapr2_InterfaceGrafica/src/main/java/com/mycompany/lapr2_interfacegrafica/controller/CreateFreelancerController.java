package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr2.pot.ui.console.utils.Utils;

public class CreateFreelancerController {

    
    public Platform platform;
    public FreelancersRecord regFreel;
    public Freelancer freel;

    public CreateFreelancerController() {
        this.platform = POTApplication.getPlatform();
        this.regFreel= platform.getFreelancersRecord();
    }

    public Freelancer newFreelancer(String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        this.freel=new Freelancer(name, lvlExp, email, nif, iban, country, adress);
        return freel;
    }

    public boolean registerFreelancer() {
        regFreel.generateId(this.freel);
        return regFreel.registerFreelancer(this.freel);
    }

    public String getFreelancerString() {
        return this.freel.toString();
    }
}
