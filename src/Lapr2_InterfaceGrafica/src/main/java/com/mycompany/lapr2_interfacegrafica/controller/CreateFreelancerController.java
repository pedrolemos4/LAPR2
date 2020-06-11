package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr2.pot.ui.console.utils.Utils;

public class CreateFreelancerController {

    private Platform platform;
    private FreelancersRecord regFreel;
    private Freelancer freel;

    public CreateFreelancerController() {
        this.platform = POTApplication.getPlatform();
        this.regFreel = platform.getFreelancersRecord();
    }

    public Freelancer newFreelancer(String name, String lvlExp, String email, String nif, String iban, String country, String address) {
        //FreelancersRecord fr = platform.getFreelancersRecord();
        //System.out.println(String.format("The freelancer is called: %s. Lives in: %s, %s. Email: %s. Iban: %s. Nif: %s. Level of Experience: %s.", name, address, country, email, iban, nif, lvlExp));
        Freelancer freel1 = this.regFreel.newFreelancer(name, lvlExp, email, nif, iban, country, address);
        this.freel = freel1;
        return this.freel;
    }

    public boolean registerFreelancer() {
       // FreelancersRecord fr = platform.getFreelancersRecord();
        regFreel.generateId(freel);
        // regFreel.generateId(this.freel);
        return regFreel.registerFreelancer(freel);
    }

    public String getFreelancerString() {
        return this.freel.toString();
    }
}
