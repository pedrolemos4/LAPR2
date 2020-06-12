package com.mycompany.lapr2_interfacegrafica.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import lapr2.pot.ui.console.utils.Date;

/**
 *
 * @author beatr
 */
public class TxtReader implements FileReader {

    private PaymentTransactionList m_paymentTransactionList;
    private FreelancersRecord m_freelancerRecord;
    private TaskList m_taskList;
    boolean fileExists;
    Scanner ler;

    public TxtReader(PaymentTransactionList paymentTransactionList, FreelancersRecord freelancerRecord, TaskList taskList) {
        if ((paymentTransactionList == null) || (freelancerRecord == null) || (taskList == null)) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.m_paymentTransactionList = paymentTransactionList;
        this.m_freelancerRecord = freelancerRecord;
        this.m_taskList = taskList;
    }

    public void readNewFile(File m_namefile) {
        try {
            ler = new Scanner(m_namefile);
            fileExists = true;
            readFile(ler);
        } catch (FileNotFoundException ex) {
            fileExists = false;
            System.out.println("File Not Found!");
        }
    }

    public boolean readFile(Scanner ler) {
        if (!fileExists || !ler.hasNextLine()) {
            return false;
        } else {
            Task task;
            Freelancer free;
            String transactionId, freeNIF, taskId;
            int invalidLine = 0, validLine = 0;
            String line = ler.nextLine();
            
            while (ler.hasNextLine()) {
                
                String[]items = ler.nextLine().split(" ");
                               
                if (items.length != 17) {
                    invalidLine++;
                    continue;
                }
                try {
                    transactionId = items[0];
                    if (m_paymentTransactionList.exists(transactionId)) {
                        invalidLine++;
                        continue;
                    }
                    taskId = items[1];
                    task = m_taskList.findById(taskId);
                    if (task == null) {
                        task = newTask(taskId, items);
                        if (m_taskList.registerTask(task)) {
                            return true;//m_taskList.registerTask(task);
                        } else {
                            invalidLine++;
                            continue;
                        }
                    }
                    freeNIF = items[13];
                    free = m_freelancerRecord.findByNIF(freeNIF);
                    if (free == null) {
                        free = newFreelancer(freeNIF, items);
                        if (m_freelancerRecord.validatesFreelancer(free)) {
                            m_freelancerRecord.registerFreelancer(free);
                        } else {
                            invalidLine++;
                            continue;
                        }
                    }

                    //creates paymentTransaction
                    PaymentTransaction payTransaction = m_paymentTransactionList.newPaymentTransaction1(transactionId,
                            task,free, parseDate(items[6]), Integer.parseInt(items[7]), items[8]);
                    if (m_paymentTransactionList.validatePaymentTransaction(payTransaction)) {
//m_paymentTransactionList.validatePaymentTransaction(payTransaction)) {
                        m_paymentTransactionList.paymentTransactionRegister(payTransaction);
                        validLine++;
//                        return true;// m_paymentTransactionList.paymentTransactionRegister(payTransaction);
                        //validLine++;
                    }
                    
                } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
                    ex.printStackTrace();
                    continue;
                }
            }
            return !fileExists;
        }
    }

    private Task newTask(String taskId, String[] items) {
        return m_taskList.newTask(taskId, items[2], Integer.parseInt(items[3]),
                Double.parseDouble(items[4]),items[5]);
    }

    private Freelancer newFreelancer(String freeNIF, String[] items) {
        return m_freelancerRecord.newFreelancer1(items[9],items[10], items[11],
                items[12], freeNIF, items[14], items[16], items[15]);
    }

    private Date parseDate(String date) {
        String[] arrayDate = date.split("-");
        int day, month, year;
        day = Integer.parseInt(arrayDate[0]);
        month = Integer.parseInt(arrayDate[1]);
        year = Integer.parseInt(arrayDate[2]);
        return new Date(year, month, day);
    }

}
