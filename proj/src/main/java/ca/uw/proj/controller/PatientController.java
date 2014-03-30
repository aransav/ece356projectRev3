/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.Appointment;
import ca.uw.proj.model.User;
import ca.uw.proj.model.VisitPrescription;
import ca.uw.proj.model.VisitationRecord;
import ca.uw.proj.service.AppointmentService;
import ca.uw.proj.service.PrescriptionDataService;
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
public class PatientController {

    @Autowired
    AppointmentService appService;
    @Autowired
    VisitationService visitService;

    @RequestMapping(value = "patientAppView")
    public ModelAndView patientAppView(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        List<Appointment> list = appService.getAppointmentsForUser(u);

        ModelAndView m = new ModelAndView();
        m.addObject("size", list.size());
        m.addObject("appList", list);
        m.setViewName("patient-app-view");

        return m;
    }

    @RequestMapping(value = "patientPrescripView")
    public ModelAndView patientPrescripView(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        List<VisitPrescription> list = visitService.getVisitPrescriptions(u);

        ModelAndView m = new ModelAndView();
        m.addObject("size", list.size());
        m.addObject("precripList", list);
        m.setViewName("patient-prescrip-view");

        return m;
    }

    @RequestMapping(value = "patientVisitRecordView")
    public ModelAndView patientVisitRecordView(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        List<VisitationRecord> list = visitService.getAllVisitationRecord(u);


        ModelAndView m = new ModelAndView();
        m.addObject("size", list.size());
        m.addObject("vrList", list);
        m.setViewName("patient-vr-view");
        
        return m;

    }

}
