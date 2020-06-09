package com.mycompany.lapr2_interfacegrafica.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class FreelancersRecord {

    public String id;
    public String name;
    public String lvlExp;
    public String email;
    public int nif;
    public String iban;
    public String country;
    public String adress;

    public Organization org;
    public Platform plat;
    public Freelancer freel;

    public List<Freelancer> arrayFreelancers;
    public PaymentTransactionList payemntTransList;

    public FreelancersRecord() {
        this.arrayFreelancers = new ArrayList<>();
    }

    public Freelancer newFreelancer(String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        return new Freelancer(name, lvlExp, email, nif, iban, country, adress);
    }

    public boolean registerFreelancer(Freelancer freel) {
        if (this.validatesFreelancer(freel)) {
            addFreelancer(freel);
        }
        return false;
    }

    public String compareFreelancer(String id) {
        int num = 1;
        for (Freelancer freel : arrayFreelancers) {
            String idFrel = freel.getId();
            if ((id + num).equals(idFrel)) {
                num++;
            }
        }
        return id + num;
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
        throw new IllegalArgumentException("Invalid " + freelancerNIF);
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

    /**
     * Seleciona os freelancers
     */
    public void sendEmails() throws FileNotFoundException {
        int numberTransactions = 0, delay = 0, amountForHourDelay = 0;

        payemntTransList = plat.getPaymentTransactionList();
        List<PaymentTransaction> payemntTransList1 = payemntTransList.getPaymentTransactions();
        for (int i = 0; i < arrayFreelancers.size(); i++) {
            Freelancer freel = arrayFreelancers.get(i);
            for (int k = 0; k < payemntTransList1.size(); k++) {
                PaymentTransaction trans = payemntTransList1.get(k);
                Freelancer freelTrans = payemntTransList1.get(k).getM_oFreelancer();
                if (freel == freelTrans) {
                    numberTransactions++;
                    int delayTrans = trans.getM_Delay();
                    if (delayTrans > 0) {
                        delay++;
                        amountForHourDelay++;
                    }
                }
            }
            int percentageDelayFreel = delay / numberTransactions;
            double averageDelay = getAverageDelay();
            if (delay > 3 && percentageDelayFreel > averageDelay) {
                freel.getEmail();
                sendEmail(delay, percentageDelayFreel, freel.getEmail());
            }
        }
    }

    /**
     * Envia o email para o ficheiro email.txt
     *
     * @param delay
     * @param percentageDelayFreel
     */
    public void sendEmail(int delay, int percentageDelayFreel, String email) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("email.txt"));
        String fileContent = String.format("O freelancer com o email: %n, tem um delay de %d e uma percentagem de delay de %d.", email, delay, percentageDelayFreel);
        out.printf(fileContent);
        out.close();
    }

    public double getAverageDelay() {
        int totalDelay = 0, n = 0;
        List<PaymentTransaction> payemntTransList1 = payemntTransList.getPaymentTransactions();
        for (int k = 0; k < payemntTransList1.size(); k++) {
            PaymentTransaction trans = payemntTransList1.get(k);
            int delayTrans = trans.getM_Delay();
            totalDelay = totalDelay + delayTrans;
            n++;
        }
        return totalDelay / n;
    }

}
