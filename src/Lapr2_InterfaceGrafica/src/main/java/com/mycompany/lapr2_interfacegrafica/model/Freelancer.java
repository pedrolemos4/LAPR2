package com.mycompany.lapr2_interfacegrafica.model;

public class Freelancer {

    private String id;
    private String name;
    private String lvlExp;
    private String email;
    private String nif;
    private String iban;
    private String country;
    private String adress;

    public Freelancer(String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        if (adress == null || country == null || email == null || iban == null || lvlExp == null || name == null || nif == null) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        this.adress = adress;
        this.country = country;
        this.email = email;
        this.iban = iban;
        //this.id = id;
        this.lvlExp = lvlExp;
        this.name = name;
        this.nif = nif;
        this.id = generateId(name);
    }

    public String generateId(String nome) {
        String letra1, letra2;
        String[] array = nome.split("");
        letra1 = array[0];
        int size = array.length;
        letra2 = array[size];
        int numero = compareFreelancer(this);
        String idGerado = (letra1+letra2+numero);
        return idGerado;
    }
    

    public int compareFreelancer(Freelancer otherFreelancer) {
        if (this.name.equalsIgnoreCase(otherFreelancer.getName())) {
            String [] idOr = this.getId().split("");
            int numero=Integer.parseInt(idOr[2]);
            int numero1=numero+1;
            return numero1;
        }
            return 0;
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

    public String getNif() {
        return this.nif;
    }

    public String toString() {
        return String.format("The freelancer is called: %n. Lives in: %n, %n. Email: %n. Iban: %n. Nif: %n. Level of Experience: %n.", name, adress, country, email, iban, nif, lvlExp);
    }

    public boolean validatesFreelancer(Freelancer freel) {
        if (freel.getAdress() == null || freel.getCountry() == null || freel.getEmail() == null || freel.getIban() == null || freel.getId() == null || freel.getLvlExp() == null || freel.getName() == null || freel.getNif() == null) {
            return false;
        } else {
            return true;
        }
    }

}
