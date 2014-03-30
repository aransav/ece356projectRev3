/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao;

import ca.uw.proj.init.ProjectConfig;
import ca.uw.proj.model.Prescription;
import ca.uw.proj.model.VisitPrescription;
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
public class VisitPrescriptionDAOTest {

    @Autowired
    private VisitPrescriptionDAO vDAO;

    Prescription p1;
    Prescription p2;
    Prescription p3;

    VisitPrescription v1;
    VisitPrescription v2;
    VisitPrescription v3;

    public VisitPrescriptionDAOTest() {
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

        v1 = new VisitPrescription();
        v1.setPrescription(p1);
        v1.setStartDate(new java.sql.Date(1000));
        v1.setExpiryDate(new java.sql.Date(2000));

        v2 = new VisitPrescription();
        v2.setPrescription(p2);
        v2.setStartDate(new java.sql.Date(10000));
        v2.setExpiryDate(new java.sql.Date(20000));

        v3 = new VisitPrescription();
        v3.setPrescription(p3);
        v3.setStartDate(new java.sql.Date(100000));
        v3.setExpiryDate(new java.sql.Date(200000));

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addVisitPrescription method, of class VisitPrescriptionDAO.
     */
    @Test
    public void testAddVisitPrescription() {
        System.out.println("addVisitPrescription");

        vDAO.addVisitPrescription(v1);

        List<VisitPrescription> l = vDAO.getAllVisitPrescriptions();

        assertEquals(1, l.size());

        assertEquals(v1, l.get(0));

    }

    /**
     * Test of updateVisitPrescription method, of class VisitPrescriptionDAO.
     */
    @Test
    public void testUpdateVisitPrescription() {
        System.out.println("updateVisitPrescription");

        vDAO.addVisitPrescription(v1);

        List<VisitPrescription> l = vDAO.getAllVisitPrescriptions();

        assertEquals(1, l.size());

        assertEquals(p1, l.get(0).getPrescription());

        v1.setPrescription(p2);

        vDAO.updateVisitPrescription(v1);

        l = vDAO.getAllVisitPrescriptions();

        assertEquals(1, l.size());

        assertEquals(p2, l.get(0).getPrescription());

    }

    /**
     * Test of removeVisitPrescription method, of class VisitPrescriptionDAO.
     */
    @Test
    public void testRemoveVisitPrescription() {
        System.out.println("removeVisitPrescription");
        vDAO.addVisitPrescription(v1);

        List<VisitPrescription> l = vDAO.getAllVisitPrescriptions();

        assertEquals(1, l.size());

        assertEquals(p1, l.get(0).getPrescription());

        vDAO.removeVisitPrescription(v1);

        l = vDAO.getAllVisitPrescriptions();

        assertEquals(0, l.size());

    }

    /**
     * Test of getVisitPrescription method, of class VisitPrescriptionDAO.
     */
    @Test
    public void testGetVisitPrescription() {
        System.out.println("getVisitPrescription");

        vDAO.addVisitPrescription(v1);
        vDAO.addVisitPrescription(v2);
        vDAO.addVisitPrescription(v3);

        List<VisitPrescription> l = vDAO.getVisitPrescription("prescription", p1);

        assertEquals(1, l.size());
        assertEquals(v1, l.get(0));

    }

    /**
     * Test of getAllVisitPrescriptions method, of class VisitPrescriptionDAO.
     */
    @Test
    public void testGetAllVisitPrescriptions() {
        System.out.println("getAllVisitPrescriptions");

        vDAO.addVisitPrescription(v1);
        vDAO.addVisitPrescription(v2);
        vDAO.addVisitPrescription(v3);
        
        List<VisitPrescription> l = vDAO.getAllVisitPrescriptions();
        
        assertEquals(3,l.size());
    }
}
