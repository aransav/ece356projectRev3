/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao;

import ca.uw.proj.init.ProjectConfig;
import ca.uw.proj.model.Appointment;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import java.util.List;
import javax.servlet.ServletRegistration;
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
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

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
public class AppointmentDAOTest {

    @Autowired
    AppointmentDAO aDAO;

    Appointment a1;
    Appointment a2;
    Appointment a3;

    User u1;
    User u2;
    User u3;
    User u4;
    Staff s1;
    Staff s2;
    Patient p1;
    Patient p2;

    DoctorPatient dp1;
    DoctorPatient dp2;

    public AppointmentDAOTest() {

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

        dp1 = new DoctorPatient();
        dp1.setDoctor(s1);
        dp1.setPatient(p1);
        dp1.setPrimaryDoctor(true);

        dp2 = new DoctorPatient();
        dp2.setDoctor(s2);
        dp2.setPatient(p2);
        dp2.setPrimaryDoctor(false);

        a1 = new Appointment();
        a1.setDoctorPatient(dp1);
        a1.setDateOfApp(new java.sql.Date(10000));
        a1.setComments("none");
        a1.setProcedureDesc("a");
        a1.setSchedLength(10);
        a1.setStatus("NA");

        a2 = new Appointment();
        a2.setDoctorPatient(dp2);
        a2.setDateOfApp(new java.sql.Date(10000));
        a2.setComments("none");
        a2.setProcedureDesc("a");
        a2.setSchedLength(10);
        a2.setStatus("NA");
    }

    @After
    public void tearDown() {

    }

    /**
     * Test of addAppointment method, of class AppointmentDAO.
     */
    @Test
    public void testAddAppointment() {
        System.out.println("addAppointment");

        aDAO.addAppointment(a1);

        List<Appointment> l = aDAO.getAllAppointments();
        assertEquals(1, l.size());
        assertEquals(a1, l.get(0));

    }

    /**
     * Test of updateAppointmment method, of class AppointmentDAO.
     */
    @Test
    public void testUpdateAppointmment() {
        System.out.println("updateAppointmment");

        aDAO.addAppointment(a1);

        List<Appointment> l = aDAO.getAllAppointments();
        assertEquals(1, l.size());
        assertEquals(a1, l.get(0));
        assertEquals(dp1, l.get(0).getDoctorPatient());
        
        a1.setDoctorPatient(dp2);
        aDAO.updateAppointmment(a1);
        
        l = aDAO.getAllAppointments();
        assertEquals(1, l.size());
        assertEquals(a1, l.get(0));
        assertEquals(dp2, l.get(0).getDoctorPatient());
        
    }
    
    /**
     * Test of getAppointment method, of class AppointmentDAO.
     */
    @Test
    public void testGetAppointment_String_Object() {
        System.out.println("getAppointment");
 
        aDAO.addAppointment(a1);
        aDAO.addAppointment(a2);

        List<Appointment> l = aDAO.getAppointment("doctorPatient", dp1);
        assertEquals(1,l.size());
        assertEquals(a1,l.get(0));
        
        l = aDAO.getAppointment("doctorPatient", dp2);
        assertEquals(1,l.size());
        assertEquals(a2,l.get(0));
        
    }

    /**
     * Test of getAllAppointments method, of class AppointmentDAO.
     */
    @Test
    public void testGetAllAppointments() {
        System.out.println("getAllAppointments");
        
        aDAO.addAppointment(a1);
        aDAO.addAppointment(a2);

        List<Appointment> l = aDAO.getAllAppointments();
        
        assertEquals(2, l.size());
    }

}
