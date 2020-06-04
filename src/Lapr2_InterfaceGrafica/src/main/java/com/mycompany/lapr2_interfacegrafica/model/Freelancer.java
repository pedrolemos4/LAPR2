package com.mycompany.lapr2_interfacegrafica.model;

public class Freelancer {

    private String id;
    private String name;
    private String lvlExp;
    private String email;
    private int nif;
    private String iban;
    private String country;
    private String adress;

    public Freelancer(String id, String name, String lvlExp, String email, int nif, String iban, String country, String adress) {
        this.adress = adress;
        this.country = country;
        this.email = email;
        this.iban = iban;
        this.id = id;
        this.lvlExp = lvlExp;
        this.name = name;
        this.nif = nif;
    }

    public String getAdress() {
        return this.adress;
    }

    public String getCountry() {
        return this.country;
    }

    public String getId() {
        return this.id;
    }

    public String getLvlExp() {
        return this.lvlExp;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getIban() {
        return this.iban;
    }

    public int getNif() {
        return this.nif;
    }

    public boolean validatesFreelancer(Freelancer freel) {
        if (freel.getAdress() == null || freel.getCountry() == null || freel.getEmail() == null || freel.getIban() == null || freel.getId() == null || freel.getLvlExp() == null || freel.getName() == null || freel.getNif() < 0) {
            return false;
        } else {
            return true;
        }
    }

}
