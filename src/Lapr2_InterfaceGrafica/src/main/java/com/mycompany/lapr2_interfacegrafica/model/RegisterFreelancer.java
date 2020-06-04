/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.model;

import java.util.List;

/**
 *
 * @author pedro
 */
public class RegisterFreelancer {

    private String id;
    private String name;
    private String lvlExp;
    private String email;
    private int nif;
    private int iban;
    private String country;
    private String adress;
    
    private List<Freelancer> arrayFreelancers;

    public RegisterFreelancer(String id, String name, String lvlExp, String email, int nif, int iban, String country, String adress) {
        new Freelancer(id, name, lvlExp, email, nif, iban, country, adress); 
    }
    
    public Freelancer newFreelancer(String id, String name, String lvlExp, String email, int nif, int iban, String country, String adress){
        return new Freelancer(id, name, lvlExp, email, nif, iban, country, adress); 
    }
    
    public void registerFreelancer(Freelancer freel){
        arrayFreelancers.add(freel);
    }
    
    public boolean validatesFreelancer(Freelancer freel){
        if(freel.getAdress()==null || freel.getCountry()==null || freel.getEmail()==null || freel.getIban()<0 || freel.getId()==null || freel.getLvlExp()==null || freel.getName()==null || freel.getNif()<0){
            return false;
        }else{
            return true;
        }
    }
    
    public void addFreelancer (Freelancer freel){
        registerFreelancer(freel);
    }
    
    public List<Freelancer> getListFreelancers(){
        return arrayFreelancers;
    }
    
}
