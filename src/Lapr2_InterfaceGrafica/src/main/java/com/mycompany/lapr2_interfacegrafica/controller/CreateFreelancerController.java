package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr2.pot.ui.console.utils.Utils;

public class CreateFreelancerController {

    private String id;
    private String name;
    private String lvlExp;
    private String email;
    private String nif;
    private String iban;
    private String country;
    private String adress;
    private Platform platform;

    public FreelancersRecord regFreel;
    public Freelancer freel;

    public CreateFreelancerController() {
    }

    public boolean newFreelancer(String id, String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        try{
            this.freel = this.platform.getRegistoFreelancer().newFreelancer(id, name, lvlExp, email, nif, iban, country, adress);
            return this.platform.getRegistoFreelancer().validatesFreelancer(this.freel);
        }
        catch(RuntimeException ex){
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.freel = null;
            return false;
        }
    }

    public boolean registerFreelancer(Freelancer freel) {
        return this.regFreel.registerFreelancer(freel);
    }
    
    public String getFreelancerString()
    {
        return this.freel.toString();
    }
}
