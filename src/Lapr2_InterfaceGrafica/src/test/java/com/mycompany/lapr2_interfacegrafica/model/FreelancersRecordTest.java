/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lapr2_interfacegrafica.model;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class FreelancersRecordTest {

    public FreelancersRecordTest() {
    }

    /**
     * Test of newFreelancer method, of class FreelancersRecord.
     */
    @Test
    public void testNewFreelancer() {
        System.out.println("newFreelancer");
        String name = "Joao Queiroz";
        String lvlExp = "Senior";
        String email = "joao@gmail.com";
        String nif = "321456987";
        String iban = "US251478924";
        String country = "USA";
        String adress = "Street 45";
        Freelancer freel = new Freelancer(name, lvlExp, email, nif, iban, country, adress);
        FreelancersRecord instance = new FreelancersRecord();
        Freelancer expResult = freel;
        Freelancer result = instance.newFreelancer(name, lvlExp, email, nif, iban, country, adress);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of newFreelancer1 method, of class FreelancersRecord.
     */
    @Test
    public void testNewFreelancer1() {
        System.out.println("newFreelancer1");
        String id = "";
        String name = "";
        String lvlExp = "";
        String email = "";
        String nif = "";
        String iban = "";
        String country = "";
        String adress = "";
        FreelancersRecord instance = new FreelancersRecord();
        Freelancer expResult = null;
        Freelancer result = instance.newFreelancer1(id, name, lvlExp, email, nif, iban, country, adress);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of getFreelancer method, of class FreelancersRecord.
//     */
//    @Test
//    public void testGetFreelancer() {
//        System.out.println("getFreelancer");
//        FreelancersRecord instance = new FreelancersRecord();
//        Freelancer expResult = null;
//        Freelancer result = instance.getFreelancer();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of registerFreelancer method, of class FreelancersRecord.
     */
    @Test
    public void testRegisterFreelancer() {
        System.out.println("registerFreelancer");
        String name = "Joao Queiroz";
        String lvlExp = "Senior";
        String email = "joao@gmail.com";
        String nif = "321456987";
        String iban = "US251478924";
        String country = "USA";
        String adress = "Street 45";
        Freelancer freel = new Freelancer(name, lvlExp, email, nif, iban, country, adress);
        FreelancersRecord instance = new FreelancersRecord();
        boolean expResult = true;
        boolean result = instance.registerFreelancer(freel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registerFreelancer1 method, of class FreelancersRecord.
     */
    @Test
    public void testRegisterFreelancer1() {
        System.out.println("registerFreelancer1");
        String name = "Joao Queiroz";
        String lvlExp = "Senior";
        String email = "joao@gmail.com";
        String nif = "321456987";
        String iban = "US251478924";
        String country = "USA";
        String adress = "Street 45";
        Freelancer freel = new Freelancer(name, lvlExp, email, nif, iban, country, adress);
        FreelancersRecord instance = new FreelancersRecord();
        boolean expResult = true;
        boolean result = instance.registerFreelancer1(freel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generateId method, of class FreelancersRecord.
     */
    @Test
    public void testGenerateId() {
        System.out.println("generateId");
        String name = "Joao Queiroz";
        String lvlExp = "Senior";
        String email = "joao@gmail.com";
        String nif = "321456987";
        String iban = "US251478924";
        String country = "USA";
        String adress = "Street 45";
        Freelancer freel = new Freelancer(name, lvlExp, email, nif, iban, country, adress);
        FreelancersRecord instance = new FreelancersRecord();
        instance.generateId(freel);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of compareFreelancer method, of class FreelancersRecord.
     */
    @Test
    public void testCompareFreelancer() {
        System.out.println("compareFreelancer");
        String id = "";
        FreelancersRecord instance = new FreelancersRecord();
        String expResult = "";
        String result = instance.compareFreelancer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validatesFreelancer method, of class FreelancersRecord.
     */
    @Test
    public void testValidatesFreelancer() {
        System.out.println("validatesFreelancer");
        String name = "Joao Queiroz";
        String lvlExp = "Senior";
        String email = "joao@gmail.com";
        String nif = "321456987";
        String iban = "US251478924";
        String country = "USA";
        String adress = "Street 45";        
        Freelancer freel = new Freelancer(name, lvlExp, email, nif, iban, country, adress);
        FreelancersRecord instance = new FreelancersRecord();
        boolean expResult = true;
        boolean result = instance.validatesFreelancer(freel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addFreelancer method, of class FreelancersRecord.
     */
    @Test
    public void testAddFreelancer() {
        System.out.println("addFreelancer");
        String name = "Joao Queiroz";
        String lvlExp = "Senior";
        String email = "joao@gmail.com";
        String nif = "321456987";
        String iban = "US251478924";
        String country = "USA";
        String adress = "Street 45";        
        Freelancer freel = new Freelancer(name, lvlExp, email, nif, iban, country, adress);
        FreelancersRecord instance = new FreelancersRecord();
        instance.addFreelancer(freel);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of getListFreelancers method, of class FreelancersRecord.
//     */
//    @Test
//    public void testGetListFreelancers() {
//        System.out.println("getListFreelancers");
//        FreelancersRecord instance = new FreelancersRecord();
//        List<Freelancer> expResult = null;
//        List<Freelancer> result = instance.getListFreelancers();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of getFreelancersAsStringList method, of class FreelancersRecord.
//     */
//    @Test
//    public void testGetFreelancersAsStringList() {
//        System.out.println("getFreelancersAsStringList");
//        FreelancersRecord instance = new FreelancersRecord();
//        List<String> expResult = null;
//        List<String> result = instance.getFreelancersAsStringList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of getFreelancerById method, of class FreelancersRecord.
//     */
//    @Test
//    public void testGetFreelancerById() {
//        System.out.println("getFreelancerById");
//        String freelancerId = "";
//        FreelancersRecord instance = new FreelancersRecord();
//        Freelancer expResult = null;
//        Freelancer result = instance.getFreelancerById(freelancerId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of findByNIF method, of class FreelancersRecord.
//     */
//    @Test
//    public void testFindByNIF() {
//        System.out.println("findByNIF");
//        String freelancerNIF = "";
//        FreelancersRecord instance = new FreelancersRecord();
//        Freelancer expResult = null;
//        Freelancer result = instance.findByNIF(freelancerNIF);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of getFreelancerByStringValue method, of class FreelancersRecord.
//     */
//    @Test
//    public void testGetFreelancerByStringValue() {
//        System.out.println("getFreelancerByStringValue");
//        String freelancerString = "";
//        FreelancersRecord instance = new FreelancersRecord();
//        Freelancer expResult = null;
//        Freelancer result = instance.getFreelancerByStringValue(freelancerString);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getDateDefined method, of class FreelancersRecord.
     */
    @Test
    public void testGetDateDefined() {
        System.out.println("getDateDefined");
        FreelancersRecord instance = new FreelancersRecord();
        Date expResult = instance.getDateDefined();
        Date result = instance.getDateDefined();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of scheduleAutomaticEmail method, of class FreelancersRecord.
     */
    @Test
    public void testScheduleAutomaticEmail() {
        System.out.println("scheduleAutomaticEmail");
        FreelancersRecord instance = new FreelancersRecord();
        instance.scheduleAutomaticEmail();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of getDelay method, of class FreelancersRecord.
//     */
//    @Test
//    public void testGetDelay() {
//        System.out.println("getDelay");
//        Freelancer freel3 = null;
//        FreelancersRecord instance = new FreelancersRecord();
//        int expResult = 0;
//        int result = instance.getDelay(freel3);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of getPercentageDelay method, of class FreelancersRecord.
//     */
//    @Test
//    public void testGetPercentageDelay() {
//        System.out.println("getPercentageDelay");
//        Freelancer freel1 = null;
//        FreelancersRecord instance = new FreelancersRecord();
//        int expResult = 0;
//        int result = instance.getPercentageDelay(freel1);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of getFreelancersAdapt method, of class FreelancersRecord.
//     */
//    @Test
//    public void testGetFreelancersAdapt() throws Exception {
//        System.out.println("getFreelancersAdapt");
//        FreelancersRecord instance = new FreelancersRecord();
//        List<Freelancer> expResult = null;
//        List<Freelancer> result = instance.getFreelancersAdapt();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of sendEmail method, of class FreelancersRecord.
//     */
//    @Test
//    public void testSendEmail() throws Exception {
//        System.out.println("sendEmail");
//        Freelancer freel = null;
//        FreelancersRecord instance = new FreelancersRecord();
//        instance.sendEmail(freel);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of getAverageDelay method, of class FreelancersRecord.
//     */
//    @Test
//    public void testGetAverageDelay() {
//        System.out.println("getAverageDelay");
//        FreelancersRecord instance = new FreelancersRecord();
//        double expResult = 0.0;
//        double result = instance.getAverageDelay();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
