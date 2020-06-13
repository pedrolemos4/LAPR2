package com.mycompany.lapr2_interfacegrafica.model;

import java.io.Serializable;

public class Freelancer implements Serializable {

    private String id;
    private String name;
    private String lvlExp;
    private String email;
    private String nif;
    private String iban;
    private String country;
    private String address;

    public Freelancer(String name1, String lvlExp, String email, String nif, String iban, String country, String adress) {
        setAddress(adress);
        setCountry(country);
        setEmail(email);
        setIBAN(iban);
        setExpertise(lvlExp);
        setName(name1);
        setNif(nif);
    }

    public Freelancer(String id, String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
//        if (id==null || adress == null || country == null || email == null || iban == null || lvlExp == null || name == null || nif == null) {
//            throw new IllegalArgumentException("None of the arguments can be null or empty.");
//        }
        setAddress(adress);
        setCountry(country);
        setEmail(email);
        setIBAN(iban);
        setExpertise(lvlExp);
        setName(name);
        setNif(nif);
        setId(id);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name!");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@")){ 
            throw new IllegalArgumentException("Invalid Freelancer Email!");
        }
        this.email = email;
    }

    public void setNif(String nif) {
        try {
            if (nif.trim().isEmpty() || Long.parseLong(nif) >= 1000000000 || Long.parseLong(nif) <= 99999999) {
                throw new IllegalArgumentException("Invalid NIF ! (A valid has 9 numbers)");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Format for NIF !");
        }
        this.nif = nif;
    }

    public void setIBAN(String IBAN) {
        if (IBAN.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty Bank Account !");
        }
        this.iban = IBAN;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Address !");
        }
        this.address = address;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Country !");
        }
        this.country = country;
    }

    public void setExpertise(String expertise) {
        if (expertise == null) {
            throw new IllegalArgumentException("Empty Expertise !");
        }
        this.lvlExp = expertise;
    }

    public void setId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("ID Freelancer is Empty");
        }
        this.id = id;
    }

    public String getAdress() {
        return this.address;
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

    public String getNif() {
        return this.nif;
    }

    @Override
    public String toString() {
        return String.format("The freelancer is called: %s. Lives in: %s, %s. "
                + "Email: %s. Iban: %s. Nif: %s. Level of Experience: %s. \nId: %s", name, address, country, email, iban, nif, lvlExp, id);
    }

    public boolean validatesFreelancer(Freelancer freel) {
        if (freel.getAdress() == null || freel.getCountry() == null || freel.getEmail() == null || freel.getIban() == null || freel.getId() == null || freel.getLvlExp() == null || freel.getName() == null || freel.getNif() == null) {
            return false;
        } else {
            return true;
        }
    }

}
