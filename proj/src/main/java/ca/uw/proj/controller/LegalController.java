/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.Appointment;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.DoctorStaff;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Prescription;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.model.UserLoginLog;
import ca.uw.proj.model.VisitationRecord;
import ca.uw.proj.service.AppointmentService;
import ca.uw.proj.service.DoctorPatientService;
import ca.uw.proj.service.DoctorStaffService;
import ca.uw.proj.service.PatientService;
import ca.uw.proj.service.PrescriptionDataService;
import ca.uw.proj.service.StaffService;
import ca.uw.proj.service.UserLoginService;
import ca.uw.proj.service.UserService;
import ca.uw.proj.service.VisitationService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author siva
 */
@Controller
public class LegalController {

    @Autowired
    AppointmentService appointmentService;
    @Autowired
    DoctorPatientService doctorPatientService;
    @Autowired
    DoctorStaffService doctorStaffService;
    @Autowired
    PatientService patientService;
    @Autowired
    PrescriptionDataService prescriptionDataService;
    @Autowired
    StaffService staffService;
    @Autowired
    UserService userService;
    @Autowired
    VisitationService visitationService;
    @Autowired
    UserLoginService userLoginService;

    @RequestMapping(value = "legalALL")
    public ModelAndView legalALL(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");
       
        List<Appointment> l_appointment = appointmentService.getAllAppointments();
        List<DoctorPatient> l_doctorPatient = doctorPatientService.getAllDoctorPatient();
        List<DoctorStaff> l_doctorStaff = doctorStaffService.getAllDoctorStaff();
        List<Patient> l_patient = patientService.getAllPatients();
        List<Prescription> l_prescription = prescriptionDataService.getAllPrescriptions();
        List<Staff> l_staff = staffService.getAllStaff();
        List<User> l_user = userService.getUsers();
        List<UserLoginLog> l_userLoginLog = userLoginService.getAllUserLoginLogs();
        List<VisitationRecord> l_visitationRecord = visitationService.getAllVisitationRecord();

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.setViewName("legal-all-view");
        
        m.addObject("l_appointment", l_appointment);
        m.addObject("l_doctorPatient", l_doctorPatient);
        m.addObject("l_doctorStaff", l_doctorStaff);
        m.addObject("l_patient", l_patient);
        m.addObject("l_prescription", l_prescription);
        m.addObject("l_staff", l_staff);
        m.addObject("l_user", l_user);
        m.addObject("l_userLoginLog", l_userLoginLog);
        m.addObject("l_visitationRecord", l_visitationRecord);
        
        
        
        
        return m;

    }

}
