package com.mycompany.lapr2_interfacegrafica.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import lapr2.pot.ui.console.utils.Date;

/**
 *
 * @author beatr
 */
public class CsvReader implements FileReader {
    private PaymentTransactionList m_paymentTransactionList;
    private FreelancersRecord m_freelancerRecord;
    private TaskList m_taskList;
    private String m_namefile;
    
    Scanner ler;

    public CsvReader(PaymentTransactionList paymentTransactionList, FreelancersRecord freelancerRecord ,TaskList taskList) {
        if ( (paymentTransactionList == null) || (freelancerRecord == null) || (taskList == null))
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
   
        this.m_paymentTransactionList = paymentTransactionList;
        this.m_freelancerRecord = freelancerRecord;
        this.m_taskList = taskList;
    }
    
    
    public boolean readNewFile() {
        try {
            File m_file = new File(m_namefile);
            if(!m_file.exists() || !ler.hasNextLine()){
                return false;
            }
            ler = new Scanner(m_file);
            readFile(ler);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;            
        }
    }
    
    public void readFile(Scanner ler){
        Task task;
        Freelancer free;
        String transactionId, freeNIF, taskId;
        int invalidLine = 0, validLine = 0;
        
        String line = ler.nextLine();
        while(ler.hasNextLine()){
            String[] items = ler.nextLine().split(";");
            if(items.length != 17){
                invalidLine++;
                continue;
            }
            try{
            transactionId = items[0];
            if(m_paymentTransactionList.exists(transactionId)){
                invalidLine++;
                continue;
            }
            taskId = items[1];
            task = m_taskList.findById(taskId);
            if(task == null){
                task = newTask(taskId,items);
                if(m_taskList.validateTask(task)){
                    m_taskList.registerTask(task);
                }else{
                    invalidLine++;
                    continue;
                }
            }
            freeNIF = items[13];
            free = m_freelancerRecord.findByNIF(freeNIF);
            if(free == null){
                free = newFreelancer(freeNIF,items);
                if(m_freelancerRecord.validatesFreelancer(free)){
                    m_freelancerRecord.registerFreelancer(free);
                }else{
                    invalidLine++;
                    continue;
                }
            }
            Date m_strEndDate = parseDate(items[6]);
            int m_Delay = Integer.parseInt(items[7]);
            String m_strWorkQualityDescription = items[8];
            
            //creates paymentTransaction
            PaymentTransaction payTransaction = m_paymentTransactionList.newPaymentTransaction(transactionId, task,
                    free, m_strEndDate, m_Delay, m_strWorkQualityDescription);
            if(m_paymentTransactionList.validatePaymentTransaction(payTransaction)){
                m_paymentTransactionList.paymentTransactionRegister(payTransaction);
                validLine++;
            }
            
            }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex){
                ex.printStackTrace();
            }
        }
    }
    
    private Task newTask(String taskId,String[] items){
        String briefDescription;
        int timeDuration;
        double costPerHour;
        String category;
            briefDescription = items[2];
            timeDuration = Integer.parseInt(items[3]);
            costPerHour = Double.parseDouble(items[4]);
            category = items[5];
        return m_taskList.newTask(taskId,briefDescription,timeDuration,costPerHour,
        category);
    }
    
    private Freelancer newFreelancer(String freeNIF, String[] items){
        String id = items[9];
        String name = items[10];
        String lvlExp = items[11];
        String email = items[12];
        String iban = items[14];
        String country = items [16];
        String adress = items[15];
        return m_freelancerRecord.newFreelancer(id, name, lvlExp, email, freeNIF, iban, country, adress);
    }
    
    private Date parseDate(String date){
        String[] arrayDate = date.split("-");
        int day, month, year;
        day = Integer.parseInt(arrayDate[0]);
        month = Integer.parseInt(arrayDate[1]);
        year = Integer.parseInt(arrayDate[2]);
        return new Date(year,month, day);
    }
    
}
