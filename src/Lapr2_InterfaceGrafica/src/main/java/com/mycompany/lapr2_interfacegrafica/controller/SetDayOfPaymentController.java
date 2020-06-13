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
        System.out.println("Inicio do metodo setProcessPaymentsDay");
        //date de hoje
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());

        cal.set(Calendar.DAY_OF_MONTH, paymentDay);

        timer = new Timer();
        System.out.println("Antes do setNextProcessement");
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
        System.out.println("Inicio de processPayments");
        Platform plat = POTApplication.getPlatform();
        System.out.println("1");
        FacadeAuthorization facade = POTApplication.getFacadeAuthorization();
        System.out.println("2");
        String email = facade.getCurrentSession().getUser().getEmail();
        System.out.println("3");
        OrganizationsRecord orgRec = plat.getOrganizationsRecord();
        System.out.println("3");
        Organization m_Organization = orgRec.getOrganizationByUserEmail(email);
        System.out.println("4");
        PaymentTransactionList payTL = m_Organization.getPaymentTransactionList();
        System.out.println("5");

        //data de hoje que é um dia de pagamento
        Calendar calToday = Calendar.getInstance();
        System.out.println("6");
        calToday.setTime(new java.util.Date());
        System.out.println("7");
        calToday.set(Calendar.HOUR_OF_DAY, 0);
        System.out.println("8");
        calToday.set(Calendar.MINUTE, 0);
        System.out.println("9");
        calToday.set(Calendar.SECOND, 0);
        System.out.println("10");
        calToday.set(Calendar.MILLISECOND, 0);
        System.out.println("11");

        Calendar calLastMonth = (Calendar) calToday.clone();
        System.out.println("12");
        calLastMonth.add(Calendar.MONTH, -1);
        System.out.println("13");

        //paga-se as transacoes cuja endDate PERTENCA a [calLastMonth, calToday[
        //percorre-se a lista uma primeira vz para colecionar todos os freelancers que tenham pagamentos
        FreelancersRecord frelRec = plat.getFreelancersRecord();

        List<Freelancer> freelancers = frelRec.getListFreelancers();

        System.out.println("14");
        for (PaymentTransaction payment : payTL.getPaymentTransactions()) {
            System.out.println("15");
            Calendar endDate = Calendar.getInstance();
            System.out.println("16");
            Date dataPagamento = payment.getEndDate();
            System.out.println("17");
            endDate.set(Calendar.YEAR, dataPagamento.getYear());
            System.out.println("18");
            endDate.set(Calendar.MONTH, dataPagamento.getMonth());
            System.out.println("19");
            endDate.set(Calendar.DAY_OF_MONTH, dataPagamento.getDay());
            System.out.println("20");

            //se estiver entre data do ultimo mes INCLUSIVE e ate data de hoje EXCLUSIVE
            //primeiro obtem-se uma lista dos freelancers que vao ser pagos
            if (endDate.equals(calLastMonth) || endDate.after(calLastMonth) && endDate.before(calToday)) {
                System.out.println("21");
                if (!freelancers.contains(payment.getFreelancer())) {
                    System.out.println("22");
                    freelancers.add(payment.getFreelancer());
                    System.out.println("23");
                }
                System.out.println("24");
            }
            System.out.println("25");
        }
        System.out.println("26");
        double totalPayment;
        System.out.println("27");
        String emailReport;
        System.out.println("28");
        //percorre-se todos os freelancers
        for (Freelancer freelancer : freelancers) {
            System.out.println("29");
            totalPayment = 0;
            System.out.println("30");
            emailReport = "";
            System.out.println("31");
            for (PaymentTransaction payment : payTL.getPaymentTransactions()) {
                System.out.println("32");
                if (payment.getFreelancer().equals(freelancer)) {
                    System.out.println("33");

                    Calendar endDate = Calendar.getInstance();
                    System.out.println("34");
                    Date dataPagamento = payment.getEndDate();
                    System.out.println("35");
                    endDate.set(Calendar.YEAR, dataPagamento.getYear());
                    System.out.println("36");
                    endDate.set(Calendar.MONTH, dataPagamento.getMonth());
                    System.out.println("37");
                    endDate.set(Calendar.DAY_OF_MONTH, dataPagamento.getDay());
                    System.out.println("38");

                    //se estiver entre data do ultimo mes INCLUSIVE e ate data de hoje EXCLUSIVE
                    if (endDate.equals(calLastMonth) || endDate.after(calLastMonth) || endDate.before(calToday)) {
                        System.out.println("39");
                        //processar pagamento
                        totalPayment += payment.getPayAmount();
                        System.out.println("40");

                        emailReport += "Tarefa: " + payment.getTask().getBriefDescription() + "\n"
                                + "    Amount in Euros: " + payment.getPayAmount() + "\n";
                        System.out.println("41");
                    }
                    System.out.println("42");
                }
                System.out.println("43");
            }
            System.out.println("44");

            emailReport += "Total Amount in Euros: " + totalPayment + "\n\n";
            //executeTransferOrder(payment.getFreelancer().getIban(), payment.getPayAmount());
            System.out.println("Antes do metodo send email");
            sendEmail(freelancer.getEmail(), emailReport);
        }
    }

    /**
     * Define o timer e agenda o proximo dia de pagamento
     *
     * @param cal
     */
    private void setNextProcessment(final Calendar cal) {
        System.out.println("Inicio de setNextProcessment");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //processa os pagamentos
                System.out.println("antes de processPayments");
                processPayments();
                //agenda para o proximo mes                
                //adiciona um mes ao momento atual
                cal.add(Calendar.MONTH, 1);
                setNextProcessment(cal);
            }

        }, new java.util.Date(cal.getTimeInMillis()));
    }

    public void sendEmail(String email, String report) {
        System.out.println("antes do send email");
        try (FileWriter writer = new FileWriter("email.txt", true)) {
            writer.write("Email: " + email + "\nValue: " + report + "\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error in sending email!");
        }
    }
//        PrintWriter out = null;
//        try {
//            out = new PrintWriter(new File("email.txt"));
//            String fileContent = String.format("EMail: %s\n\nConteúdo:\n%s\n\n", email, report);
//            out.printf(fileContent);
//            out.close();
//        } catch (FileNotFoundException ex) {
//
//        } finally {
//            out.close();
//        }
}
