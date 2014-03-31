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
import org.springframework.web.bind.annotation.ModelAttribute;
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

        String errMsg = "";

        if (request.getParameter("count") == null) {
            return visitListInfo(request);
        }

        if (request.getParameter("errMsg") != null) {
            errMsg = request.getParameter("errMsg");
        }

        int id = Integer.valueOf(request.getParameter("count"));

        VisitationRecord v = vService.getAllVisitationRecord(Long.valueOf(id));

        ModelAndView m = new ModelAndView("visiation-record-info-update", "visiationRecordInfoUpdate", v);
        m.addObject("role", role);
        m.addObject("vrecord", v);
        m.addObject("errMsg", errMsg);

        m.setViewName("visiation-record-info-update");

        return m;
    }

    @RequestMapping(value = "submitVRUpdate")
    public ModelAndView submitVRUpdate(HttpServletRequest request, @ModelAttribute VisitationRecord _v) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        String errMessage;
        ModelAndView m;
        Long id = 0L;
        VisitationRecord v;
        try {
            id = _v.getId();
            v = vService.getAllVisitationRecord(id);

            v.setComments(_v.getComments());
            v.setDoctorPatient(_v.getDoctorPatient());
            v.setDiagnosis(_v.getDiagnosis());
            v.setEndTime(_v.getEndTime());
            v.setRevNo(v.getRevNo()+1);
            v.setStartTime(_v.getStartTime());
            v.setSurgeryPerformed(_v.getSurgeryPerformed());
            v.setVisitDate(_v.getVisitDate());
            v.setVisitPrescription(_v.getVisitPrescription());
            
            vService.updateVisitationRecord(v);
            
        } catch (Exception e) {
            errMessage = "Error during updating vistation record";
            request.getSession().setAttribute("errMsg", errMessage);
            request.getSession().setAttribute("count", id);
            return visitationRecordInfoUpdate(request);
        }

        request.getSession().setAttribute("count", id);
        return visitationRecordInfoUpdate(request);

    }
    
    
    @RequestMapping(value = "visitationRecordAdd")
    public ModelAndView visitationRecordAdd(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        String errMsg = "";

        if (request.getParameter("errMsg") != null) {
            errMsg = request.getParameter("errMsg");
        }

        ModelAndView m = new ModelAndView("visiation-record-info-update", "visiationRecordInfoUpdate", new VisitationRecord());
        m.addObject("role", role);
        m.addObject("errMsg", errMsg);

        m.setViewName("visiation-record-info-add");

        return m;
    }

    @RequestMapping(value = "submitVRAdd")
    public ModelAndView submitVRAdd(HttpServletRequest request, @ModelAttribute VisitationRecord _v) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        String errMessage;
        ModelAndView m;
        Long id = 0L;
        VisitationRecord v = new VisitationRecord();
        try {
            v.setComments(_v.getComments());
            v.setDoctorPatient(_v.getDoctorPatient());
            v.setDiagnosis(_v.getDiagnosis());
            v.setEndTime(_v.getEndTime());
            v.setRevNo(0);
            v.setStartTime(_v.getStartTime());
            v.setSurgeryPerformed(_v.getSurgeryPerformed());
            v.setVisitDate(_v.getVisitDate());
            v.setVisitPrescription(_v.getVisitPrescription());
            
            vService.addVisitationRecord(v);
           
        } catch (Exception e) {
            errMessage = e.getMessage();
            request.getSession().setAttribute("errMsg", errMessage);
            return visitationRecordAdd(request);
        }

        return visitListInfo(request);

    }
}
