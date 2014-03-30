/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.AppointmentDAO;
import ca.uw.proj.dao.DoctorPatientDAO;
import ca.uw.proj.dao.DoctorStaffDAO;
import ca.uw.proj.dao.PatientDAO;
import ca.uw.proj.dao.PrescriptionDAO;
import ca.uw.proj.dao.StaffDAO;
import ca.uw.proj.dao.UserDAO;
import ca.uw.proj.dao.UserLoginLogDAO;
import ca.uw.proj.dao.VisitPrescriptionDAO;
import ca.uw.proj.dao.VisitationRecordDAO;
import ca.uw.proj.model.Appointment;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.DoctorStaff;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Prescription;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.model.UserLoginLog;
import ca.uw.proj.model.VisitPrescription;
import ca.uw.proj.model.VisitationRecord;
import ca.uw.proj.service.UtilitiesService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author siva
 */
@Service
public class UtilitiesServiceImpl implements UtilitiesService {
    //blah
    @Autowired
    AppointmentDAO appointmentDAO;
    @Autowired
    DoctorPatientDAO doctorPatientDAO;
    @Autowired
    DoctorStaffDAO doctorStaffDAO;
    @Autowired
    PatientDAO patientDAO;
    @Autowired
    PrescriptionDAO prescriptionDAO;
    @Autowired
    StaffDAO staffDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    UserLoginLogDAO userLoginLogDAO;
    @Autowired
    VisitPrescriptionDAO visitPrescriptionDAO;
    @Autowired
    VisitationRecordDAO visitationRecordDAO;
    
    @Override
    public List<Date> generateRangeDates(Date firstDate, Date lastDate) {
        List<Date> dates = new ArrayList<Date>();
        for (long d = firstDate.getTime(); d <= lastDate.getTime(); d += 24 * 60 * 60 * 1000) {
            dates.add(new Date(d));
        }
        return dates;
    }

