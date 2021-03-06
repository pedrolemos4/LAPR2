package com.mycompany.lapr2_interfacegrafica.model;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.controller.POTApplication;
import com.mycompany.lapr2_interfacegrafica.ui.AlertUI;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import javafx.scene.control.Alert;

public class FreelancersRecord implements Serializable {

    public Organization org;
    private Platform plat;
    private Freelancer frl;

    public final List<Freelancer> arrayFreelancers;
    public PaymentTransactionList payemntTransList;

    public FreelancersRecord() {
        this.arrayFreelancers = new ArrayList<>();
    }

    public Freelancer newFreelancer(String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        return new Freelancer(name, lvlExp, email, nif, iban, country, adress);
    }

    public Freelancer newFreelancer1(String id, String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        return new Freelancer(id, name, lvlExp, email, nif, iban, country, adress);
    }

    public Freelancer getFreelancer() {
        return this.frl;
    }

    public boolean registerFreelancer(Freelancer freel) {
        if (this.arrayFreelancers.add(freel)) {
            generateId(freel);
            return true;
        }
        return false;
    }

    public boolean registerFreelancer1(Freelancer freel) {
        if (this.arrayFreelancers.add(freel)) {
            return true;
        }
        return false;
    }

    public void generateId(Freelancer freel1) {
        String array = freel1.getName();
        String[] arrayaux = array.split(" ");
        String nome1 = arrayaux[0];
        String nome2 = arrayaux[1];
        char letra1 = nome1.charAt(0);
        int size = arrayaux.length;
        char letra2 = nome2.charAt(0);
        String id1 = ("" + letra1 + letra2);
        id1 = id1.toUpperCase();
        String numero = compareFreelancer(id1);
        freel1.setId(numero);
    }

    public String compareFreelancer(String id) {
        int num = 1;
        try {
            for (Freelancer freel : arrayFreelancers) {
                String idFrel = freel.getId();
                if ((id + num).equals(idFrel)) {
                    num++;
                }
            }
            return id + num;
        } catch (NullPointerException e) {
            return id + "1";
        }
    }

