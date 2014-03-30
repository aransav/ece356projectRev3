/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao;

import ca.uw.proj.init.ProjectConfig;
import ca.uw.proj.model.Prescription;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author siva
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {ProjectConfig.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
@Ignore
public class PrescriptionDAOTest {

    @Autowired
    PrescriptionDAO prescriptionDAO;

    Prescription p1;
    Prescription p2;
    Prescription p3;

    public PrescriptionDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        p1 = new Prescription();
        p1.setName("a");
        p1.setDescription("1111");

        p2 = new Prescription();
        p2.setName("b");
        p2.setDescription("2222");

        p3 = new Prescription();
        p3.setName("c");
        p3.setDescription("3333");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addPrescription method, of class PrescriptionDAO.
     */
    @Test
    public void testAddPrescription() {
        System.out.println("addPrescription");

        prescriptionDAO.addPrescription(p1);

        List<Prescription> l = prescriptionDAO.getAllPrescription();

        assertEquals(1, l.size());
        assertEquals(p1, l.get(0));
    }

    /**
     * Test of removePrescription method, of class PrescriptionDAO.
     */
    @Test
    public void testRemovePrescription() {
        System.out.println("removePrescription");
        prescriptionDAO.addPrescription(p1);

        List<Prescription> l = prescriptionDAO.getAllPrescription();

        assertEquals(1, l.size());
        assertEquals(p1, l.get(0));

        prescriptionDAO.removePrescription(p1);

        l = prescriptionDAO.getAllPrescription();

        assertEquals(0, l.size());

    }

    /**
     * Test of updatePrescription method, of class PrescriptionDAO.
     */
    @Test
    public void testUpdatePrescription() {
        System.out.println("updatePrescription");

        prescriptionDAO.addPrescription(p1);

        List<Prescription> l = prescriptionDAO.getAllPrescription();

        assertEquals(1, l.size());
        assertEquals(p1, l.get(0));

        p1.setName("something");
        prescriptionDAO.updatePrescription(p1);

        l = prescriptionDAO.getAllPrescription();

        assertEquals(1, l.size());
        assertEquals(p1, l.get(0));

    }

    /**
     * Test of getPrescription method, of class PrescriptionDAO.
     */
    @Test
    public void testGetPrescription() {
        System.out.println("getPrescription");

        prescriptionDAO.addPrescription(p1);
        prescriptionDAO.addPrescription(p2);

        List<Prescription> l = prescriptionDAO.getPrescription("name", p1.getName());
        assertEquals(1, l.size());
        assertEquals(p1, l.get(0));

        l = prescriptionDAO.getPrescription("description", p1.getDescription());
        assertEquals(1, l.size());
        assertEquals(p1, l.get(0));
    }

    /**
     * Test of getAllPrescription method, of class PrescriptionDAO.
     */
    @Test
    public void testGetAllPrescription() {
        System.out.println("getAllPrescription");

        prescriptionDAO.addPrescription(p1);
        prescriptionDAO.addPrescription(p2);
        prescriptionDAO.addPrescription(p3);
        
        List<Prescription> l = prescriptionDAO.getAllPrescription();
        assertEquals(3, l.size());
    }

}
