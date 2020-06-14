/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.model;

import lapr2.pot.ui.console.utils.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josep
 */
public class PaymentTransactionTest {

    public PaymentTransactionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of generatePayAmount method, of class PaymentTransaction.
     */
    @Test
    public void testGeneratePayAmount1() {
        System.out.println("generatePayAmount1");
        Task task = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s = new Date();
        PaymentTransaction instance = new PaymentTransaction("101", task, free, s.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        double expResult = 960.0;
        double result = instance.generatePayAmount(task, free);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of generatePayAmount method, of class PaymentTransaction.
     */
    @Test
    public void testGeneratePayAmount2() {
        System.out.println("generatePayAmount2");
        Task task = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free = new Freelancer("MS3", "Maria Sousa", "Senior", "ms10@isep.ipp.pt", "213456789", "PT120010001234567891", "Portugal", "Rua Santo António, 54, Porto");
        Date s = new Date();
        PaymentTransaction instance = new PaymentTransaction("108", task, free, s.convertStringToDate("25/02/2020"), 1, "Hard Work");
        double expResult = 6000.0;
        double result = instance.generatePayAmount(task, free);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of generatePayAmount method, of class PaymentTransaction.
     */
    @Test
    public void testGeneratePayAmount3() {
        System.out.println("generatePayAmount3");
        Task task = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s = new Date();
        PaymentTransaction instance = new PaymentTransaction("108", task, free, s.convertStringToDate("25/02/2020"), 1, "Very Easy work");
        double expResult = 7400.0;
        double result = instance.generatePayAmount(task, free);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of convertPayAmount method, of class PaymentTransaction.
     */
    @Test
    public void testConvertPayAmount1() {
        System.out.println("convertPayAmount1");
        Task task = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s = new Date();
        PaymentTransaction payT = new PaymentTransaction("101", task, free, s.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        PaymentTransaction instance = payT;
        double expResult = 1084.8;
        double result = instance.convertPayAmount(payT);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of convertPayAmount method, of class PaymentTransaction.
     */
    @Test
    public void testConvertPayAmount2() {
        System.out.println("convertPayAmount2");
         Task task = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free = new Freelancer("MS3", "Maria Sousa", "Senior", "ms10@isep.ipp.pt", "213456789", "PT120010001234567891", "Portugal", "Rua Santo António, 54, Porto");
        Date s = new Date();
        PaymentTransaction payT = new PaymentTransaction("108", task, free, s.convertStringToDate("25/02/2020"), 1, "Hard Work");
        PaymentTransaction instance = payT;
        double expResult = 6000.0;
        double result = instance.convertPayAmount(payT);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of convertPayAmount method, of class PaymentTransaction.
     */
    @Test
    public void testConvertPayAmount3() {
        System.out.println("convertPayAmount3");
        Task task = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s = new Date();
        PaymentTransaction payT = new PaymentTransaction("108", task, free, s.convertStringToDate("25/02/2020"), 1, "Very Easy work");
        PaymentTransaction instance = payT;
        double expResult = 894142.0;
        double result = instance.convertPayAmount(payT);
        assertEquals(expResult, result, 0.0);
    }
}
