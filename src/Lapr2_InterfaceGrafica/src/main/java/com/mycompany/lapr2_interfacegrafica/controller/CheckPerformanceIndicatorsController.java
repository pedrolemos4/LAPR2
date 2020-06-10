
package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.authorization.model.UserSession;
import com.mycompany.lapr2_interfacegrafica.model.Constants;
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
//        if(!POTApplication.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ADMINISTRATOR_ROLE))
//            throw new IllegalStateException("Unauthorized user.");
//        m_oPlataforma = POTApplication.getInstance().getPlataforma();
//        POTApplication m_oApp = POTApplication.getInstance();
//        UserSession m_oUser = m_oApp.getCurrentSession();
//        String email = m_oUser.getUserEmail();
//        orgRec = m_oPlataforma.getOrganizationsRecord();
//        org = orgRec.getOrganizationByUserEmail(email);
    }
    
    public void getOrganizations(){
        m_oPlataforma.getOrganizationsRecord();
        orgRec.getOrganizations();
    }
    
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
     
    public TreeMap<String, List<Double>> determinateDelayPlatform(){
        return orgRec.determinateDelayPlatform();
    }
    
    public TreeMap<String, Double> calcMeanDelay(){
        return orgRec.calcMeanDelay(orgRec.determinateDelayPlatform());
    }
    
    public TreeMap<String, Double> calcDeviationDelay(){
        return orgRec.calcDeviationDelay(orgRec.determinateDelayPlatform()
                , orgRec.calcMeanDelay(orgRec.determinateDelayPlatform()));
    }
    
    public double determinateNormalDistribution(){
        return orgRec.determinateNormalDistribution();
    }
    
    public double determinateIntervalsMean(TreeMap<String, List<Double> > map){
        return orgRec.determinateIntervalsMean(map);
    }
    
    public double determinateIntervalsDeviation(TreeMap<String, List<Double> > map){
        return orgRec.determineIntervalsDeviation(map);
    }
 
}
