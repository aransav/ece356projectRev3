/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao;

import ca.uw.proj.init.ProjectConfig;
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
public class StaffDAOTest {

    @Autowired
    private StaffDAO staffDAO;

    public StaffDAOTest() {
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
     * Test of addStaff method, of class StaffDAO.
     */
    @Test
    public void testAddStaff() {
        System.out.println("addStaff");

        User u = new User();
        u.setUsername("siva");
        u.setPassword("password");

        Staff s = new Staff();
        s.setUser(u);
        s.setRole("doctor");

        staffDAO.addStaff(s);

        List<Staff> l = staffDAO.getAllStaff();

        assertEquals(1, l.size());

        Staff s2 = l.get(0);

        assertEquals(u, s2.getUser());
        assertEquals("doctor", s2.getRole());

    }

    /**
     * Test of updateStaff method, of class StaffDAO.
     */
    @Test
    public void testUpdateStaff() {
        System.out.println("updateStaff");

        User u = new User();
        u.setUsername("siva");
        u.setPassword("password");

        Staff s = new Staff();
        s.setUser(u);
        s.setRole("doctor");

        staffDAO.addStaff(s);

        s.setRole("staff");
        staffDAO.updateStaff(s);

        List<Staff> l = staffDAO.getAllStaff();

        assertEquals(1, l.size());

        Staff s2 = l.get(0);

        assertEquals(u, s2.getUser());
        assertEquals("staff", s2.getRole());

    }

    /**
     * Test of removeStaff method, of class StaffDAO.
     */
    @Test
    public void testRemoveStaff() {
        System.out.println("removeStaff");

        User u = new User();
        u.setUsername("siva");
        u.setPassword("password");

        Staff s = new Staff();
        s.setUser(u);
        s.setRole("doctor");

        staffDAO.addStaff(s);

        List<Staff> l = staffDAO.getAllStaff();

        assertEquals(1, l.size());

        staffDAO.removeStaff(s);

        l = staffDAO.getAllStaff();

        assertEquals(0, l.size());

    }

    /**
     * Test of getStaff method, of class StaffDAO.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");

        User u = new User();
        u.setUsername("siva");
        u.setPassword("password");

        Staff s = new Staff();
        s.setUser(u);
        s.setRole("doctor");

        staffDAO.addStaff(s);

        List<Staff> l = staffDAO.getStaff("user", u);

        assertEquals(1, l.size());

        Staff s2 = l.get(0);

        assertEquals(u, s2.getUser());
        assertEquals("doctor", s2.getRole());

    }

    /**
     * Test of getAllStaff method, of class StaffDAO.
     */
    @Test
    public void testGetAllStaff() {
        System.out.println("getAllStaff");

        User u = new User();
        u.setUsername("siva");
        u.setPassword("password");
        User u2 = new User();
        u2.setUsername("aran");
        u2.setPassword("password");

        Staff s = new Staff();
        s.setUser(u);
        s.setRole("doctor");

        Staff s2 = new Staff();
        s2.setUser(u2);
        s2.setRole("doctor");

        staffDAO.addStaff(s);
        staffDAO.addStaff(s2);

        List<Staff> l = staffDAO.getAllStaff();

        assertEquals(2, l.size());
    }

}
