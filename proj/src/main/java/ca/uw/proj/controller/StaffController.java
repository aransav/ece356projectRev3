/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

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
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.model.VisitationRecord;
import ca.uw.proj.service.AppointmentService;
import ca.uw.proj.service.DoctorPatientService;
import ca.uw.proj.service.DoctorStaffService;
import ca.uw.proj.service.PatientService;
import ca.uw.proj.service.PrescriptionDataService;
import ca.uw.proj.service.StaffService;
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
public class StaffController {

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

    @RequestMapping(value = "listDoctorsForThisStaff")
    public ModelAndView listDoctorsForThisStaff(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        List<Staff> doctors = doctorStaffService.findDoctorsForStaff(staffService.getStaffByUser(u));

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.addObject("doctors", doctors);
        m.setViewName("list-doctors-staff");

        return m;
    }

    @RequestMapping(value = "listAppointmentsForDoctor")
    public ModelAndView listAppointmentsForDoctor(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        if (request.getParameter("count") == null) {
            return listDoctorsForThisStaff(request);
        }

        int userID = Integer.valueOf(request.getParameter("count"));

        User doctorUser = userService.getUser(userID);

        List<Appointment> apps = appointmentService.getAppointmentsForUser(doctorUser);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", u);
        modelAndView.addObject("role", role);
        modelAndView.addObject("apps", apps);
        modelAndView.setViewName("appDisplay");

        return modelAndView;

    }

    @RequestMapping(value = "listVRForDoctor")
    public ModelAndView listVRForDoctor(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        if (request.getParameter("count") == null) {
            return listDoctorsForThisStaff(request);
        }

        ModelAndView modelAndView = new ModelAndView();
        
        try {
            int userID = Integer.valueOf(request.getParameter("count"));

            User doctorUser = userService.getUser(userID);

            List<VisitationRecord> l = visitationService.getAllVisitationRecord(doctorUser);

            modelAndView.addObject("role", role);
            modelAndView.addObject("records", l);
            modelAndView.setViewName("view-visitation-records");
        } catch (Exception e) {
            return listDoctorsForThisStaff(request);
        }

        return modelAndView;

    }

}
