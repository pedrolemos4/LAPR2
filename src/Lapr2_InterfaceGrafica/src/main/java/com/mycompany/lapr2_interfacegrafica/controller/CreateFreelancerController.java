package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;

public class CreateFreelancerController {

    private String id;
    private String name;
    private String lvlExp;
    private String email;
    private String nif;
    private String iban;
    private String country;
    private String adress;

    public FreelancersRecord regFreel;

    public CreateFreelancerController() {
    }

    public FreelancersRecord newFreelancer(String id, String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        return new FreelancersRecord(id, name, lvlExp, email, nif, iban, country, adress);
    }

    public void registerFreelancer(Freelancer freel) {
        regFreel.registerFreelancer(freel);
    }
}
