/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.Appointment;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.service.AppointmentService;
import ca.uw.proj.service.DoctorPatientService;
import ca.uw.proj.service.PatientService;
import ca.uw.proj.service.UserService;
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
public class AppointmentsController {

    @Autowired
    private UserService userService;
    @Autowired
    private DoctorPatientService dpService;
    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appService;

    @RequestMapping(value = "appointmentInfo")
    public ModelAndView appointmentInfoDisp(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        List<Appointment> apps = appService.getAppointmentsForUser(u);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", u);
        modelAndView.addObject("role", role);
        modelAndView.addObject("apps", apps);

        modelAndView.setViewName("appDisplay");

        return modelAndView;

    }

    @RequestMapping(value = "displayAppointmentForm")
    public ModelAndView displayAppointmentForm(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");
        ModelAndView modelAndView = new ModelAndView();

        List<Staff> doctors = dpService.getAllDoctors();
        List<Patient> patients = patientService.getAllPatients();
        
        modelAndView.addObject("doctors", doctors);
        modelAndView.addObject("patients", patients);
        
        modelAndView.addObject("role", role);
        modelAndView.addObject("user", u);
        modelAndView.setViewName("appointment-form");

        return modelAndView;
    }

    @RequestMapping(value = "appointmentSubmit")
    public ModelAndView appointmentSubmit(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("role", role);
        modelAndView.addObject("user", u);

        String _doc = request.getParameter("doctor");
        String _pat = request.getParameter("patient");
        String _date = request.getParameter("dateOfApp");
        String _comments = request.getParameter("comments");
        String _schedlength = request.getParameter("schedlength");
        String _proceduredesc = request.getParameter("procedureDesc");
        String _status = request.getParameter("status");

        User u_doc = userService.getUser(_doc);
        User u_pat = userService.getUser(_pat);

        Staff s_doc = new Staff();
        s_doc.setUser(u_doc);
        s_doc.setRole("doctor");

        Patient s_pat = new Patient();
        s_pat.setUser(u_pat);

        DoctorPatient dp = new DoctorPatient();
        dp.setDoctor(s_doc);
        dp.setPatient(s_pat);

        Appointment a = new Appointment();
        a.setDoctorPatient(dp);
        //a.setDateOfApp(new java.sql.Date(date));
        a.setComments(_comments);
        a.setProcedureDesc(_proceduredesc);
        a.setStatus(_status);

        try {
            appService.addAppointment(a);
            modelAndView.setViewName("testingPage");
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("testingPage");
            return modelAndView;
        }

    }

}
