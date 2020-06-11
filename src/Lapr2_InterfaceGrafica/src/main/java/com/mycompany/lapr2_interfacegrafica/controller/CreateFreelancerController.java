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
        freel = regFreel.newFreelancer(name, lvlExp, email, nif, iban, country, address);
        return freel;
    }

    public boolean registerFreelancer() {
//        if(regFreel==null){
//            System.out.println("Registo fREELANCER NULL");
//        }
//         regFreel.generateId(freel);
        FreelancersRecord fr = platform.getFreelancersRecord();
        Freelancer frl = fr.getFreelancer();
        System.out.println(frl.toString());
        System.out.println("Name: " + frl.getName());
        return fr.registerFreelancer(frl);

    }

    public String getFreelancerString() {
        return this.freel.toString();
    }
}
