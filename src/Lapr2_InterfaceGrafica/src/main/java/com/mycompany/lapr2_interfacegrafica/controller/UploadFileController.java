package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.CsvReader;
import com.mycompany.lapr2_interfacegrafica.model.FileReader;
import com.mycompany.lapr2_interfacegrafica.model.FreelancersRecord;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransactionList;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import com.mycompany.lapr2_interfacegrafica.model.TaskList;
import com.mycompany.lapr2_interfacegrafica.model.TxtReader;

/**
 *
 * @author beatr
 */
public class UploadFileController {
    private Organization m_Organization;
    private Platform m_Platform;

    public UploadFileController() {
        
    }
    
    public boolean getFileCsv(){
        PaymentTransactionList paymentTransactionLst = m_Organization.getPaymentTransactionList();
        FreelancersRecord freeRec = m_Platform.getFreelancersRecord();
        TaskList taskLst = m_Organization.getTaskList();
        FileReader type1 = new CsvReader(paymentTransactionLst, freeRec, taskLst);
        return type1.readNewFile();
    }
    
    public boolean getFileTxt(){
        PaymentTransactionList paymentTransactionLst = m_Organization.getPaymentTransactionList();
        FreelancersRecord freeRec = m_Platform.getFreelancersRecord();
        TaskList taskLst = m_Organization.getTaskList();
        FileReader type1 = new TxtReader(paymentTransactionLst, freeRec, taskLst);
        return type1.readNewFile();
    }
    
}
