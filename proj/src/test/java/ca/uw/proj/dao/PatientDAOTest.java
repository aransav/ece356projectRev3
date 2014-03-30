/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.init.ProjectConfig;
import ca.uw.proj.model.Patient;
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
 * @author Aran
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {ProjectConfig.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
@Ignore

public class PatientDAOTest {
    
    @Autowired
    private PatientDAO patientDAO;
    
    public PatientDAOTest() {
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
     * Test of addPatient method, of class PatientDAO.
     */
    @Test
    public void testAddPatient() {
        System.out.println("addPatient");
        
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        
        String health = "healthcard";
        Long socialInsNo = 12345678910L;
        
        Patient patient = new Patient();
        patient.setUser(user);
        patient.setHealthCardNo(health);
        patient.setSocialInsNo(socialInsNo);
        
        patientDAO.addPatient(patient);
        
        List<Patient> list = patientDAO.getAllPatients();
        
        assertEquals(1, list.size());
        
        Patient p2 = patientDAO.getAllPatients().get(0);
        assertEquals(user, p2.getUser());
        assertEquals("healthcard", p2.getHealthCardNo());
        assertEquals(12345678910L, p2.getSocialInsNo());        
    }

    /**
     * Test of updatePatient method, of class PatientDAO.
     */
    @Test
    public void testUpdatePatient() {
        System.out.println("updatePatient");
       
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        
        String health = "healthcard";
        Long socialInsNo = 12345678910L;
        
        Patient patient = new Patient();
        patient.setUser(user);
        patient.setHealthCardNo(health);
        patient.setSocialInsNo(socialInsNo);
        
        patientDAO.addPatient(patient);
        
        assertEquals(1, patientDAO.getAllPatients().size());
        Patient p2 = patientDAO.getAllPatients().get(0);
        assertEquals(user, p2.getUser());
        assertEquals(health, p2.getHealthCardNo());
        assertEquals(12345678910L, p2.getSocialInsNo());

        p2.setHealthCardNo("healthcard2");
        patientDAO.updatePatient(p2);
        
        Patient p3 = patientDAO.getAllPatients().get(0);
        assertEquals(user, p3.getUser());
        assertEquals("healthcard2", p3.getHealthCardNo());
        assertEquals(12345678910L, p3.getSocialInsNo());        
        
        
    }

    /**
     * Test of removePatient method, of class PatientDAO.
     */
    @Test
    public void testRemovePatient() {
        System.out.println("removePatient");
       
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        
        String health = "healthcard";
        Long socialInsNo = 12345678910L;
        
        Patient patient = new Patient();
        patient.setUser(user);
        patient.setHealthCardNo(health);
        patient.setSocialInsNo(socialInsNo);
        
        patientDAO.addPatient(patient);
        
        List <Patient> l2 = patientDAO.getPatient("healthCardNo", "healthcard");
        Patient p2 = l2.get(0);
        assertNotNull(p2);
        assertEquals(patient, p2);
        
        patientDAO.removePatient(p2);
        List <Patient> l3 = patientDAO.getPatient("healthCardNo", "healthcard");
                
        assertEquals(0,l3.size());
        
    }

    /**
     * Test of getPatient method, of class PatientDAO.
     */
    @Test
    public void testGetPatient() {
        System.out.println("getPatient");
        
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        
        String health = "healthcard";
        Long socialInsNo = 12345678910L;
        
        Patient patient = new Patient();
        patient.setUser(user);
        patient.setHealthCardNo(health);
        patient.setSocialInsNo(socialInsNo);
        
        patientDAO.addPatient(patient);

        User user2 = new User();
        user.setUsername("user2");
        user.setPassword("password");
        
        String health2 = "healthcard2";
        
        Patient patient2 = new Patient();
        patient2.setUser(user2);
        patient2.setHealthCardNo(health2);
        patient2.setSocialInsNo(socialInsNo);
        
        patientDAO.addPatient(patient2);
        
        List<Patient> lp = patientDAO.getPatient("healthCardNo", "healthcard");
        Patient p3 = lp.get(0);
        assertEquals(1, lp.size());
        assertEquals(patient, p3);
    }

    /**
     * Test of getAllPatients method, of class PatientDAO.
     */
    @Test
    public void testGetAllPatients() {
        System.out.println("getAllPatients");

        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        
        String health = "healthcard";
        Long socialInsNo = 12345678910L;
        
        Patient patient = new Patient();
        patient.setUser(user);
        patient.setHealthCardNo(health);
        patient.setSocialInsNo(socialInsNo);
        
        patientDAO.addPatient(patient);

        User user2 = new User();
        user.setUsername("user2");
        user.setPassword("password");
        
        String health2 = "healthcard2";
        
        Patient patient2 = new Patient();
        patient2.setUser(user2);
        patient2.setHealthCardNo(health2);
        patient2.setSocialInsNo(socialInsNo);
        
        patientDAO.addPatient(patient2);
        
        List<Patient> lp = patientDAO.getAllPatients();
        assertEquals(2, lp.size());
    }
    
}
