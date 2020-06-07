
package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author beatr
 */
public class CheckPerformanceIndicatorsController {
    
    private Platform m_oPlataforma;
    private Organization org;
    private OrganizationsRecord orgRec;

    public CheckPerformanceIndicatorsController() {
        
    }
    
    public void getOrganizations(){
        m_oPlataforma.getOrganizationsRecord();
        orgRec.getOrganizations();
    }
    
    
//    public void determinatePayOrg(){
//        org.determinatePayOrg(mapOrgPayment);
//    }
    
    public TreeMap<String, List<Double>> determinatePayPlatform(){
        return orgRec.determinatePayPlatform();
    }
    
    public TreeMap<String, Double> calcMeanPayment(){
        return orgRec.calcMeanPayment(orgRec.determinatePayPlatform());
    }
    
    public TreeMap<String, Double> calcDeviationPayment(){
        return orgRec.calcDeviationPayment(orgRec.determinatePayPlatform()
                , orgRec.calcMeanPayment(orgRec.determinatePayPlatform()));
    }
    
//    public void determinateDelayOrg(){
//        TreeMap<String,List<Double>> mapOrgDelay= new TreeMap<>();
//        org.determinateDelayOrg(mapOrgDelay);
//    }
//    
    public void determinateDelayPlatform(){
        orgRec.determinateDelayPlatform();
    }
    
    public TreeMap<String, Double> calcMeanDelay(){
        return orgRec.calcMeanDelay(orgRec.determinateDelayPlatform());
    }
    
    public TreeMap<String, Double> calcDeviationDelay(){
        return orgRec.calcDeviationDelay(orgRec.determinateDelayPlatform()
                , orgRec.calcMeanDelay(orgRec.determinateDelayPlatform()));
    }
    
    public void determinateNormalDistribution(){
        orgRec.determinateNormalDistribution();
    }
 
}
