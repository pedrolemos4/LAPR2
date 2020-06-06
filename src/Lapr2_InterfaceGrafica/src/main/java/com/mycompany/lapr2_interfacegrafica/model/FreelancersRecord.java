package com.mycompany.lapr2_interfacegrafica.model;

import java.util.ArrayList;
import java.util.List;

public class FreelancersRecord {

    private String id;
    private String name;
    private String lvlExp;
    private String email;
    private int nif;
    private String iban;
    private String country;
    private String adress;

    private final List<Freelancer> arrayFreelancers;

    public FreelancersRecord() {
        this.arrayFreelancers = new ArrayList<>();
    }

    public Freelancer newFreelancer(String id, String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        return new Freelancer(id, name, lvlExp, email, nif, iban, country, adress);
    }

    public boolean registerFreelancer(Freelancer freel) {
        if(this.validatesFreelancer(freel)){
            addFreelancer(freel);
        } 
        return false;
    }

    public boolean validatesFreelancer(Freelancer freel) {
        if (freel.getAdress() == null || freel.getCountry() == null || freel.getEmail() == null || freel.getIban() == null || freel.getId() == null || freel.getLvlExp() == null || freel.getName() == null || freel.getNif() ==null) {
            return false;
        } else { 
            return true;
        }
    }

    public void addFreelancer(Freelancer freel) {
        arrayFreelancers.add(freel);
    }

    public List<Freelancer> getListFreelancers() {
        return arrayFreelancers;
    }

}
