/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.Appointment;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.service.AppointmentService;
import ca.uw.proj.service.DoctorPatientService;
import ca.uw.proj.service.DoctorStaffService;
import ca.uw.proj.service.PatientService;
import ca.uw.proj.service.PrescriptionDataService;
import ca.uw.proj.service.StaffService;
import ca.uw.proj.service.UserService;
import ca.uw.proj.service.VisitationService;
import ca.uw.proj.transients.DoctorFinancialObj;
import java.util.ArrayList;
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
public class FinanceDeptController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private StaffService staffService; 
    
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
    VisitationService visitationService;

    

    @RequestMapping(value = "financialDoctorInfo")
    public ModelAndView financialInfoView(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");
        
        List<Staff> doctors = staffService.getStaffByRole("doctor");
        List<DoctorFinancialObj> summary = new ArrayList<DoctorFinancialObj>();
        
        for (Staff d: doctors){
            DoctorFinancialObj df = new DoctorFinancialObj();
            df.setDoctor(d);
            
            List<Appointment> appointments =  appointmentService.getAppointmentsForDoctor(d);
            df.setTotalAppointments(appointments.size());
            
            List<Patient> patients = doctorPatientService.getAllPatientForDoctor(d);
            df.setTotalPatients(patients.size());
            
            summary.add(df);
        }
        
        

        ModelAndView m = new ModelAndView();
        m.addObject("summaryList",summary);
        m.addObject("role", role);

        m.setViewName("financial-doctor-nfo-view");

        return m;
    }

}
