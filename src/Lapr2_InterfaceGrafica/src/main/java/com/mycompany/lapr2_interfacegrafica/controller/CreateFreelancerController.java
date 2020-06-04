/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.RegisterFreelancer;

/**
 *
 * @author pedro
 */
public class CreateFreelancerController {
    
    private String id;
    private String name;
    private String lvlExp;
    private String email;
    private int nif;
    private int iban;
    private String country;
    private String adress;
    
    public RegisterFreelancer regFreel;
    
    public CreateFreelancerController(){
        
    }
    
    public RegisterFreelancer newFreelancer(String id, String name, String lvlExp, String email, int nif, int iban, String country, String adress){
       return new RegisterFreelancer(id, name, lvlExp, email, nif, iban, country, adress); 
    }
   
    public void registerFreelancer(Freelancer freel){
        regFreel.registerFreelancer(freel);
    }
}
