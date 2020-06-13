package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.model.Freelancer;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.OrganizationsRecord;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransactionList;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import com.mycompany.lapr2_interfacegrafica.model.Task;
import com.mycompany.lapr2_interfacegrafica.model.TaskList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr2.pot.ui.console.utils.Date;

/**
 *
 * @author Joao Mata
 */
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

        //data de hoje que é um dia de pagamento
        Calendar calToday = Calendar.getInstance();
        calToday.setTime(new java.util.Date());
        calToday.set(Calendar.HOUR_OF_DAY, 0);
        calToday.set(Calendar.MINUTE, 0);
        calToday.set(Calendar.SECOND, 0);
        calToday.set(Calendar.MILLISECOND, 0);

        Calendar calLastMonth = (Calendar) calToday.clone();
        calLastMonth.add(Calendar.MONTH, -1);

        //paga-se as transacoes cuja endDate PERTENCA a [calLastMonth, calToday[
        //percorre-se a lista uma primeira vz para colecionar todos os freelancers que tenham pagamentos
        FreelancersRecord frelRec = plat.getFreelancersRecord();
        List<Freelancer> freelancers = frelRec.getListFreelancers();
        for (PaymentTransaction payment : payTL.getPaymentTransactions()) {
            Calendar endDate = Calendar.getInstance();
            Date dataPagamento = payment.getEndDate();
            endDate.set(Calendar.YEAR, dataPagamento.getYear());
            endDate.set(Calendar.MONTH, dataPagamento.getMonth());
            endDate.set(Calendar.DAY_OF_MONTH, dataPagamento.getDay());
            //se estiver entre data do ultimo mes INCLUSIVE e ate data de hoje EXCLUSIVE
            //primeiro obtem-se uma lista dos freelancers que vao ser pagos
            if (endDate.equals(calLastMonth) || endDate.after(calLastMonth) && endDate.before(calToday)) {
                if (!freelancers.contains(payment.getFreelancer())) {
                    freelancers.add(payment.getFreelancer());
                }
            }
        }
        double totalPayment;
        String emailReport;
        //percorre-se todos os freelancers
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

                    //se estiver entre data do ultimo mes INCLUSIVE e ate data de hoje EXCLUSIVE
                    if (endDate.equals(calLastMonth) || endDate.after(calLastMonth) || endDate.before(calToday)) {
                        //processar pagamento
                        totalPayment += payment.getPayAmount();

                        emailReport += "Tarefa: " + payment.getTask().getBriefDescription() + "\n"
                                + "    Amount in Euros: " + payment.getPayAmount() + "\n";
                    }
                }
            }

            emailReport += "Total Amount in Euros: " + totalPayment + "\n\n";
            //executeTransferOrder(payment.getFreelancer().getIban(), payment.getPayAmount());
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
                //processa os pagamentos
                processPayments();
                //agenda para o proximo mes                
                //adiciona um mes ao momento atual
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
            System.out.println("Error in sending email!");
        }
    }
}
