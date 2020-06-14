package com.mycompany.lapr2_interfacegrafica.model;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.controller.POTApplication;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.math3.distribution.NormalDistribution;

public class OrganizationsRecord implements Serializable {

    private Platform plat;
    private Organization org;
    private final List<Organization> m_lstOrganizations;

    public OrganizationsRecord() {
        this.m_lstOrganizations = new ArrayList<>();
    }

    public Organization newOrganization(String name, String NIF, String nameM, String emailM, String nameC, String emailC) {
        if (!this.validateNIF(NIF)) {
            throw new IllegalArgumentException("There is already an organization with a NIF equal to the one introduced!");
        }
        if (!this.validateManagerEmail(emailM)) {
            throw new IllegalArgumentException("Manager email already exists in the system!");
        }
        if (!this.validateCollaboratorEmail(emailC)) {
            throw new IllegalArgumentException("Collaborator email already exists in the system!");
        }
        this.org = new Organization(name, NIF, nameM, emailM, nameC, emailC);
        return this.org;
    }

    public Organization getOrganization() {
        return this.org;
    }

    public boolean validateOrganization(Organization org) {
        for (int i = 0; i < m_lstOrganizations.size(); i++) {
            if (m_lstOrganizations.get(i).equals(org)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateNIF(String nif) {
        for (int i = 0; i < m_lstOrganizations.size(); i++) {
            if (m_lstOrganizations.get(i).getOrgNIF().equals(nif)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateManagerEmail(String email) {
        for (int i = 0; i < m_lstOrganizations.size(); i++) {
            if (m_lstOrganizations.get(i).getManager().getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateCollaboratorEmail(String email) {
        for (int i = 0; i < m_lstOrganizations.size(); i++) {
            if (m_lstOrganizations.get(i).getCollaborator().getEmail().equals(email)) {
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
        String orgName = org.getOrgName();
        Manager manager = org.getManager();
        String nameM = manager.getName();
        String emailM = manager.getEmail();
        ExternalAlgorithm1API exAlgApi = new ExternalAlgorithm1API();
        String pwdM = exAlgApi.generatePassword(nameM, emailM);
        Collaborator collab = org.getCollaborator();
        String nameC = collab.getName();
        String emailC = collab.getEmail();
        String pwdC = exAlgApi.generatePassword(nameC, emailC);
        FacadeAuthorization aut = POTApplication.getFacadeAuthorization();
        if (aut.registesUserWithRole(nameM, emailM, pwdM, Constants.ORGANIZATION_MANAGER_ROLE)
                && aut.registesUserWithRole(nameC, emailC, pwdC, Constants.ORGANIZATION_COLLABORATOR_ROLE)) {
            sendEmail(orgName, emailM, pwdM, Constants.ORGANIZATION_MANAGER_ROLE);
            sendEmail(orgName, emailC, pwdC, Constants.ORGANIZATION_COLLABORATOR_ROLE);
            return addOrganization(org);
        }
        return false;
    }

    public void sendEmail(String orgName, String email, String pwd, String role) {
        try (FileWriter writer = new FileWriter("email.txt", true)) {
            writer.write("Organization: " + orgName + "\nRole: " + role + "\nEmail: " + email + "\nPassword: " + pwd + "\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error in sending email!");
        }
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

    //UC8
    public TreeMap<String, List<Double>> determinatePayOrg(Organization org) {
        TreeMap<String, List<Double>> mapTotalPayments = new TreeMap<>();
        org.determinatePayOrg(mapTotalPayments);
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

    //UC8
    public TreeMap<String, List<Double>> determinateDelayOrg(Organization org) {
        TreeMap<String, List<Double>> mapTotalPayments = new TreeMap<>();
        org.determinateDelayOrg(mapTotalPayments);
        return mapTotalPayments;
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

    public double determinateIntervalsMean(TreeMap<String, List<Double>> map) {
        double sum = 0, mean = 0, counter = 0;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
                counter++;
            }
            mean = sum / counter;
        }
        return mean;
    }

    public double determineIntervalsDeviation(TreeMap<String, List<Double>> map) {
        double x = 0, subtraction = 0;
        int counter = 0;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                x = entry.getValue().get(i);
                subtraction += Math.pow(x - determinateIntervalsMean(map), 2);
                counter++;
            }
        }
        return Math.sqrt(subtraction / counter);
    }

    public double determinateNormalDistribution() {
        int counter = 0;
        double x = 3, m = 2, d = 1.5;
        double deviation = Math.pow(d, 2);
        for (Organization org : m_lstOrganizations) {
            counter += org.calcCounterDelays();
        }
        NormalDistribution normalD = new NormalDistribution(m, Math.sqrt(deviation / counter));
        return 1 - normalD.cumulativeProbability(x);
    }
}
