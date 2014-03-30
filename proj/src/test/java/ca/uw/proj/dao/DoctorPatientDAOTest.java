/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao;

import ca.uw.proj.init.ProjectConfig;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
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
public class DoctorPatientDAOTest {

    @Autowired
    DoctorPatientDAO dpDAO;

    User u1;
    User u2;
    User u3;
    User u4;
    Staff s1;
    Staff s2;
    Patient p1;
    Patient p2;

    public DoctorPatientDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        u1 = new User();
        u1.setUsername("user1");
        u1.setPassword("password");

        u2 = new User();
        u2.setUsername("user2");
        u2.setPassword("password");

        u3 = new User();
        u3.setUsername("user3");
        u3.setPassword("password");

        u4 = new User();
        u4.setUsername("user4");
        u4.setPassword("password");

        s1 = new Staff();
        s1.setUser(u1);
        s1.setRole("doctor");

        s2 = new Staff();
        s2.setUser(u2);
        s2.setRole("doctor");

        p1 = new Patient();
        p1.setUser(u3);
        p1.setHealthCardNo("1");
        p1.setSocialInsNo(2);

        p2 = new Patient();
        p2.setUser(u4);
        p2.setHealthCardNo("3");
        p2.setSocialInsNo(4);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDoctorPatient method, of class DoctorPatientDAO.
     */
    @Test
    public void testAddDoctorPatient() {
        System.out.println("addDoctorPatient");

        DoctorPatient dp = new DoctorPatient();
        dp.setDoctor(s1);
        dp.setPatient(p1);
        dp.setPrimaryDoctor(true);

        dpDAO.addDoctorPatient(dp);

        List<DoctorPatient> l = dpDAO.getAllDoctorPatient();

        assertEquals(1, l.size());
        assertEquals(dp, l.get(0));
        assertEquals(dp.getDoctor(), l.get(0).getDoctor());
        assertEquals(dp.getPatient(), l.get(0).getPatient());

    }

    /**
     * Test of getDoctorPatient method, of class DoctorPatientDAO.
     */
    @Test
    public void testGetDoctorPatient() {
        System.out.println("getDoctorPatient");

        DoctorPatient dp = new DoctorPatient();
        dp.setDoctor(s1);
        dp.setPatient(p1);
        dp.setPrimaryDoctor(true);

        DoctorPatient dp2 = new DoctorPatient();
        dp2.setDoctor(s2);
        dp2.setPatient(p1);
        dp2.setPrimaryDoctor(false);

        dpDAO.addDoctorPatient(dp);
        dpDAO.addDoctorPatient(dp2);

        List<DoctorPatient> l = dpDAO.getDoctorPatient("doctor", s1);
        assertEquals(1, l.size());
        assertEquals(dp, l.get(0));
        assertEquals(dp.getPatient(), l.get(0).getPatient());

        l = dpDAO.getDoctorPatient("patient", p1);
        assertEquals(2, l.size());

    }

    /**
     * Test of updateDoctorPatient method, of class DoctorPatientDAO.
     */
    @Test
    public void testUpdateDoctorPatient() {
        System.out.println("updateDoctorPatient");
        DoctorPatient dp = new DoctorPatient();
        dp.setDoctor(s1);
        dp.setPatient(p1);
        dp.setPrimaryDoctor(true);

        dpDAO.addDoctorPatient(dp);

        List<DoctorPatient> l = dpDAO.getAllDoctorPatient();

        assertEquals(1, l.size());
        assertEquals(dp, l.get(0));
        assertEquals(dp.getDoctor(), l.get(0).getDoctor());
        assertEquals(dp.getPatient(), l.get(0).getPatient());
        assertTrue(l.get(0).isPrimaryDoctor());

        dp.setPrimaryDoctor(false);
        dpDAO.updateDoctorPatient(dp);

        l = dpDAO.getAllDoctorPatient();

        assertEquals(1, l.size());
        assertEquals(dp, l.get(0));
        assertEquals(dp.getDoctor(), l.get(0).getDoctor());
        assertEquals(dp.getPatient(), l.get(0).getPatient());
        assertFalse(l.get(0).isPrimaryDoctor());

    }

    /**
     * Test of removeDoctorPatient method, of class DoctorPatientDAO.
     */
    @Test
    public void testRemoveDoctorPatient() {
        System.out.println("removeDoctorPatient");

        DoctorPatient dp = new DoctorPatient();
        dp.setDoctor(s1);
        dp.setPatient(p1);
        dp.setPrimaryDoctor(true);

        dpDAO.addDoctorPatient(dp);

        List<DoctorPatient> l = dpDAO.getAllDoctorPatient();

        assertEquals(1, l.size());
        assertEquals(dp, l.get(0));
        assertEquals(dp.getDoctor(), l.get(0).getDoctor());
        assertEquals(dp.getPatient(), l.get(0).getPatient());
        assertTrue(l.get(0).isPrimaryDoctor());

        dpDAO.removeDoctorPatient(dp);

        l = dpDAO.getAllDoctorPatient();

        assertEquals(0, l.size());

    }

    /**
     * Test of getAllDoctorPatient method, of class DoctorPatientDAO.
     */
    @Test
    public void testGetAllDoctorPatient() {
        System.out.println("getAllDoctorPatient");

        DoctorPatient dp = new DoctorPatient();
        dp.setDoctor(s1);
        dp.setPatient(p1);
        dp.setPrimaryDoctor(true);

        DoctorPatient dp2 = new DoctorPatient();
        dp2.setDoctor(s2);
        dp2.setPatient(p1);
        dp2.setPrimaryDoctor(false);

        dpDAO.addDoctorPatient(dp);
        dpDAO.addDoctorPatient(dp2);

        List<DoctorPatient> l = dpDAO.getAllDoctorPatient();
        
        assertEquals(2, l.size());
    }

}