    @Override
    public void prePopulateDatabase() {
        User u1 = new User(); u1.setUsername("user1"); u1.setPassword("password"); userDAO.addUser(u1);
        u1.setFname("Billy"); u1.setLname("Ray"); u1.setMname("Cyrus");
        u1.setStreetno("1"); u1.setStreetname("Nowhere"); u1.setAptno("69"); u1.setCity("Toronto"); u1.setProv("Ontario"); u1.setZip("A1A1A1");
        u1.setHphone("5196996969"); u1.setCphone("5197996969"); u1.setWphone("5198996969"); 
        u1.setDob("1969-06-15");
        User u2 = new User(); u2.setUsername("user2"); u2.setPassword("password"); userDAO.addUser(u2);
        u2.setFname("Miley"); u2.setLname("Ray"); u2.setMname("Cyrus");
        u2.setStreetno("2"); u2.setStreetname("Nowhere"); u2.setAptno("69"); u2.setCity("Toronto"); u2.setProv("Ontario"); u2.setZip("B2B2B2");
        u2.setHphone("5196996969"); u2.setCphone("5197996969"); u2.setWphone("5198996969"); 
        u2.setDob("1969-06-15");
        User u3 = new User(); u3.setUsername("user3"); u3.setPassword("password"); userDAO.addUser(u3);
        u3.setFname("Justin"); u3.setLname("Beiber");
        u3.setStreetno("3"); u3.setStreetname("Nowhere"); u3.setAptno("69"); u3.setCity("Toronto"); u3.setProv("Ontario"); u3.setZip("C3C3C3");
        u3.setHphone("5196996969"); u3.setCphone("5197996969"); u3.setWphone("5198996969"); 
        u3.setDob("1969-06-15");
        User u4 = new User(); u4.setUsername("user4"); u4.setPassword("password"); userDAO.addUser(u4);
        u4.setFname("Taylor"); u4.setLname("Swift"); u4.setMname("Crazy");
        u4.setStreetno("4"); u4.setStreetname("Nowhere"); u4.setAptno("69"); u4.setCity("Toronto"); u4.setProv("Ontario"); u4.setZip("D4D4D4");
        u4.setHphone("5196996969"); u4.setCphone("5197996969"); u4.setWphone("5198996969"); 
        u4.setDob("1969-06-15");
        User u5 = new User(); u5.setUsername("user5"); u5.setPassword("password"); userDAO.addUser(u5);
        u5.setFname("Fifty"); u5.setLname("Cent");
        u5.setStreetno("5"); u5.setStreetname("Nowhere"); u5.setAptno("69"); u5.setCity("Toronto"); u5.setProv("Ontario"); u5.setZip("E5E5E5");
        u5.setHphone("5196996969"); u5.setCphone("5197996969"); u5.setWphone("5198996969"); 
        u5.setDob("1969-06-15");
        User u6 = new User(); u6.setUsername("user6"); u6.setPassword("password"); userDAO.addUser(u6);
        u6.setFname("Doctor"); u6.setLname("Dre"); 
        u6.setStreetno("6"); u6.setStreetname("Nowhere"); u6.setAptno("69"); u6.setCity("Toronto"); u6.setProv("Ontario"); u6.setZip("F6F6F6");
        u6.setHphone("5196996969"); u6.setCphone("5197996969"); u6.setWphone("5198996969"); 
        u6.setDob("1969-06-15");
        User u7 = new User(); u7.setUsername("user7"); u7.setPassword("password"); userDAO.addUser(u7);
        u7.setFname("Gregory"); u7.setLname("House"); u7.setMname("MD");
        u7.setStreetno("69"); u7.setStreetname("Nowhere"); u7.setAptno("69"); u7.setCity("Toronto"); u7.setProv("Ontario"); u7.setZip("G7G7G7");
        u7.setHphone("5196996969"); u7.setCphone("5197996969"); u7.setWphone("5198996969"); 
        u7.setDob("1969-06-15");
        User u8 = new User(); u8.setUsername("user8"); u8.setPassword("password"); userDAO.addUser(u8);
        u8.setFname("Slim"); u8.setLname("Shady"); 
        u8.setStreetno("69"); u8.setStreetname("Nowhere"); u8.setAptno("69"); u8.setCity("Waterloo"); u8.setProv("Ontario"); u8.setZip("H0H0H0");
        u8.setHphone("5196996969"); u8.setCphone("5197996969"); u8.setWphone("5198996969"); 
        u8.setDob("1969-06-15");
        User u9 = new User(); u9.setUsername("user9"); u9.setPassword("password"); userDAO.addUser(u9);
        u9.setFname("Snoop"); u9.setLname("Dogg"); u9.setMname("Doggy");
        u9.setStreetno("69"); u9.setStreetname("Nowhere"); u9.setAptno("69"); u9.setCity("Waterloo"); u9.setProv("Ontario"); u9.setZip("J1J1J1");
        u9.setHphone("5196996969"); u9.setCphone("5197996969"); u9.setWphone("5198996969"); 
        u9.setDob("1969-06-15");
        User u10 = new User(); u10.setUsername("user10"); u10.setPassword("password"); userDAO.addUser(u10);
        u10.setFname("Snoop"); u10.setLname("Lion"); u10.setMname("Rawr");
        u10.setStreetno("69"); u10.setStreetname("Nowhere"); u10.setAptno("69"); u10.setCity("New York"); u10.setProv("Ontario"); u10.setZip("K1K1K1");
        u10.setHphone("5196996969"); u10.setCphone("5197996969"); u10.setWphone("5198996969"); 
        u10.setDob("1969-06-15");
       

        
        UserLoginLog ul1 = new UserLoginLog(); ul1.setUser(u1); ul1.setLogin_time(new java.sql.Date(2014, 3, 1));
        UserLoginLog ul12 = new UserLoginLog(); ul12.setUser(u1); ul12.setLogin_time(new java.sql.Date(2014, 3, 2));
        UserLoginLog ul13 = new UserLoginLog(); ul13.setUser(u1); ul13.setLogin_time(new java.sql.Date(2014, 3, 3));
        
        UserLoginLog ul2 = new UserLoginLog(); ul2.setUser(u2); ul2.setLogin_time(new java.sql.Date(2014, 3, 5)); 
        UserLoginLog ul3 = new UserLoginLog(); ul3.setUser(u3); ul3.setLogin_time(new java.sql.Date(2014, 3, 5)); 
        UserLoginLog ul4 = new UserLoginLog(); ul4.setUser(u4); ul4.setLogin_time(new java.sql.Date(2014, 3, 5)); 
        UserLoginLog ul5 = new UserLoginLog(); ul5.setUser(u5); ul5.setLogin_time(new java.sql.Date(2014, 3, 5)); 
        UserLoginLog ul6 = new UserLoginLog(); ul6.setUser(u6); ul6.setLogin_time(new java.sql.Date(2014, 3, 5)); 
        UserLoginLog ul7 = new UserLoginLog(); ul7.setUser(u7); ul7.setLogin_time(new java.sql.Date(2014, 3, 5)); 
        UserLoginLog ul8 = new UserLoginLog(); ul8.setUser(u8); ul8.setLogin_time(new java.sql.Date(2014, 3, 5)); 
        UserLoginLog ul9 = new UserLoginLog(); ul9.setUser(u9); ul9.setLogin_time(new java.sql.Date(2014, 3, 5)); 

        userLoginLogDAO.addUserLoginLog(ul1);
        userLoginLogDAO.addUserLoginLog(ul2);
        userLoginLogDAO.addUserLoginLog(ul3);
        userLoginLogDAO.addUserLoginLog(ul4);
        userLoginLogDAO.addUserLoginLog(ul5);
        userLoginLogDAO.addUserLoginLog(ul6);
        userLoginLogDAO.addUserLoginLog(ul7);
        userLoginLogDAO.addUserLoginLog(ul8);
        userLoginLogDAO.addUserLoginLog(ul9);
        userLoginLogDAO.addUserLoginLog(ul12);
        userLoginLogDAO.addUserLoginLog(ul13);
        
        Staff s1 = new Staff(); s1.setUser(u1); s1.setRole("doctor");
        Staff s2 = new Staff(); s2.setUser(u2); s2.setRole("doctor");
        Staff s3 = new Staff(); s3.setUser(u3); s3.setRole("doctor");
        Staff s4 = new Staff(); s4.setUser(u4); s4.setRole("staff");
        Staff s5 = new Staff(); s5.setUser(u5); s5.setRole("staff");
        Staff s6 = new Staff(); s6.setUser(u6); s6.setRole("staff");
        
        staffDAO.addStaff(s1);
        staffDAO.addStaff(s2);
        staffDAO.addStaff(s3);
        staffDAO.addStaff(s4);
        staffDAO.addStaff(s5);
        staffDAO.addStaff(s6);
        
        Patient p1 = new Patient(); p1.setUser(u7); p1.setHealthCardNo("111"); p1.setSocialInsNo(111L);
        Patient p2 = new Patient(); p2.setUser(u8); p2.setHealthCardNo("222"); p2.setSocialInsNo(222L);
        Patient p3 = new Patient(); p3.setUser(u9); p3.setHealthCardNo("333"); p3.setSocialInsNo(333L);
        Patient p4 = new Patient(); p4.setUser(u10); p4.setHealthCardNo("444"); p4.setSocialInsNo(444L);
        
        patientDAO.addPatient(p1);
        patientDAO.addPatient(p2);
        patientDAO.addPatient(p3);
        patientDAO.addPatient(p4);
        
        DoctorPatient dp1 = new DoctorPatient(); dp1.setDoctor(s1); dp1.setPatient(p1); dp1.setPrimaryDoctor(true);
        DoctorPatient dp2 = new DoctorPatient(); dp2.setDoctor(s2); dp2.setPatient(p2); dp2.setPrimaryDoctor(true);
        DoctorPatient dp3 = new DoctorPatient(); dp3.setDoctor(s3); dp3.setPatient(p3); dp3.setPrimaryDoctor(true);
        
        DoctorPatient dp5 = new DoctorPatient(); dp5.setDoctor(s1); dp5.setPatient(p3); dp5.setPrimaryDoctor(false);
        DoctorPatient dp6 = new DoctorPatient(); dp6.setDoctor(s2); dp6.setPatient(p3); dp6.setPrimaryDoctor(false);
        
        doctorPatientDAO.addDoctorPatient(dp1);
        doctorPatientDAO.addDoctorPatient(dp2);
        doctorPatientDAO.addDoctorPatient(dp3);
        doctorPatientDAO.addDoctorPatient(dp5);
        doctorPatientDAO.addDoctorPatient(dp6);

        DoctorStaff ds1 = new DoctorStaff(); ds1.setDoctor(s1); ds1.setStaff(s4);
        DoctorStaff ds2 = new DoctorStaff(); ds2.setDoctor(s2); ds2.setStaff(s5);
        DoctorStaff ds3 = new DoctorStaff(); ds3.setDoctor(s3); ds3.setStaff(s6);
        
        DoctorStaff ds4 = new DoctorStaff(); ds4.setDoctor(s3); ds4.setStaff(s4);
        DoctorStaff ds5 = new DoctorStaff(); ds5.setDoctor(s3); ds5.setStaff(s5);
        
        doctorStaffDAO.addDoctorStaff(ds1);
        doctorStaffDAO.addDoctorStaff(ds2);
        doctorStaffDAO.addDoctorStaff(ds3);
        doctorStaffDAO.addDoctorStaff(ds4);
        doctorStaffDAO.addDoctorStaff(ds5);
        
        Prescription pres1 = new Prescription(); pres1.setName("advil"); pres1.setDescription("1");
        Prescription pres2 = new Prescription(); pres2.setName("tylenol"); pres1.setDescription("2");
        Prescription pres3 = new Prescription(); pres3.setName("morphine"); pres1.setDescription("3");
        Prescription pres4 = new Prescription(); pres4.setName("thc"); pres1.setDescription("4");
        Prescription pres5 = new Prescription(); pres5.setName("planB"); pres1.setDescription("5");
        
        prescriptionDAO.addPrescription(pres1);
        prescriptionDAO.addPrescription(pres2);
        prescriptionDAO.addPrescription(pres3);
        prescriptionDAO.addPrescription(pres4);
        prescriptionDAO.addPrescription(pres5);
        
        VisitPrescription vp1 = new VisitPrescription(); vp1.setPrescription(pres1); vp1.setStartDate(new java.sql.Date(2014, 3, 5)); vp1.setExpiryDate(new java.sql.Date(2014, 3, 15));
        VisitPrescription vp2 = new VisitPrescription(); vp2.setPrescription(pres1); vp2.setStartDate(new java.sql.Date(2014, 3, 6)); vp2.setExpiryDate(new java.sql.Date(2014, 3, 15));
        VisitPrescription vp3 = new VisitPrescription(); vp3.setPrescription(pres2); vp3.setStartDate(new java.sql.Date(2014, 3, 7)); vp3.setExpiryDate(new java.sql.Date(2014, 3, 15));
        VisitPrescription vp4 = new VisitPrescription(); vp4.setPrescription(pres3); vp4.setStartDate(new java.sql.Date(2014, 3, 8)); vp4.setExpiryDate(new java.sql.Date(2014, 3, 15));
        
        visitPrescriptionDAO.addVisitPrescription(vp1);
        visitPrescriptionDAO.addVisitPrescription(vp2);
        visitPrescriptionDAO.addVisitPrescription(vp3);
        visitPrescriptionDAO.addVisitPrescription(vp4);
        
        
        VisitationRecord vr1 = new VisitationRecord(); vr1.setDoctorPatient(dp1); vr1.setVisitPrescription(vp1); 
        vr1.setVisitDate(new java.sql.Date(2014, 3, 5)); vr1.setStartTime(new java.sql.Date(2014, 3, 5)); vr1.setEndTime(new java.sql.Date(2014, 3, 6));
        vr1.setDiagnosis("headache"); vr1.setComments("head hurts"); vr1.setSurgeryPerformed("none"); 
        
        VisitationRecord vr2 = new VisitationRecord(); vr2.setDoctorPatient(dp1); vr2.setVisitPrescription(vp4); 
        vr2.setVisitDate(new java.sql.Date(2014, 3, 6)); vr2.setStartTime(new java.sql.Date(2014, 3, 6)); vr2.setEndTime(new java.sql.Date(2014, 3, 6));
        vr2.setDiagnosis("broken arm"); vr2.setComments("arm hurts"); vr2.setSurgeryPerformed("arm plate"); 
        
        VisitationRecord vr3 = new VisitationRecord(); vr3.setDoctorPatient(dp2); vr3.setVisitPrescription(vp2); 
        vr3.setVisitDate(new java.sql.Date(2014, 3, 5)); vr3.setStartTime(new java.sql.Date(2014, 3, 5)); vr3.setEndTime(new java.sql.Date(2014, 3, 6));
        vr3.setDiagnosis("headache"); vr3.setComments("head hurts"); vr3.setSurgeryPerformed("none"); 
        
        visitationRecordDAO.addVisitationRecord(vr1);
        visitationRecordDAO.addVisitationRecord(vr2);
        visitationRecordDAO.addVisitationRecord(vr3);

        
        Appointment app1 = new Appointment(); 
        app1.setDoctorPatient(dp3); 
        app1.setDateOfApp(new java.sql.Date(2014, 3, 6)); 
        app1.setComments("coming for blood test");
        app1.setProcedureDesc("blood test");
        app1.setStatus("complete");
        app1.setSchedLength(100);
        
        Appointment app2 = new Appointment(); 
        app2.setDoctorPatient(dp3); 
        app2.setDateOfApp(new java.sql.Date(2014, 3, 10)); 
        app2.setComments("coming for results of blood test");
        app2.setProcedureDesc("none");
        app2.setStatus("complete");
        app2.setSchedLength(10);
        
        Appointment app3 = new Appointment(); 
        app3.setDoctorPatient(dp5); 
        app3.setDateOfApp(new java.sql.Date(2014, 3, 7)); 
        app3.setComments("coming for physical test");
        app3.setProcedureDesc("physical");
        app3.setStatus("incomplete");
        app3.setSchedLength(50);
        
        appointmentDAO.addAppointment(app1);
        appointmentDAO.addAppointment(app2);
        appointmentDAO.addAppointment(app3);

                

    }

}
