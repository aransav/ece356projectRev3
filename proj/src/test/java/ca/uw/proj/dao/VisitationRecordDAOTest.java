/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.init.ProjectConfig;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Prescription;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.model.VisitPrescription;
import ca.uw.proj.model.VisitationRecord;
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

public class VisitationRecordDAOTest {
    
    @Autowired
    private VisitationRecordDAO visitationrecordDAO;    

    User u1;
    User u2;
    User u3;
    User u4;
    User u5;
    User u6;    
    Staff s1;
    Staff s2;
    Staff s3;
    Patient p1;
    Patient p2;
    Patient p3;
    DoctorPatient dp1;
    DoctorPatient dp2;
    DoctorPatient dp3;
    Prescription pres1;
    Prescription pres2;
    Prescription pres3;
    VisitPrescription vp1;
    VisitPrescription vp2;
    VisitPrescription vp3;
            
    
    public VisitationRecordDAOTest() {
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

        u5 = new User();
        u5.setUsername("user5");
        u5.setPassword("password");

        u6 = new User();
        u6.setUsername("user6");
        u6.setPassword("password");        

        s1 = new Staff();
        s1.setUser(u1);
        s1.setRole("doctor");

        s2 = new Staff();
        s2.setUser(u2);
        s2.setRole("doctor");

        s3 = new Staff();
        s3.setUser(u3);
        s3.setRole("doctor");

        p1 = new Patient();
        p1.setUser(u4);
        p1.setHealthCardNo("healthcard1");
        p1.setSocialInsNo(123456789L);
        
        p2 = new Patient();
        p2.setUser(u5);
        p2.setHealthCardNo("healthcard2");
        p2.setSocialInsNo(123456789L);
        
        p3 = new Patient();
        p3.setUser(u6);
        p3.setHealthCardNo("healthcard3");
        p3.setSocialInsNo(123456789L);
        
        dp1 = new DoctorPatient();
        dp1.setDoctor(s1);
        dp1.setPatient(p1);
        dp1.setPrimaryDoctor(true);
        
        dp2 = new DoctorPatient();
        dp2.setDoctor(s2);
        dp2.setPatient(p2);
        dp2.setPrimaryDoctor(true);
        
        dp3 = new DoctorPatient();
        dp3.setDoctor(s3);
        dp3.setPatient(p3);
        dp3.setPrimaryDoctor(true);   
        
        pres1 = new Prescription();
        pres1.setName("Advil");
        pres1.setDescription("Pain Killer");
        
        pres2 = new Prescription();
        pres2.setName("Morph");
        pres2.setDescription("Pain Killer");
        
        pres3 = new Prescription();
        pres3.setName("Birth Control");
        pres3.setDescription("Baby Killer Pills");
        
        vp1 = new VisitPrescription();
        vp1.setPrescription(pres1);
        vp1.setStartDate(new java.sql.Date(10000));
        vp1.setExpiryDate(new java.sql.Date(12000));
        
        vp2 = new VisitPrescription();
        vp2.setPrescription(pres2);
        vp2.setStartDate(new java.sql.Date(12000));
        vp2.setExpiryDate(new java.sql.Date(14000));
        
        vp3 = new VisitPrescription();
        vp3.setPrescription(pres3);
        vp3.setStartDate(new java.sql.Date(13000));
        vp3.setExpiryDate(new java.sql.Date(14000));
    }    
    
    @After
    public void tearDown() {
    }    
    
    /**
     * Test of addVisitationRecord method, of class VisitationRecordDAO.
     */
    @Test
    public void testAddVisitationRecord() {
        System.out.println("addVisitationRecord");
        
        VisitationRecord v = new VisitationRecord();
        v.setDoctorPatient(dp1);
        v.setSurgeryPerformed("heart");
        v.setVisitPrescription(vp1);
        v.setVisitDate(new java.sql.Date(10000));
        v.setStartTime(new java.sql.Date(11000));
        v.setEndTime(new java.sql.Date(12000));
        v.setDiagnosis("Killer Heart");
        
        visitationrecordDAO.addVisitationRecord(v);
        
        List<VisitationRecord> vs = visitationrecordDAO.getAllVisitationRecord();
        
        assertEquals(1, vs.size());
        assertEquals(v, vs.get(0));
    }

    /**
     * Test of updateVisitationRecord method, of class VisitationRecordDAO.
     */
    @Test
    public void testUpdateVisitationRecord() {
        System.out.println("updateVisitationRecord");

        VisitationRecord v = new VisitationRecord();
        v.setDoctorPatient(dp1);
        v.setSurgeryPerformed("heart");
        v.setVisitPrescription(vp1);
        v.setVisitDate(new java.sql.Date(10000));
        v.setStartTime(new java.sql.Date(11000));
        v.setEndTime(new java.sql.Date(12000));
        v.setDiagnosis("Killer Heart");
        
        visitationrecordDAO.addVisitationRecord(v);
        
        List<VisitationRecord> vs = visitationrecordDAO.getAllVisitationRecord();
        
        assertEquals(1, vs.size());
        assertEquals(v, vs.get(0));
        
        v.setDoctorPatient(dp2);
        v.setVisitPrescription(vp2);
        
        visitationrecordDAO.updateVisitationRecord(v);
        
        vs = visitationrecordDAO.getAllVisitationRecord();
        
        assertEquals(1, vs.size());
        assertEquals(v, vs.get(0));
    }

