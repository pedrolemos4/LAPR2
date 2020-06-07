/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author pedro
 */
public class ListFreelancer {
    
    private List<Freelancer> arrayFreel;
    public FreelancersRecord freeRec;
    public Freelancer freel;
    
    public ListFreelancer(){
        arrayFreel = freeRec.getListFreelancers(); 
    }
    
    public Freelancer getFreelByPlace(int i){
        return arrayFreel.get(i);
    }
    
}
