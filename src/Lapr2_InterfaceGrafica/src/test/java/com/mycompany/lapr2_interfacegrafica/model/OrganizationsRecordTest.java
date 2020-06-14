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
import org.apache.commons.math3.distribution.NormalDistribution;
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
public class OrganizationsRecordTest {

    public OrganizationsRecordTest() {
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
     * Test of determinatePayPlatform method, of class OrganizationsRecord.
     */
    @Test
    public void testDeterminatePayPlatform() {
        System.out.println("determinatePayPlatform");
        OrganizationsRecord orgRec = new OrganizationsRecord();

        //Org1
        Task task1 = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free1 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s1 = new Date();
        PaymentTransaction payT1 = new PaymentTransaction("108", task1, free1, s1.convertStringToDate("25/02/2020"), 4, "Hard Work");
        Task task2 = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free2 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s2 = new Date();
        PaymentTransaction payT2 = new PaymentTransaction("108", task2, free2, s2.convertStringToDate("11/03/2020"), 7, "Very Easy work");
        Task task3 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free3 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s3 = new Date();
        PaymentTransaction payT3 = new PaymentTransaction("101", task3, free3, s3.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        Organization org1 = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org1.getPaymentTransactionList().addPaymentTransaction(payT1);
        org1.getPaymentTransactionList().addPaymentTransaction(payT2);
        org1.getPaymentTransactionList().addPaymentTransaction(payT3);
        orgRec.addOrganization(org1);

        //Org2
        Task task4 = new Task("20", "Apple Application Development", 39, 22, "Software");
        Freelancer free4 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s4 = new Date();
        PaymentTransaction payT4 = new PaymentTransaction("115", task4, free4, s4.convertStringToDate("01/10/2020"), 3, "Work");
        Task task5 = new Task("15", "Windows Application Development", 25, 99, "Development");
        Freelancer free5 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s5 = new Date();
        PaymentTransaction payT5 = new PaymentTransaction("134", task5, free5, s5.convertStringToDate("28/08/2020"), 9, "Very Easy");
        Task task6 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free6 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s6 = new Date();
        PaymentTransaction payT6 = new PaymentTransaction("208", task6, free6, s6.convertStringToDate("14/02/2020"), 7, "Quality");
        Organization org2 = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org2.getPaymentTransactionList().addPaymentTransaction(payT4);
        org2.getPaymentTransactionList().addPaymentTransaction(payT5);
        org2.getPaymentTransactionList().addPaymentTransaction(payT6);
        orgRec.addOrganization(org2);

        TreeMap<String, List<Double>> mapOrgPaymentTest = new TreeMap<>();
        String key1 = "JW1";
        List<Double> value1 = new ArrayList<>();
        value1.add(payT1.getPayAmount());
        value1.add(payT2.getPayAmount());
        value1.add(payT3.getPayAmount());
        mapOrgPaymentTest.put(key1, value1);

        String key2 = "TK7";
        List<Double> value2 = new ArrayList<>();
        value2.add(payT4.getPayAmount());
        value2.add(payT5.getPayAmount());
        value2.add(payT6.getPayAmount());
        mapOrgPaymentTest.put(key2, value2);

        TreeMap<String, List<Double>> expResult = mapOrgPaymentTest;
        TreeMap<String, List<Double>> result = orgRec.determinatePayPlatform();
        assertEquals(expResult, result);
    }

    /**
     * Test of determinatePayOrg method, of class OrganizationsRecord.
     */
    @Test
    public void testDeterminatePayOrg() {
        System.out.println("determinatePayOrg");
        OrganizationsRecord orgRec = new OrganizationsRecord();
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
        orgRec.addOrganization(org);
        TreeMap<String, List<Double>> mapOrgPaymentTest = new TreeMap<>();
        String key = "JW1";
        List<Double> value = new ArrayList<>();
        value.add(payT1.getPayAmount());
        value.add(payT2.getPayAmount());
        value.add(payT3.getPayAmount());
        mapOrgPaymentTest.put(key, value);
        TreeMap<String, List<Double>> expResult = mapOrgPaymentTest;
        TreeMap<String, List<Double>> result = orgRec.determinatePayOrg(org);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcMeanPayment method, of class OrganizationsRecord.
     */
    @Test
    public void testCalcMeanPayment() {
        System.out.println("calcMeanPayment");
        OrganizationsRecord orgRec = new OrganizationsRecord();

        //Org1
        Task task1 = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free1 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s1 = new Date();
        PaymentTransaction payT1 = new PaymentTransaction("108", task1, free1, s1.convertStringToDate("25/02/2020"), 4, "Hard Work");
        Task task2 = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free2 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s2 = new Date();
        PaymentTransaction payT2 = new PaymentTransaction("108", task2, free2, s2.convertStringToDate("11/03/2020"), 7, "Very Easy work");
        Task task3 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free3 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s3 = new Date();
        PaymentTransaction payT3 = new PaymentTransaction("101", task3, free3, s3.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        Organization org1 = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org1.getPaymentTransactionList().addPaymentTransaction(payT1);
        org1.getPaymentTransactionList().addPaymentTransaction(payT2);
        org1.getPaymentTransactionList().addPaymentTransaction(payT3);
        orgRec.addOrganization(org1);

        //Org2
        Task task4 = new Task("20", "Apple Application Development", 39, 22, "Software");
        Freelancer free4 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s4 = new Date();
        PaymentTransaction payT4 = new PaymentTransaction("115", task4, free4, s4.convertStringToDate("01/10/2020"), 3, "Work");
        Task task5 = new Task("15", "Windows Application Development", 25, 99, "Development");
        Freelancer free5 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s5 = new Date();
        PaymentTransaction payT5 = new PaymentTransaction("134", task5, free5, s5.convertStringToDate("28/08/2020"), 9, "Very Easy");
        Task task6 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free6 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s6 = new Date();
        PaymentTransaction payT6 = new PaymentTransaction("208", task6, free6, s6.convertStringToDate("14/02/2020"), 7, "Quality");
        Organization org2 = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org2.getPaymentTransactionList().addPaymentTransaction(payT4);
        org2.getPaymentTransactionList().addPaymentTransaction(payT5);
        org2.getPaymentTransactionList().addPaymentTransaction(payT6);
        orgRec.addOrganization(org2);

        TreeMap<String, List<Double>> mapTotalPayments = new TreeMap<>();
        String key1 = "JW1";
        List<Double> value1 = new ArrayList<>();
        value1.add(payT1.getPayAmount());
        value1.add(payT2.getPayAmount());
        value1.add(payT3.getPayAmount());
        mapTotalPayments.put(key1, value1);

        String key2 = "TK7";
        List<Double> value2 = new ArrayList<>();
        value2.add(payT4.getPayAmount());
        value2.add(payT5.getPayAmount());
        value2.add(payT6.getPayAmount());
        mapTotalPayments.put(key2, value2);

        TreeMap<String, Double> mapTotalPaymentsResult = new TreeMap<>();
        double value4 = (payT1.getPayAmount() + payT2.getPayAmount() + payT3.getPayAmount()) / 3;
        mapTotalPaymentsResult.put(key1, value4);
        double value5 = (payT4.getPayAmount() + payT5.getPayAmount() + payT6.getPayAmount()) / 3;
        mapTotalPaymentsResult.put(key2, value5);

        TreeMap<String, Double> expResult = mapTotalPaymentsResult;
        TreeMap<String, Double> result = orgRec.calcMeanPayment(mapTotalPayments);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcDeviationPayment method, of class OrganizationsRecord.
     */
    @Test
    public void testCalcDeviationPayment() {
        System.out.println("calcDeviationPayment");
        OrganizationsRecord orgRec = new OrganizationsRecord();

        Task task1 = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free1 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s1 = new Date();
        PaymentTransaction payT1 = new PaymentTransaction("108", task1, free1, s1.convertStringToDate("25/02/2020"), 4, "Hard Work");
        Task task2 = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free2 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s2 = new Date();
        PaymentTransaction payT2 = new PaymentTransaction("108", task2, free2, s2.convertStringToDate("11/03/2020"), 7, "Very Easy work");
        Task task3 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free3 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s3 = new Date();
        PaymentTransaction payT3 = new PaymentTransaction("101", task3, free3, s3.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        Organization org1 = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org1.getPaymentTransactionList().addPaymentTransaction(payT1);
        org1.getPaymentTransactionList().addPaymentTransaction(payT2);
        org1.getPaymentTransactionList().addPaymentTransaction(payT3);
        orgRec.addOrganization(org1);

        TreeMap<String, List<Double>> mapTotalPayments = new TreeMap<>();
        String key1 = "JW1";
        List<Double> value1 = new ArrayList<>();
        value1.add(payT1.getPayAmount());
        value1.add(payT2.getPayAmount());
        value1.add(payT3.getPayAmount());
        mapTotalPayments.put(key1, value1);

        TreeMap<String, Double> mapMeanPayments = new TreeMap<>();
        double mean1 = (payT1.getPayAmount() + payT2.getPayAmount() + payT3.getPayAmount()) / 3;
        mapMeanPayments.put(key1, mean1);

        TreeMap<String, Double> mapMeanPaymentsResult = new TreeMap<>();
        double x = Math.pow(payT1.getPayAmount() - mean1, 2) + Math.pow(payT2.getPayAmount() - mean1, 2) + Math.pow(payT3.getPayAmount() - mean1, 2);
        double deviation1 = Math.sqrt(x / 3);
        mapMeanPaymentsResult.put(key1, deviation1);

        TreeMap<String, Double> expResult = mapMeanPaymentsResult;
        TreeMap<String, Double> result = orgRec.calcDeviationPayment(mapTotalPayments, mapMeanPayments);
        assertEquals(expResult, result);
    }

    /**
     * Test of determinateDelayPlatform method, of class OrganizationsRecord.
     */
    @Test
    public void testDeterminateDelayPlatform() {
        System.out.println("determinateDelayPlatform");
        OrganizationsRecord orgRec = new OrganizationsRecord();

        //Org1
        Task task1 = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free1 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s1 = new Date();
        PaymentTransaction payT1 = new PaymentTransaction("108", task1, free1, s1.convertStringToDate("25/02/2020"), 4, "Hard Work");
        Task task2 = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free2 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s2 = new Date();
        PaymentTransaction payT2 = new PaymentTransaction("108", task2, free2, s2.convertStringToDate("11/03/2020"), 7, "Very Easy work");
        Task task3 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free3 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s3 = new Date();
        PaymentTransaction payT3 = new PaymentTransaction("101", task3, free3, s3.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        Organization org1 = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org1.getPaymentTransactionList().addPaymentTransaction(payT1);
        org1.getPaymentTransactionList().addPaymentTransaction(payT2);
        org1.getPaymentTransactionList().addPaymentTransaction(payT3);
        orgRec.addOrganization(org1);

        //Org2
        Task task4 = new Task("20", "Apple Application Development", 39, 22, "Software");
        Freelancer free4 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s4 = new Date();
        PaymentTransaction payT4 = new PaymentTransaction("115", task4, free4, s4.convertStringToDate("01/10/2020"), 3, "Work");
        Task task5 = new Task("15", "Windows Application Development", 25, 99, "Development");
        Freelancer free5 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s5 = new Date();
        PaymentTransaction payT5 = new PaymentTransaction("134", task5, free5, s5.convertStringToDate("28/08/2020"), 9, "Very Easy");
        Task task6 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free6 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s6 = new Date();
        PaymentTransaction payT6 = new PaymentTransaction("208", task6, free6, s6.convertStringToDate("14/02/2020"), 7, "Quality");
        Organization org2 = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org2.getPaymentTransactionList().addPaymentTransaction(payT4);
        org2.getPaymentTransactionList().addPaymentTransaction(payT5);
        org2.getPaymentTransactionList().addPaymentTransaction(payT6);
        orgRec.addOrganization(org2);

        TreeMap<String, List<Double>> mapOrgPaymentTest = new TreeMap<>();
        String key1 = "JW1";
        List<Double> value1 = new ArrayList<>();
        double d1 = payT1.getDelay();
        double d2 = payT2.getDelay();
        double d3 = payT3.getDelay();
        value1.add(d1);
        value1.add(d2);
        value1.add(d3);
        mapOrgPaymentTest.put(key1, value1);

        String key2 = "TK7";
        List<Double> value2 = new ArrayList<>();
        double d4 = payT4.getDelay();
        double d5 = payT5.getDelay();
        double d6 = payT6.getDelay();
        value2.add(d4);
        value2.add(d5);
        value2.add(d6);
        mapOrgPaymentTest.put(key2, value2);

        TreeMap<String, List<Double>> expResult = mapOrgPaymentTest;
        TreeMap<String, List<Double>> result = orgRec.determinateDelayPlatform();
        assertEquals(expResult, result);
    }

    /**
     * Test of determinateDelayOrg method, of class OrganizationsRecord.
     */
    @Test
    public void testDeterminateDelayOrg() {
        System.out.println("determinateDelayOrg");
        OrganizationsRecord orgRec = new OrganizationsRecord();
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
        orgRec.addOrganization(org);
        TreeMap<String, List<Double>> mapOrgPaymentTest = new TreeMap<>();
        String key = "JW1";
        List<Double> value = new ArrayList<>();
        double d1 = payT1.getDelay();
        double d2 = payT2.getDelay();
        double d3 = payT3.getDelay();
        value.add(d1);
        value.add(d2);
        value.add(d3);
        mapOrgPaymentTest.put(key, value);
        TreeMap<String, List<Double>> expResult = mapOrgPaymentTest;
        TreeMap<String, List<Double>> result = orgRec.determinateDelayOrg(org);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcMeanDelay method, of class OrganizationsRecord.
     */
    @Test
    public void testCalcMeanDelay() {
        System.out.println("calcMeanDelay");
        OrganizationsRecord orgRec = new OrganizationsRecord();

        //Org1
        Task task1 = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free1 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s1 = new Date();
        PaymentTransaction payT1 = new PaymentTransaction("108", task1, free1, s1.convertStringToDate("25/02/2020"), 4, "Hard Work");
        Task task2 = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free2 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s2 = new Date();
        PaymentTransaction payT2 = new PaymentTransaction("108", task2, free2, s2.convertStringToDate("11/03/2020"), 7, "Very Easy work");
        Task task3 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free3 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s3 = new Date();
        PaymentTransaction payT3 = new PaymentTransaction("101", task3, free3, s3.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        Organization org1 = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org1.getPaymentTransactionList().addPaymentTransaction(payT1);
        org1.getPaymentTransactionList().addPaymentTransaction(payT2);
        org1.getPaymentTransactionList().addPaymentTransaction(payT3);
        orgRec.addOrganization(org1);

        //Org2
        Task task4 = new Task("20", "Apple Application Development", 39, 22, "Software");
        Freelancer free4 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s4 = new Date();
        PaymentTransaction payT4 = new PaymentTransaction("115", task4, free4, s4.convertStringToDate("01/10/2020"), 3, "Work");
        Task task5 = new Task("15", "Windows Application Development", 25, 99, "Development");
        Freelancer free5 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s5 = new Date();
        PaymentTransaction payT5 = new PaymentTransaction("134", task5, free5, s5.convertStringToDate("28/08/2020"), 9, "Very Easy");
        Task task6 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free6 = new Freelancer("TK7", "Takashi Haruto", "Senior", "jm22@japan.jp", "976451259", "JP120010001234567891", "Japan", "Akibara, Tokyo");
        Date s6 = new Date();
        PaymentTransaction payT6 = new PaymentTransaction("208", task6, free6, s6.convertStringToDate("14/02/2020"), 7, "Quality");
        Organization org2 = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org2.getPaymentTransactionList().addPaymentTransaction(payT4);
        org2.getPaymentTransactionList().addPaymentTransaction(payT5);
        org2.getPaymentTransactionList().addPaymentTransaction(payT6);
        orgRec.addOrganization(org2);

        TreeMap<String, List<Double>> mapTotalDelays = new TreeMap<>();
        String key1 = "JW1";
        List<Double> value1 = new ArrayList<>();
        double d1 = payT1.getDelay();
        double d2 = payT2.getDelay();
        double d3 = payT3.getDelay();
        value1.add(d1);
        value1.add(d2);
        value1.add(d3);
        mapTotalDelays.put(key1, value1);

        String key2 = "TK7";
        List<Double> value2 = new ArrayList<>();
        double d4 = payT4.getDelay();
        double d5 = payT5.getDelay();
        double d6 = payT6.getDelay();
        value2.add(d4);
        value2.add(d5);
        value2.add(d6);
        mapTotalDelays.put(key2, value2);

        TreeMap<String, Double> mapTotalDelaysResult = new TreeMap<>();
        double value4 = (d1 + d2 + d3) / 3;
        mapTotalDelaysResult.put(key1, value4);
        double value5 = (d4 + d5 + d6) / 3;
        mapTotalDelaysResult.put(key2, value5);

        TreeMap<String, Double> expResult = mapTotalDelaysResult;
        TreeMap<String, Double> result = orgRec.calcMeanDelay(mapTotalDelays);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcDeviationDelay method, of class OrganizationsRecord.
     */
    @Test
    public void testCalcDeviationDelay() {
        System.out.println("calcDeviationDelay");
        OrganizationsRecord orgRec = new OrganizationsRecord();

        Task task1 = new Task("15", "Mobile Application Development", 60, 50, "Software Development");
        Freelancer free1 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s1 = new Date();
        PaymentTransaction payT1 = new PaymentTransaction("108", task1, free1, s1.convertStringToDate("25/02/2020"), 4, "Hard Work");
        Task task2 = new Task("15", "Windows Application Development", 100, 37, "Software Development");
        Freelancer free2 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s2 = new Date();
        PaymentTransaction payT2 = new PaymentTransaction("108", task2, free2, s2.convertStringToDate("11/03/2020"), 7, "Very Easy work");
        Task task3 = new Task("1", "Web Development", 48, 20, "Software Development");
        Freelancer free3 = new Freelancer("JW1", "John Wayne", "Junior", "jw@gmail.com", "921654987", "US120010001234567891", "USA", "Street 92, 90, New York");
        Date s3 = new Date();
        PaymentTransaction payT3 = new PaymentTransaction("101", task3, free3, s3.convertStringToDate("24/01/2020"), 1, "High Quality Work");
        Organization org1 = new Organization("isep", "123456789", "manager", "m@o.com", "collab", "c@o.com");
        org1.getPaymentTransactionList().addPaymentTransaction(payT1);
        org1.getPaymentTransactionList().addPaymentTransaction(payT2);
        org1.getPaymentTransactionList().addPaymentTransaction(payT3);
        orgRec.addOrganization(org1);

        TreeMap<String, List<Double>> mapTotalDelays = new TreeMap<>();
        String key1 = "JW1";
        List<Double> value1 = new ArrayList<>();
        double d1 = payT1.getDelay();
        double d2 = payT2.getDelay();
        double d3 = payT3.getDelay();
        value1.add(d1);
        value1.add(d2);
        value1.add(d3);
        mapTotalDelays.put(key1, value1);

        TreeMap<String, Double> mapMeanDelays = new TreeMap<>();
        double value4 = (d1 + d2 + d3) / 3;
        mapMeanDelays.put(key1, value4);

        TreeMap<String, Double> mapMeanDelaysResult = new TreeMap<>();
        double x = Math.pow(d1 - value4, 2) + Math.pow(d2 - value4, 2) + Math.pow(d3 - value4, 2);
        double deviation1 = Math.sqrt(x / 3);
        mapMeanDelaysResult.put(key1, deviation1);

        TreeMap<String, Double> expResult = mapMeanDelaysResult;
        TreeMap<String, Double> result = orgRec.calcDeviationDelay(mapTotalDelays, mapMeanDelays);
        assertEquals(expResult, result);
    }

    /**
     * Test of determinateIntervalsMean method, of class OrganizationsRecord.
     */
    @Test
    public void testDeterminateIntervalsMean() {
        System.out.println("determinateIntervalsMean");
        OrganizationsRecord orgRec = new OrganizationsRecord();
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
        orgRec.addOrganization(org);
        TreeMap<String, List<Double>> map = new TreeMap<>();
        String key = "JW1";
        List<Double> value = new ArrayList<>();
        value.add(payT1.getPayAmount());
        value.add(payT2.getPayAmount());
        value.add(payT3.getPayAmount());
        map.put(key, value);

        double value4 = (payT1.getPayAmount() + payT2.getPayAmount() + payT3.getPayAmount()) / 3;

        double expResult = value4;
        double result = orgRec.determinateIntervalsMean(map);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of determineIntervalsDeviation method, of class OrganizationsRecord.
     */
    @Test
    public void testDetermineIntervalsDeviation() {
        System.out.println("determineIntervalsDeviation");
        OrganizationsRecord orgRec = new OrganizationsRecord();
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
        orgRec.addOrganization(org);
        TreeMap<String, List<Double>> map = new TreeMap<>();
        String key = "JW1";
        List<Double> value = new ArrayList<>();
        value.add(payT1.getPayAmount());
        value.add(payT2.getPayAmount());
        value.add(payT3.getPayAmount());
        map.put(key, value);

        double value4 = (payT1.getPayAmount() + payT2.getPayAmount() + payT3.getPayAmount()) / 3;

        double x = (Math.pow(payT1.getPayAmount() - value4, 2) + Math.pow(payT2.getPayAmount() - value4, 2) + Math.pow(payT3.getPayAmount() - value4, 2));
        double r = Math.sqrt(x / 3);
        double expResult = r;
        double result = orgRec.determineIntervalsDeviation(map);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of determinateNormalDistribution method, of class
     * OrganizationsRecord.
     */
    @Test
    public void testDeterminateNormalDistribution() {
        System.out.println("determinateNormalDistribution");
        OrganizationsRecord orgRec = new OrganizationsRecord();
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
        orgRec.addOrganization(org);
        NormalDistribution normalD = new NormalDistribution(2, Math.sqrt(Math.pow(1.5, 2) / 3));
        double x = 1 - normalD.cumulativeProbability(3);
        double expResult = x;
        double result = orgRec.determinateNormalDistribution();
        assertEquals(expResult, result, 0.0);
    }
}
