/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Tiago
 */
public class SetDayOfPaymentController {
    Timer timer;
    
    
    



    void setProcessPaymentsTimer(int paymentDay){    
            
        //date de hoje
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        
        cal.set(Calendar.DAY_OF_MONTH, paymentDay);
        
        
        timer = new Timer();
        cal.add(Calendar.MONTH,-1);//para testar usar Calendar.MINUTE
        setNextProcessment(cal);
    }
    
    private void processPayments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setNextProcessment(final Calendar cal) {
        cal.add(Calendar.MONTH,1);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                processPayments();
                setNextProcessment(cal);
            }

        }, new Date(cal.getTimeInMillis()));
    }
    
}
