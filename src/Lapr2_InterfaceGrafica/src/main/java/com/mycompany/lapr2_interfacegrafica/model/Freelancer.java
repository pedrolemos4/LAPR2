package com.mycompany.lapr2_interfacegrafica.model;

public class Freelancer {

    private String id;
    private String name;
    private String lvlExp;
    private String email;
    private String nif;
    private String iban;
    private String country;
    private String address;

    public Freelancer(String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        if (adress == null || country == null || email == null || iban == null || lvlExp == null || name == null || nif == null) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        setAddress(adress);
        setCountry(country);
        setEmail(email);
        setIBAN(iban);
        setExpertise(lvlExp);
        setName(name);
        setNif(nif);
    }
    
    public Freelancer(String id,String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        if (id==null || adress == null || country == null || email == null || iban == null || lvlExp == null || name == null || nif == null) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        setAddress(adress);
        setCountry(country);
        setEmail(email);
        setIBAN(iban);
        setExpertise(lvlExp);
        setName(name);
        setNif(nif);
        setId(id);
    }

    public void generateId(String nome) {
        String letra1, letra2;
        String[] array = nome.split("");
        letra1 = array[0];
        int size = array.length;
        letra2 = array[size];
        int numero = compareFreelancer(this);
        String idGerado = (letra1+letra2+numero);
        setId(idGerado);
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

    public void setName(String name) {
        if(name.trim().isEmpty() || name ==null) throw new IllegalArgumentException("Invalid name!");
        this.name = name;
    }

    public void setEmail(String email) {
        if(email.trim().isEmpty()|| email ==null) throw new IllegalArgumentException("Invalid Email!");
        this.email = email;
    }

    public void setNif(String nif) {
        try {
            if (nif.trim().isEmpty()|| Long.parseLong(nif) >= 1000000000 || Long.parseLong(nif) <= 99999999) {
                throw new IllegalArgumentException("Invalid NIF ! (A valid has 9 numbers)");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Format for NIF !");
        }
        this.nif = nif;
    }

    public void setIBAN(String IBAN) {
        if (IBAN.trim().isEmpty() ) {
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
        if(expertise ==null || expertise!="Junior" || expertise!="Senior"){
            throw new IllegalArgumentException("Empty Expertise !");
        }
        this.lvlExp = expertise;
    }

    public void setId(String id) {
        if(id ==null){
            new IllegalArgumentException("ID Freelancer is Empty");
        }
        this.id = id;
    }

    public String toString() {
        return String.format("The freelancer is called: %n. Lives in: %n, %n. Email: %n. Iban: %n. Nif: %n. Level of Experience: %n.", name, address, country, email, iban, nif, lvlExp);
    }

    public boolean validatesFreelancer(Freelancer freel) {
        if (freel.getAdress() == null || freel.getCountry() == null || freel.getEmail() == null || freel.getIban() == null || freel.getId() == null || freel.getLvlExp() == null || freel.getName() == null || freel.getNif() == null) {
            return false;
        } else {
            return true;
        }
    }

}
