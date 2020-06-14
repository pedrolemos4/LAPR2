/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
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
public class OrganizationTest {

    public OrganizationTest() {
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
     * Test of determinatePayOrg method, of class Organization.
     */
    @Test
    public void testDeterminatePayOrg() {
        System.out.println("determinatePayOrg1");
        Task task1 = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free1 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s1 = new Date();
        PaymentTransaction payT1 = new PaymentTransaction("108", task1, free1, s1.convertStringToDate("25/02/2020"), 1, "Hard Work");
        Task task2 = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free2 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s2 = new Date();
        PaymentTransaction payT2 = new PaymentTransaction("108", task2, free2, s2.convertStringToDate("25/02/2020"), 1, "Very Easy work");
        Task task3 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free3 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s3 = new Date();
        PaymentTransaction payT3 = new PaymentTransaction("101", task3, free3, s3.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        Organization org = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        TreeMap<String, List<Double>> mapOrgPayment = new TreeMap<>();
        TreeMap<String, List<Double>> mapOrgPaymentResult = new TreeMap<>();
        String key = "JW1";
        List<Double> value = new ArrayList<>();
        value.add(payT1.getPayAmount());
        value.add(payT2.getPayAmount());
        value.add(payT3.getPayAmount());
        mapOrgPaymentResult.put(key, value);
        org.getPaymentTransactionList().addPaymentTransaction(payT1);
        org.getPaymentTransactionList().addPaymentTransaction(payT2);
        org.getPaymentTransactionList().addPaymentTransaction(payT3);
        TreeMap<String, List<Double>> expResult = mapOrgPaymentResult;
        TreeMap<String, List<Double>> result = org.determinatePayOrg(mapOrgPayment);
        assertEquals(expResult, result);
    }

    /**
     * Test of determinateDelayOrg method, of class Organization.
     */
    @Test
    public void testDeterminateDelayOrg() {
        System.out.println("determinateDelayOrg2");
        Task task1 = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free1 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s1 = new Date();
        PaymentTransaction payT1 = new PaymentTransaction("108", task1, free1, s1.convertStringToDate("25/02/2020"), 4, "Hard Work");
        Task task2 = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free2 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s2 = new Date();
        PaymentTransaction payT2 = new PaymentTransaction("108", task2, free2, s2.convertStringToDate("25/02/2020"), 7, "Very Easy work");
        Task task3 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free3 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s3 = new Date();
        PaymentTransaction payT3 = new PaymentTransaction("101", task3, free3, s3.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        Organization org = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        TreeMap<String, List<Double>> mapOrgDelay = new TreeMap<>();
        TreeMap<String, List<Double>> mapOrgDelayResult = new TreeMap<>();
        String key = "JW1";
        List<Double> value = new ArrayList<>();
        double delay1 = payT1.getDelay();
        double delay2 = payT2.getDelay();
        double delay3 = payT3.getDelay();
        value.add(delay1);
        value.add(delay2);
        value.add(delay3);
        mapOrgDelayResult.put(key, value);
        org.getPaymentTransactionList().addPaymentTransaction(payT1);
        org.getPaymentTransactionList().addPaymentTransaction(payT2);
        org.getPaymentTransactionList().addPaymentTransaction(payT3);
        TreeMap<String, List<Double>> expResult = mapOrgDelayResult;
        TreeMap<String, List<Double>> result = org.determinateDelayOrg(mapOrgDelay);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcCounterDelays method, of class Organization.
     */
    @Test
    public void testCalcCounterDelays() {
        System.out.println("calcCounterDelays");
        Task task1 = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free1 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s1 = new Date();
        PaymentTransaction payT1 = new PaymentTransaction("108", task1, free1, s1.convertStringToDate("25/02/2020"), 4, "Hard Work");
        Task task2 = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free2 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s2 = new Date();
        PaymentTransaction payT2 = new PaymentTransaction("108", task2, free2, s2.convertStringToDate("25/02/2020"), 7, "Very Easy work");
        Task task3 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free3 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s3 = new Date();
        PaymentTransaction payT3 = new PaymentTransaction("101", task3, free3, s3.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        Organization org = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org.getPaymentTransactionList().addPaymentTransaction(payT1);
        org.getPaymentTransactionList().addPaymentTransaction(payT2);
        org.getPaymentTransactionList().addPaymentTransaction(payT3);
        int expResult = 3;
        int result = org.calcCounterDelays();
        assertEquals(expResult, result);
    }
}