    public boolean validatesFreelancer(Freelancer freel) {
        if (freel.getAdress() == null || freel.getCountry() == null || freel.getEmail() == null || freel.getIban() == null || freel.getLvlExp() == null || freel.getName() == null || freel.getNif() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void addFreelancer(Freelancer freel) {
        arrayFreelancers.add(freel);
    }

    public List<Freelancer> getListFreelancers() {
        if (arrayFreelancers == null) {
        }
        return arrayFreelancers;
    }

    public List<String> getFreelancersAsStringList() {
        List<String> setFreelancersAsString = new ArrayList<>();
        for (Freelancer freelancer : arrayFreelancers) {
            setFreelancersAsString.add(freelancer.toString());
        }
        return setFreelancersAsString;
    }

    public Freelancer getFreelancerById(String freelancerId) {
        for (Freelancer freelancer : arrayFreelancers) {
            if (freelancer.toString().equals(freelancerId)) {
                return freelancer;
            }
        }
        throw new IllegalArgumentException("Invalid " + freelancerId);
    }

    public Freelancer findByNIF(String freelancerNIF) {
        for (Freelancer freelancer : arrayFreelancers) {
            if (freelancer.getNif().equals(freelancerNIF)) {
                return freelancer;
            }
        }
        return null;
    }

    public Freelancer getFreelancerByStringValue(String freelancerString) {
        for (Freelancer freelancer : arrayFreelancers) {
            if (freelancer.toString().equals(freelancerString)) {
                return freelancer;
            }
        }
        throw new IllegalArgumentException("Invalid " + freelancerString);
    }

    public Date getDateDefined() {
        Calendar dia = Calendar.getInstance();
        dia.set(Calendar.MONTH, 12);
        dia.set(Calendar.DAY_OF_MONTH, 31);
        dia.set(Calendar.HOUR_OF_DAY, 23);
        dia.set(Calendar.MINUTE, 59);
        dia.set(Calendar.SECOND, 30);
        return dia.getTime();
    }

    public void scheduleAutomaticEmail() {
        NotifyFreelancerTask task = new NotifyFreelancerTask();
        Date data = getDateDefined();
        Timer t = new Timer();
        t.schedule(task, data);
    }

    public int getDelay(Freelancer freel3) {
        int delay = 0;
        Platform plat1 = POTApplication.getPlatform();
        FacadeAuthorization facade = POTApplication.getFacadeAuthorization();
        OrganizationsRecord orgRec = plat1.getOrganizationsRecord();
        List<Organization> listOrg = orgRec.getOrganizations();
        for (Organization org1 : listOrg) {
            PaymentTransactionList payTL = org1.getPaymentTransactionList();
            List<PaymentTransaction> payemntTransList1 = payTL.getPaymentTransactions();
            for (int k = 0; k < payemntTransList1.size(); k++) {
                Freelancer frel = payemntTransList1.get(k).getFreelancer();
                if (frel.equals(freel3)) {
                    if (payemntTransList1.get(k).getDelay() > 0) {
                        delay = delay + payemntTransList1.get(k).getDelay();
                    }
                }
            }
        }
        return delay;
    }

    public double getPercentageDelay(Freelancer freel1) {
        int numberTrans = 0;
        int delay = 0;
        Platform plat1 = POTApplication.getPlatform();
        FacadeAuthorization facade = POTApplication.getFacadeAuthorization();
        OrganizationsRecord orgRec = plat1.getOrganizationsRecord();
        List<Organization> listOrg = orgRec.getOrganizations();
        for (Organization org1 : listOrg) {
            PaymentTransactionList payTL = org1.getPaymentTransactionList();
            List<PaymentTransaction> payemntTransList1 = payTL.getPaymentTransactions();
            for (int k = 0; k < payemntTransList1.size(); k++) {
                Freelancer frel = payemntTransList1.get(k).getFreelancer();

                if (frel.equals(freel1)) {
                    numberTrans++;
                    if (payemntTransList1.get(k).getDelay() > 0) {
                        delay++;
                    }
                }
            }
        }
        return (delay / numberTrans) * 100;
    }

    public List<Freelancer> getFreelancersAdapt() throws FileNotFoundException {
        List<Freelancer> freelApt = new ArrayList<>();
        for (int i = 0; i < getListFreelancers().size(); i++) {
            Freelancer freel = getListFreelancers().get(i);
            double delay = getDelay(freel);
            double perDelay = getPercentageDelay(freel);
            double averageDelay = getAverageDelay();
            if (delay > 3 && perDelay > averageDelay) {
                freelApt.add(freel);
            }

        }
        return freelApt;
    }

    /**
     *
     * @param freel
     * @throws FileNotFoundException
     */
    public void sendEmail(Freelancer freel) throws FileNotFoundException {
        try (FileWriter writer = new FileWriter("email.txt", true)) {
            writer.write("The freelancer with the email: " + freel.getEmail() + 
                    "With an average delay of: " + getAverageDelay() + "has"
                            + " with a delay of: " + getDelay(freel) + " and a delay percentage of: " + getPercentageDelay(freel) + "\n");
            writer.close();
        } catch (IOException ex) {
            AlertUI.createAlert(Alert.AlertType.ERROR, "T4J-PAYMENTS", "Error", "Error in sending email!").show();
        }
    }

    public double getAverageDelay() {
        double totalDelay = 0;
        int n = 0;
        Platform plat1 = POTApplication.getPlatform();

        FacadeAuthorization facade = POTApplication.getFacadeAuthorization();
        OrganizationsRecord orgRec = plat1.getOrganizationsRecord();
        List<Organization> listOrg = orgRec.getOrganizations();
        for (Organization org1 : listOrg) {
            PaymentTransactionList payTL = org1.getPaymentTransactionList();
            List<PaymentTransaction> payemntTransList1 = payTL.getPaymentTransactions();
            for (int k = 0; k < payemntTransList1.size(); k++) {
                PaymentTransaction trans = payemntTransList1.get(k);
                int delayTrans = trans.getDelay();
                totalDelay = totalDelay + delayTrans;
                n++;
            }
        }
        return totalDelay / n;
    }

}
