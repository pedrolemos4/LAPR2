
package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import java.util.List;
import java.util.TreeMap;

public class CheckPerformanceIndicatorsController {
    private FacadeAuthorization facade;
    private Platform m_Platform;
    private OrganizationsRecord orgRec;

    public CheckPerformanceIndicatorsController() {
        this.m_Platform = POTApplication.getPlatform();
        this.facade = POTApplication.getFacadeAuthorization();
        this.orgRec = m_Platform.getOrganizationsRecord();
    }
    
    public void getOrganizations(){
        m_Platform.getOrganizationsRecord();
        orgRec.getOrganizations();
    }
    
    public TreeMap<String, List<Double>> determinatePayPlatform(){
        return this.orgRec.determinatePayPlatform();
    }
    
    public TreeMap<String, Double> calcMeanPayment(){
        return this.orgRec.calcMeanPayment(determinatePayPlatform());
    }
    
    public TreeMap<String, Double> calcDeviationPayment(){
        return this.orgRec.calcDeviationPayment(determinatePayPlatform()
                ,calcMeanPayment());
    }
     
    public TreeMap<String, List<Double>> determinateDelayPlatform(){
        return this.orgRec.determinateDelayPlatform();
    }
    
    public TreeMap<String, Double> calcMeanDelay(){
        return this.orgRec.calcMeanDelay(determinateDelayPlatform());
    }
    
    public TreeMap<String, Double> calcDeviationDelay(){
        return this.orgRec.calcDeviationDelay(determinateDelayPlatform()
                , calcMeanDelay());
    }
    
    public double determinateNormalDistribution(){
        return this.orgRec.determinateNormalDistribution();
    }
    
    public double determinateIntervalsMean(TreeMap<String, List<Double> > map){
        return this.orgRec.determinateIntervalsMean(map);
    }
    
    public double determinateIntervalsDeviation(TreeMap<String, List<Double> > map){
        return this.orgRec.determineIntervalsDeviation(map);
    }
 
}
