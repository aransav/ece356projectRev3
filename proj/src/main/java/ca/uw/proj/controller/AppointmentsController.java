/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.Appointment;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.DoctorPatientAppointment;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.service.AppointmentService;
import ca.uw.proj.service.DoctorPatientService;
import ca.uw.proj.service.PatientService;
import ca.uw.proj.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "appointmentInfoUpdate")
    public ModelAndView appointmentInfoUpdate(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");        
        if (request.getParameter("count") == null) { //added getID
            return appointmentInfoDisp(request);
        }
        int id = Integer.valueOf(request.getParameter("count"));
        
        Appointment a = appService.getAppointment(id);
        DoctorPatientAppointment dpA = new DoctorPatientAppointment();
        dpA.setDoctor(a.getDoctorPatient().getDoctor());
        dpA.setPatient(a.getDoctorPatient().getPatient());
        dpA.setAppointment(a);
        dpA.setDateOfApp(a.getDateOfApp());
        ModelAndView m = new ModelAndView("update-app-form", "appointmentInfoUpdate", dpA);
        m.addObject("user", u);
        m.addObject("role", role);        
        m.setViewName("update-app-form");
        return m;
    }



    @RequestMapping(value = "startAppSelectPatient")
    public ModelAndView startAppSelectPatient(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");


        DoctorPatientAppointment dpA = new DoctorPatientAppointment();
        dpA.setDoctor(new Staff());
        dpA.setPatient(new Patient());
        dpA.setAppointment(new Appointment());

        ModelAndView m = new ModelAndView("start-app-select-patient-form", "startAppSelectPatient", dpA);
        m.addObject("role", role);
        m.addObject("user", u);
        return m;
    }

    @RequestMapping(value = "submitAppSelectPatient")
    public ModelAndView submitStartAppForm(HttpServletRequest request, @ModelAttribute DoctorPatientAppointment dpA) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        String errMessage;

        ModelAndView m;

        Patient _p = dpA.getPatient();
        Staff _d = dpA.getDoctor();
        Appointment _a = dpA.getAppointment();

        if (_p == null || _d == null || _a == null) {
            errMessage = "Failed to find patient based on entered health card number";
            dpA = new DoctorPatientAppointment();
            dpA.setDoctor(new Staff());
            dpA.setPatient(new Patient());
            dpA.setAppointment(new Appointment());
            m = new ModelAndView("start-app-select-patient-form", "startAppSelectPatient", dpA);
            m.addObject("role", role);
            m.addObject("errMessage", errMessage);
            m.addObject("patient2", _p);
            m.addObject("doctor2", _d);
            m.addObject("appointment2", _a);
            return m;
        }

        //failures
        if (_p.getHealthCardNo() == null || _p.getHealthCardNo().isEmpty() || patientService.getPatientByHealthCardNo(_p.getHealthCardNo()) == null) {
            errMessage = "Failed to find patient based on entered health card number";
            dpA = new DoctorPatientAppointment();
            dpA.setDoctor(new Staff());
            dpA.setPatient(new Patient());
            dpA.setAppointment(new Appointment());
            m = new ModelAndView("start-app-select-patient-form", "startAppSelectPatient", dpA);
            m.addObject("role", role);
            m.addObject("errMessage", errMessage);
            m.addObject("patient2", _p);
            m.addObject("doctor2", _d);
            m.addObject("appointment2", _a);
            return m;
        }

        if (_d.getUser() == null || _d.getUser().getId() == null || userService.getUser(_d.getUser().getId()) == null) {
            dpA = new DoctorPatientAppointment();
            dpA.setDoctor(new Staff());
            dpA.setPatient(new Patient());
            dpA.setAppointment(new Appointment());
            errMessage = "Failed to find doctor based on given ID";
            m = new ModelAndView("start-app-select-patient-form", "startAppSelectPatient", dpA);
            m.addObject("role", role);
            m.addObject("errMessage", errMessage);
            m.addObject("patient2", _p);
            m.addObject("doctor2", _d);
            m.addObject("appointment2", _a);
            return m;
        }

        Patient p = patientService.getPatientByHealthCardNo(_p.getHealthCardNo());
        Staff doctor = userService.findDoctor(userService.getUser(_d.getUser().getId()));

        if (p == null || doctor == null) {
            dpA = new DoctorPatientAppointment();
            dpA.setDoctor(new Staff());
            dpA.setPatient(new Patient());
            dpA.setAppointment(new Appointment());
            errMessage = "Failed to find patient and/or doctor";
            m = new ModelAndView("start-app-select-patient-form", "startAppSelectPatient", dpA);
            m.addObject("role", role);
            m.addObject("errMessage", errMessage);
            m.addObject("patient2", _p);
            m.addObject("doctor2", _d);
            m.addObject("appointment2", _a);
            return m;
        }

        if (!dpService.existsDoctorPatient(doctor, p)) {
            dpA = new DoctorPatientAppointment();
            dpA.setDoctor(new Staff());
            dpA.setPatient(new Patient());
            dpA.setAppointment(new Appointment());
            errMessage = "This doctor and patient are not approved to work together";
            m = new ModelAndView("start-app-select-patient-form", "startAppSelectPatient", dpA);
            m.addObject("role", role);
            m.addObject("errMessage", errMessage);
            m.addObject("patient2", _p);
            m.addObject("doctor2", _d);
            m.addObject("appointment2", _a);
            return m;
        }

        DoctorPatient dp = dpService.getDoctorPatient(doctor, p);
        
        Appointment app = new Appointment();
        app.setDoctorPatient(dp);
        app.setComments(_a.getComments());
        app.setProcedureDesc(_a.getProcedureDesc());
        app.setSchedLength(_a.getSchedLength());
        app.setStatus(_a.getStatus());
        app.setDateOfApp(_a.getDateOfApp());
 

        appService.addAppointment(app);

        m = new ModelAndView();
        m.setViewName("appDisplay");
        m.addObject("role", role);
        m.addObject("user", u);

        return m;

    }
    
    @RequestMapping(value = "submitAppUpdatePatient")
    public ModelAndView startAppUpdateDetails(HttpServletRequest request, @ModelAttribute DoctorPatientAppointment dpA) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        String errMessage;
        
        ModelAndView m;

        Patient _p = dpA.getPatient();
        Staff _d = dpA.getDoctor();
        Appointment _a = dpA.getAppointment();

        if (_p == null || _d == null || _a == null) {
            errMessage = "Failed to find patient based on entered health card number";
            dpA = new DoctorPatientAppointment();
            dpA.setDoctor(new Staff());
            dpA.setPatient(new Patient());
            dpA.setAppointment(new Appointment());
            m = new ModelAndView("update-app-form", "appointmentInfoUpdate", dpA);
            m.addObject("role", role);
            m.addObject("errMessage", errMessage);
            m.addObject("user", u);
            return m;
        }

        //failures
        if (_p.getHealthCardNo() == null || _p.getHealthCardNo().isEmpty() || patientService.getPatientByHealthCardNo(_p.getHealthCardNo()) == null) {
            errMessage = "Failed to find patient based on entered health card number";
            dpA = new DoctorPatientAppointment();
            dpA.setDoctor(new Staff());
            dpA.setPatient(new Patient());
            dpA.setAppointment(new Appointment());
            m = new ModelAndView("update-app-form", "appointmentInfoUpdate", dpA);
            m.addObject("role", role);
            m.addObject("errMessage", errMessage);
            m.addObject("user", u);
            return m;
        }

        if (_d.getUser() == null || _d.getUser().getId() == null || userService.getUser(_d.getUser().getId()) == null) {
            dpA = new DoctorPatientAppointment();
            dpA.setDoctor(new Staff());
            dpA.setPatient(new Patient());
            dpA.setAppointment(new Appointment());
            errMessage = "Failed to find doctor based on given ID";
            m = new ModelAndView("update-app-form", "appointmentInfoUpdate", dpA);
            m.addObject("role", role);
            m.addObject("errMessage", errMessage);
            m.addObject("user", u);
            return m;
        }

        Patient p = patientService.getPatientByHealthCardNo(_p.getHealthCardNo());
        Staff doctor = userService.findDoctor(userService.getUser(_d.getUser().getId()));

        if (p == null || doctor == null) {
            dpA = new DoctorPatientAppointment();
            dpA.setDoctor(new Staff());
            dpA.setPatient(new Patient());
            dpA.setAppointment(new Appointment());
            errMessage = "Failed to find patient and/or doctor";
            m = new ModelAndView("update-app-form", "appointmentInfoUpdate", dpA);
            m.addObject("role", role);
            m.addObject("errMessage", errMessage);
            m.addObject("user", u);
            return m;
        }

        if (!dpService.existsDoctorPatient(doctor, p)) {
            dpA = new DoctorPatientAppointment();
            dpA.setDoctor(new Staff());
            dpA.setPatient(new Patient());
            dpA.setAppointment(new Appointment());
            errMessage = "This doctor and patient are not approved to work together";
            m = new ModelAndView("update-app-form", "appointmentInfoUpdate", dpA);
            m.addObject("role", role);
            m.addObject("errMessage", errMessage);
            m.addObject("user", u);
            return m;
        }

        DoctorPatient dp = dpService.getDoctorPatient(doctor, p);
        
        Appointment app = new Appointment();
        app.setId(_a.getId());
        app.setDoctorPatient(dp);
        app.setComments(_a.getComments());
        app.setProcedureDesc(_a.getProcedureDesc());
        app.setSchedLength(_a.getSchedLength());
        app.setStatus(_a.getStatus());
        app.setDateOfApp(_a.getDateOfApp());
 
        appService.updateAppointment(app);
        List<Appointment> apps = appService.getAppointmentsForUser(u);
        
        m = new ModelAndView();
        m.setViewName("appDisplay");
        m.addObject("role", role);
        m.addObject("user", u);
        m.addObject("apps", apps);
        return m;

    }    

    //this should be unused
    @RequestMapping(value = "submitStartAppForm")
    public ModelAndView submitStartAppForm(HttpServletRequest request, @ModelAttribute Appointment _app) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        User user = userService.getUser(_app.getDoctorPatient().getDoctor().getUser().getId());

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.setViewName("testingPage");

        return m;

    }

}
