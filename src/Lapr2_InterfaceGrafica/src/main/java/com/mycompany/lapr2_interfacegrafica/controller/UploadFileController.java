package com.mycompany.lapr2_interfacegrafica.controller;

import com.mycompany.lapr2_interfacegrafica.model.CsvReader;
import com.mycompany.lapr2_interfacegrafica.model.FileReader;
import com.mycompany.lapr2_interfacegrafica.model.Organization;
import com.mycompany.lapr2_interfacegrafica.model.PaymentTransaction;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import com.mycompany.lapr2_interfacegrafica.model.TxtReader;
import java.io.File;
import java.util.List;

/**
 *
 * @author beatr
 */
public class UploadFileController {
    private Organization m_Organization;
    private Platform m_Platform;

    public UploadFileController() {
        
    }
    
    public void getFileCsv(File nameFile){
        FileReader type1 = new CsvReader(nameFile);
        type1.readFile();
    }
    
    public void getFileTxt(File nameFile){
        FileReader type1 = new TxtReader(nameFile);
        type1.readFile();
    }
    
    public List<PaymentTransaction> getTransactions(){
        return m_Organization.getPaymentTransactionList().getPaymentTransactions();
    }
}
