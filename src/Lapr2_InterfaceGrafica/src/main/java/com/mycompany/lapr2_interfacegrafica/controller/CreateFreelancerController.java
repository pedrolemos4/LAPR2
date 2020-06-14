package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Platform;

public class CreateFreelancerController {

    private Platform platform;
    private FreelancersRecord regFreel;
    private Freelancer freel;

    public CreateFreelancerController() {
        this.platform = POTApplication.getPlatform();
        this.regFreel = platform.getFreelancersRecord();
    }

    public Freelancer newFreelancer(String name, String lvlExp, String email, String nif, String iban, String country, String address) {
        freel = regFreel.newFreelancer(name, lvlExp, email, nif, iban, country, address);
        return freel;
    }

    public CreateFreelancerController getController() {
        return this;
    }

    public boolean registerFreelancer(Freelancer frl) {
        FreelancersRecord fr = platform.getFreelancersRecord();
        return fr.registerFreelancer(frl);
    }

    public String getFreelancerString() {
        return this.freel.toString();
    }
}
