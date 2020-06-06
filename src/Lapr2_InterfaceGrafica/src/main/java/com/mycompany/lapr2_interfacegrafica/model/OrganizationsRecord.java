package com.mycompany.lapr2_interfacegrafica.model;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.math3.distribution.NormalDistribution;

public class OrganizationsRecord {

    private PasswordGeneratorAlgorithm alg;
    private final FacadeAuthorization m_oAutorizacao = new FacadeAuthorization();
    private final List<Organization> m_lstOrganizations;

    public OrganizationsRecord() {
        this.m_lstOrganizations = new ArrayList<>();
    }

    public Organization newOrganization(String name, String NIF, String nameM, String emailM, String nameC, String emailC) {
        Collaborator manager = new Collaborator(nameM, emailM);
        Collaborator collab = new Collaborator(nameC, emailC);
        return new Organization(name, NIF, manager, collab);
    }

    public Collaborator newCollaborator(String name, String email) {
        return new Collaborator(name, email);
    }

    public boolean validateOrganization(Organization org) {
        for (int i = 0; i < m_lstOrganizations.size(); i++) {
            if (m_lstOrganizations.get(i).equals(org)) {
                return false;
            }
        }
        return true;
    }

    public List<Organization> getOrganizations() {
        return this.m_lstOrganizations;
    }

    public boolean addOrganization(Organization org) {
        return m_lstOrganizations.add(org);
    }

    public String getOrganizationToString(Organization org) {
        return org.toString();
    }

    public boolean organizationRegister(Organization org) {
        if (this.validateOrganization(org)) {
            Collaborator manager = org.getManager();
            String nameM = manager.getName();
            String emailM = manager.getEmail();
            String pwdM = alg.generatePassword(nameM, emailM);
            Collaborator collab = org.getCollaborator();
            String nameC = collab.getName();
            String emailC = collab.getEmail();
            String pwdC = alg.generatePassword(nameC, emailC);
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(nameM, emailM, pwdM,
                    new String[]{Constants.ORGANIZATION_MANAGER_ROLE, Constants.ORGANIZATION_COLLABORATOR_ROLE})
                    && this.m_oAutorizacao.registaUtilizadorComPapel(nameC, emailC, pwdC, Constants.ORGANIZATION_COLLABORATOR_ROLE)) {
                return addOrganization(org);
            }
        }
        return false;
    }

    public Organization getOrganizationByUserEmail(String email) {
        for (int i = 0; i < m_lstOrganizations.size(); i++) {
            if (m_lstOrganizations.get(i).getManager().getEmail().equals(email) || m_lstOrganizations.get(i).getCollaborator().getEmail().equals(email)) {
                return m_lstOrganizations.get(i);
            }
        }
        return null;
    }

    //UC6
    public TreeMap<String, List<Double>> determinatePayPlatform() {
        TreeMap<String, List<Double>> mapTotalPayments = new TreeMap<>();
        for (Organization o : m_lstOrganizations) {
            o.determinatePayOrg(mapTotalPayments);
        }
        return mapTotalPayments;
    }

    public TreeMap<String, Double> calcMeanPayment(TreeMap<String, List<Double>> mapTotalPayments) {
        TreeMap<String, Double> mapMeanPayments = new TreeMap<>();
        double sum = 0, mean = 0;
        for (Map.Entry<String, List<Double>> entry : mapTotalPayments.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
                mean = sum / entry.getValue().size();
                mapMeanPayments.put(entry.getKey(), mean);
            }
            sum = 0;
        }
        return mapMeanPayments;
    }

    public TreeMap<String, Double> calcDeviationPayment(TreeMap<String, List<Double>> mapTotalPayments, TreeMap<String, Double> mapMeanPayments) {
        TreeMap<String, Double> mapDeviationPayments = new TreeMap<>();
        double x = 0, mean = 0, subtraction = 0, deviation = 0;
        for (Map.Entry<String, List<Double>> entry : mapTotalPayments.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                x = entry.getValue().get(i);
                for (Map.Entry<String, Double> entry1 : mapMeanPayments.entrySet()) {
                    if (entry.getKey().equalsIgnoreCase(entry1.getKey())) {
                        mean = entry1.getValue();
                        subtraction += Math.pow(x - mean, 2);
                    }
                }
                deviation = Math.sqrt(subtraction / entry.getValue().size());
                mapDeviationPayments.put(entry.getKey(), deviation);
            }
        }
        return mapDeviationPayments;
    }

    public TreeMap<String, List<Double>> determinateDelayPlatform() {
        TreeMap<String, List<Double>> mapTotalDelays = new TreeMap<>();
        for (Organization o : m_lstOrganizations) {
            o.determinateDelayOrg(mapTotalDelays);
        }
        return mapTotalDelays;
    }

    public TreeMap<String, Double> calcMeanDelay(TreeMap<String, List<Double>> mapTotalDelays) {
        TreeMap<String, Double> mapMeanDelays = new TreeMap<>();
        double sum = 0, mean = 0;
        for (Map.Entry<String, List<Double>> entry : mapTotalDelays.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
                mean = sum / entry.getValue().size();
                mapMeanDelays.put(entry.getKey(), mean);
            }
            sum = 0;
        }
        return mapMeanDelays;
    }

    public TreeMap<String, Double> calcDeviationDelay(TreeMap<String, List<Double>> mapTotalDelays, TreeMap<String, Double> mapMeanDelays) {
        TreeMap<String, Double> mapDeviationDelays = new TreeMap<>();
        double x = 0, mean = 0, subtraction = 0, deviation = 0;
        for (Map.Entry<String, List<Double>> entry : mapTotalDelays.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                x = entry.getValue().get(i);
                for (Map.Entry<String, Double> entry1 : mapMeanDelays.entrySet()) {
                    if (entry.getKey().equalsIgnoreCase(entry1.getKey())) {
                        mean = entry1.getValue();
                        subtraction += Math.pow(x - mean, 2);
                    }
                }
                deviation = Math.sqrt(subtraction / entry.getValue().size());
                mapDeviationDelays.put(entry.getKey(), deviation);
            }
        }
        return mapDeviationDelays;
    }

    public double determinateIntervals(TreeMap<String, Double> map) {
        double sum = 0;
        int counter = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            sum += entry.getValue();
            counter++;
        }
        return sum / counter;
    }
    public double determinateNormalDistribution(){
        int counter = 0;
        double x = 3, m = 2, d = 1.5;
        for (Organization org : m_lstOrganizations){
            counter += org.calcCounterFree();
        }
        NormalDistribution normalD = new NormalDistribution(m,d/counter);
        return 1-normalD.cumulativeProbability(x);
    }
}
