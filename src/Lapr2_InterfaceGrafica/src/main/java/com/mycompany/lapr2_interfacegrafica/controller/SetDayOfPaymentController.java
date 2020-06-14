package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransactionList;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import com.mycompany.lapr2_interfacegrafica.ui.AlertUI;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Alert;
import lapr2.pot.ui.console.utils.Date;

public class SetDayOfPaymentController {

    Timer timer;

    /**
     * Define um dia para execucao dos pagamentos inicia um timer e agenda o
     * primeiro pagamento para o proximo dia
     *
     * @param paymentDay dia do mes pretendido, por exemplo dia 10
     */
    public void setProcessPaymentsDay(int paymentDay) {
        //date de hoje
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());

        cal.set(Calendar.DAY_OF_MONTH, paymentDay);

        timer = new Timer();
        setNextProcessment(cal);
    }

    /**
     * Processar todos os payments entre o dia de pagamento anterior INCLUSIVE
     * ate ao dia de pagamento atual EXCLUSIVE
     *
     * Assume que nenhum deles esta pago
     *
     * @param
     */
    private void processPayments() {
        Platform plat = POTApplication.getPlatform();
        FacadeAuthorization facade = POTApplication.getFacadeAuthorization();
        String email = facade.getCurrentSession().getUser().getEmail();
        OrganizationsRecord orgRec = plat.getOrganizationsRecord();
        Organization m_Organization = orgRec.getOrganizationByUserEmail(email);
        PaymentTransactionList payTL = m_Organization.getPaymentTransactionList();

        Calendar calToday = Calendar.getInstance();
        calToday.setTime(new java.util.Date());
        calToday.set(Calendar.HOUR_OF_DAY, 0);
        calToday.set(Calendar.MINUTE, 0);
        calToday.set(Calendar.SECOND, 0);
        calToday.set(Calendar.MILLISECOND, 0);

        Calendar calLastMonth = (Calendar) calToday.clone();
        calLastMonth.add(Calendar.MONTH, -1);

        FreelancersRecord frelRec = plat.getFreelancersRecord();
        List<Freelancer> freelancers = frelRec.getListFreelancers();
        for (PaymentTransaction payment : payTL.getPaymentTransactions()) {
            Calendar endDate = Calendar.getInstance();
            Date dataPagamento = payment.getEndDate();
            endDate.set(Calendar.YEAR, dataPagamento.getYear());
            endDate.set(Calendar.MONTH, dataPagamento.getMonth());
            endDate.set(Calendar.DAY_OF_MONTH, dataPagamento.getDay());
            if (endDate.equals(calLastMonth) || endDate.after(calLastMonth) && endDate.before(calToday)) {
                if (!freelancers.contains(payment.getFreelancer())) {
                    freelancers.add(payment.getFreelancer());
                }
            }
        }
        double totalPayment;
        String emailReport;
        for (Freelancer freelancer : freelancers) {
            totalPayment = 0;
            emailReport = "";
            for (PaymentTransaction payment : payTL.getPaymentTransactions()) {
                if (payment.getFreelancer().equals(freelancer)) {

                    Calendar endDate = Calendar.getInstance();
                    Date dataPagamento = payment.getEndDate();
                    endDate.set(Calendar.YEAR, dataPagamento.getYear());
                    endDate.set(Calendar.MONTH, dataPagamento.getMonth());
                    endDate.set(Calendar.DAY_OF_MONTH, dataPagamento.getDay());

                    if (endDate.equals(calLastMonth) || endDate.after(calLastMonth) || endDate.before(calToday)) {
                        totalPayment += payment.getPayAmount();

                        emailReport += "Tarefa: " + payment.getTask().getBriefDescription() + "\n"
                                + "    Amount in Euros: " + payment.getPayAmount() + "\n";
                    }
                }
            }

            emailReport += "Total Amount in Euros: " + totalPayment + "\n\n";
            sendEmail(freelancer.getEmail(), emailReport);
        }
    }

    /**
     * Define o timer e agenda o proximo dia de pagamento
     *
     * @param cal
     */
    private void setNextProcessment(final Calendar cal) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                processPayments();
                cal.add(Calendar.MONTH, 1);
                setNextProcessment(cal);
            }

        }, new java.util.Date(cal.getTimeInMillis()));
    }

    public void sendEmail(String email, String report) {
        try (FileWriter writer = new FileWriter("email.txt", true)) {
            writer.write("Email: " + email + "\nValue: " + report + "\n");
            writer.close();
        } catch (IOException ex) {
            AlertUI.createAlert(Alert.AlertType.ERROR, "T4J-PAYMENTS", "Unsuccess",
                    "Error sending email!").show();
        }
    }
}