    /**
     * Test of removeVisitationRecord method, of class VisitationRecordDAO.
     */
    @Test
    public void testRemoveVisitationRecord() {
        System.out.println("removeVisitationRecord");

        VisitationRecord v = new VisitationRecord();
        v.setDoctorPatient(dp1);
        v.setSurgeryPerformed("heart");
        v.setVisitPrescription(vp1);
        v.setVisitDate(new java.sql.Date(10000));
        v.setStartTime(new java.sql.Date(11000));
        v.setEndTime(new java.sql.Date(12000));
        v.setDiagnosis("Killer Heart");
        
        visitationrecordDAO.addVisitationRecord(v);
        
        List<VisitationRecord> vs = visitationrecordDAO.getAllVisitationRecord();
        
        assertEquals(1, vs.size());
        assertEquals(v, vs.get(0));
        
        visitationrecordDAO.removeVisitationRecord(v);
        
        vs = visitationrecordDAO.getAllVisitationRecord();
        
        assertEquals(0, vs.size());
        
    }

    /**
     * Test of getVisitationRecord method, of class VisitationRecordDAO.
     */
    @Test
    public void testGetVisitationRecord() {
        System.out.println("getVisitationRecord");

        VisitationRecord v = new VisitationRecord();
        v.setDoctorPatient(dp1);
        v.setSurgeryPerformed("heart");
        v.setVisitPrescription(vp1);
        v.setVisitDate(new java.sql.Date(10000));
        v.setStartTime(new java.sql.Date(11000));
        v.setEndTime(new java.sql.Date(12000));
        v.setDiagnosis("Killer Heart");
        
        VisitationRecord v2 = new VisitationRecord();
        v2.setDoctorPatient(dp2);
        v2.setSurgeryPerformed("Libo");
        v2.setVisitPrescription(vp2);
        v2.setVisitDate(new java.sql.Date(12000));
        v2.setStartTime(new java.sql.Date(12300));
        v2.setEndTime(new java.sql.Date(14000));
        v2.setDiagnosis("Killer Arse");
        
        visitationrecordDAO.addVisitationRecord(v);
        visitationrecordDAO.addVisitationRecord(v2);
        
        List<VisitationRecord> lis1 = visitationrecordDAO.getVisitationRecord("surgeryperformed", v.getSurgeryPerformed());
        List<VisitationRecord> lis2 = visitationrecordDAO.getVisitationRecord("surgeryperformed", v2.getSurgeryPerformed());
        
        assertEquals(1, lis1.size());
        assertEquals(v, lis1.get(0));
        assertEquals(1, lis2.size());
        assertEquals(v2, lis2.get(0));
        
        lis1 = visitationrecordDAO.getVisitationRecord("doctorPatient", v.getDoctorPatient());
        lis2 = visitationrecordDAO.getVisitationRecord("doctorPatient", v2.getDoctorPatient());

        assertEquals(1, lis1.size());
        assertEquals(v, lis1.get(0));
        assertEquals(1, lis2.size());
        assertEquals(v2, lis2.get(0));        
        
    }

    /**
     * Test of getAllVisitationRecord method, of class VisitationRecordDAO.
     */
    @Test
    public void testGetAllVisitationRecord() {
        System.out.println("getAllVisitationRecord");

        VisitationRecord v = new VisitationRecord();
        v.setDoctorPatient(dp1);
        v.setSurgeryPerformed("heart");
        v.setVisitPrescription(vp1);
        v.setVisitDate(new java.sql.Date(10000));
        v.setStartTime(new java.sql.Date(11000));
        v.setEndTime(new java.sql.Date(12000));
        v.setDiagnosis("Killer Heart");
        
        VisitationRecord v2 = new VisitationRecord();
        v2.setDoctorPatient(dp2);
        v2.setSurgeryPerformed("Libo");
        v2.setVisitPrescription(vp2);
        v2.setVisitDate(new java.sql.Date(12000));
        v2.setStartTime(new java.sql.Date(12300));
        v2.setEndTime(new java.sql.Date(14000));
        v2.setDiagnosis("Killer Arse");
        
        visitationrecordDAO.addVisitationRecord(v);
        visitationrecordDAO.addVisitationRecord(v2);
        
        List<VisitationRecord> lis1 = visitationrecordDAO.getAllVisitationRecord();
        assertEquals(2, lis1.size());
        
    }
}
