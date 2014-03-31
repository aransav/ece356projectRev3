/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.User;
import ca.uw.proj.model.VisitationRecord;
import ca.uw.proj.service.AppointmentService;
import ca.uw.proj.service.DoctorPatientService;
import ca.uw.proj.service.PatientService;
import ca.uw.proj.service.UserService;
import ca.uw.proj.service.VisitationService;
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
public class VisitationRecordController {

    @Autowired
    private UserService userService;
    @Autowired
    private DoctorPatientService dpService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private VisitationService vService;

    @RequestMapping(value = "listVisitationRecords")
    public ModelAndView visitListInfo(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        int userID;
        if (request.getParameter("visitrecordForId") != null) {
            userID = Integer.valueOf(request.getParameter("visitrecordForId"));
        } else {
            userID = u.getId();
        }

        List<VisitationRecord> l = new ArrayList<>();

        l = vService.getAllVisitationRecord(userService.getUser(userID));

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.addObject("records", l);
        m.setViewName("view-visitation-records");

        return m;
    }

    @RequestMapping(value = "visitationRecordInfoUpdate")
    public ModelAndView visitationRecordInfoUpdate(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        if (request.getParameter("count") == null) {
            return visitListInfo(request);
        }
        int id = Integer.valueOf(request.getParameter("count"));

        VisitationRecord v = vService.getAllVisitationRecord(Long.valueOf(id));

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.addObject("vrecord", v);

        m.setViewName("visiation-record-info-display");
        
        return m;
    }
}
