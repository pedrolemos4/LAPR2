/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author pedro
 */
public class CheckStatisticsController {

    private FacadeAuthorization facade;
    private Platform m_Platform;
    private OrganizationsRecord orgRec;

    public CheckStatisticsController() {
        this.m_Platform = POTApplication.getPlatform();
        this.facade = POTApplication.getFacadeAuthorization();
        this.orgRec = m_Platform.getOrganizationsRecord();
    }

    public TreeMap<String, List<Double>> determinatePayOrganization() {
        String email = facade.getCurrentSession().getUser().getEmail();
        Organization m_Organization = this.orgRec.getOrganizationByUserEmail(email);
        return this.orgRec.determinatePayOrg(m_Organization);
    }

    public TreeMap<String, Double> calcMeanPayment() {
        return this.orgRec.calcMeanPayment(determinatePayOrganization());
    }

    public TreeMap<String, Double> calcDeviationPayment() {
//        String email = facade.getCurrentSession().getUser().getEmail();
//        Organization m_Organization = this.orgRec.getOrganizationByUserEmail(email);
        return this.orgRec.calcDeviationPayment(determinatePayOrganization(),
                calcMeanPayment());
    }

    public TreeMap<String, List<Double>> determinateDelayOrganization() {
        String email = facade.getCurrentSession().getUser().getEmail();
        Organization m_Organization = this.orgRec.getOrganizationByUserEmail(email);
        return this.orgRec.determinateDelayOrg(m_Organization);
    }

    public TreeMap<String, Double> calcMeanDelay() {
        return this.orgRec.calcMeanDelay(determinateDelayOrganization());
    }

    public TreeMap<String, Double> calcDeviationDelay() {
        return this.orgRec.calcDeviationDelay(determinateDelayOrganization(),
                calcMeanDelay());
    }

    public double determinateNormalDistribution() {
        return this.orgRec.determinateNormalDistribution();
    }

    public double determinateIntervalsMean(TreeMap<String, List<Double>> map) {
        return this.orgRec.determinateIntervalsMean(map);
    }

    public double determinateIntervalsDeviation(TreeMap<String, List<Double>> map) {
        return this.orgRec.determineIntervalsDeviation(map);
    }
}
