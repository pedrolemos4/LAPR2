package com.mycompany.lapr2_interfacegrafica.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class FreelancersRecord {

    private String id;
    private String name;
    private String lvlExp;
    private String email;
    private int nif;
    private String iban;
    private String country;
    private String adress;

    private Organization org;
    private Platform plat;
    private Freelancer freel;

    private final List<Freelancer> arrayFreelancers;
    private PaymentTransactionList payemntTransList;

    public FreelancersRecord() {
        this.arrayFreelancers = new ArrayList<>();
    }

    public Freelancer newFreelancer(String id, String name, String lvlExp, String email, String nif, String iban, String country, String adress) {
        return new Freelancer(id, name, lvlExp, email, nif, iban, country, adress);
    }

    public boolean registerFreelancer(Freelancer freel) {
        if (this.validatesFreelancer(freel)) {
            addFreelancer(freel);
        }
        return false;
    }

    public boolean validatesFreelancer(Freelancer freel) {
        if (freel.getAdress() == null || freel.getCountry() == null || freel.getEmail() == null || freel.getIban() == null || freel.getId() == null || freel.getLvlExp() == null || freel.getName() == null || freel.getNif() == null) {
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

    public Freelancer freelancerExists(String frlId) {
        for (int i = 0; i < arrayFreelancers.size(); i++) {
            if (arrayFreelancers.get(i).getId().equalsIgnoreCase(frlId)) {
                return arrayFreelancers.get(i);
            }
        }
        return null;
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
    public void sendEmails() {
        int numberTransactions = 0, delay = 0, amountForHourDelay = 0;

        org = plat.getOrganization();
        payemntTransList = org.getPaymentTransactionList();
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
               sendEmail(delay,percentageDelayFreel); 
            }
        }
    }
    
    /**
     * Envia o email
     * @param delay
     * @param percentageDelayFreel 
     */
    public void sendEmail(int delay, int percentageDelayFreel){
        
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
