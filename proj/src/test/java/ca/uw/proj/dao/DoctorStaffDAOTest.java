/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao;

import ca.uw.proj.init.ProjectConfig;
import ca.uw.proj.model.DoctorStaff;
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
public class DoctorStaffDAOTest {

    @Autowired
    DoctorStaffDAO doctorStaffDAO;

    User u1;
    User u2;
    User u3;
    Staff s1;
    Staff s2;
    Staff s3;

    public DoctorStaffDAOTest() {
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

        s1 = new Staff();
        s1.setUser(u1);
        s1.setRole("doctor");

        s2 = new Staff();
        s2.setUser(u2);
        s2.setRole("staff");

        s3 = new Staff();
        s3.setUser(u3);
        s3.setRole("staff");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDoctorStaff method, of class DoctorStaffDAO.
     */
    @Test
    public void testAddDoctorStaff() {
        System.out.println("addDoctorStaff");

        DoctorStaff d = new DoctorStaff();
        d.setDoctor(s1);
        d.setStaff(s2);

        doctorStaffDAO.addDoctorStaff(d);

        List<DoctorStaff> l = doctorStaffDAO.getAllDoctorStaff();

        assertEquals(1, l.size());
        DoctorStaff d2 = l.get(0);

        assertEquals(d, d2);

    }

    /**
     * Test of updateDoctorStaff method, of class DoctorStaffDAO.
     */
    @Test
    public void testUpdateDoctorStaff() {
        System.out.println("updateDoctorStaff");

        DoctorStaff d = new DoctorStaff();
        d.setDoctor(s1);
        d.setStaff(s2);

        doctorStaffDAO.addDoctorStaff(d);

        List<DoctorStaff> l = doctorStaffDAO.getAllDoctorStaff();

        assertEquals(1, l.size());
        DoctorStaff d2 = l.get(0);

        assertEquals(d, d2);

        d.setStaff(s3);

        doctorStaffDAO.updateDoctorStaff(d);

        l = doctorStaffDAO.getAllDoctorStaff();

        assertEquals(1, l.size());
        DoctorStaff d3 = l.get(0);

        assertEquals(d, d3);
    }

    /**
     * Test of removeDoctorStaff method, of class DoctorStaffDAO.
     */
    @Test
    public void testRemoveDoctorStaff() {
        System.out.println("removeDoctorStaff");

        DoctorStaff d = new DoctorStaff();
        d.setDoctor(s1);
        d.setStaff(s2);

        doctorStaffDAO.addDoctorStaff(d);

        List<DoctorStaff> l = doctorStaffDAO.getAllDoctorStaff();

        assertEquals(1, l.size());
        DoctorStaff d2 = l.get(0);

        assertEquals(d, d2);

        doctorStaffDAO.removeDoctorStaff(d);

        l = doctorStaffDAO.getAllDoctorStaff();

        assertEquals(0, l.size());

    }

    /**
     * Test of getDoctorStaff method, of class DoctorStaffDAO.
     */
    @Test
    public void testGetDoctorStaff() {
        System.out.println("getDoctorStaff");

        DoctorStaff d = new DoctorStaff();
        d.setDoctor(s1);
        d.setStaff(s2);

        doctorStaffDAO.addDoctorStaff(d);

        DoctorStaff d2 = doctorStaffDAO.getDoctorStaff("doctor", d.getDoctor()).get(0);

        assertEquals(d, d2);
    }

    /**
     * Test of getAllDoctorStaff method, of class DoctorStaffDAO.
     */
    @Test
    public void testGetAllDoctorStaff() {
        System.out.println("getAllDoctorStaff");

        DoctorStaff d = new DoctorStaff();
        d.setDoctor(s1);
        d.setStaff(s2);

        DoctorStaff d2 = new DoctorStaff();
        d.setDoctor(s1);
        d.setStaff(s3);

        doctorStaffDAO.addDoctorStaff(d);
        doctorStaffDAO.addDoctorStaff(d2);
        
        assertEquals(2,doctorStaffDAO.getAllDoctorStaff().size());
    }

}
