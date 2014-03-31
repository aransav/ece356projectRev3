/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.service.DoctorPatientService;
import ca.uw.proj.service.PatientService;
import ca.uw.proj.service.StaffService;
import ca.uw.proj.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class UserController {

    @Autowired
    UserService uS;

    @Autowired
    DoctorPatientService dps;

    @Autowired
    StaffService staffService;

    @Autowired
    PatientService patientService;

    @RequestMapping(value = "userInfoView")
    public ModelAndView userInfoView(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.addObject("user", u);
        m.setViewName("user-info-view");

        return m;
    }

    @RequestMapping(value = "displayUserUpdateForm")
    public ModelAndView displayUserUpdateForm(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        ModelAndView m = new ModelAndView("user-update-form", "user_update_form", new User());

        m.addObject("role", role);
        m.addObject("user", u);
        m.setViewName("user-update-form");

        return m;
    }

    @RequestMapping(value = "submitUserUpdateForm")
    public ModelAndView submitUserUpdateForm(HttpServletRequest request, @ModelAttribute User user) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        user.setId(u.getId());
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());

        uS.updateUser(user);

        request.getSession().setAttribute("user", user);

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.addObject("user", user);
        m.setViewName("user-info-view");

        return m;
    }

    @RequestMapping(value = "listPatients")
    public ModelAndView submitUserUpdateForm(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        int userID;

        if (request.getParameter("doctorID") == null) {
            userID = u.getId();
        } else {
            userID = Integer.valueOf(request.getParameter("doctorID"));
        }

        List<Staff> list = staffService.getStaffByRole("doctor");

        Staff s = null;

        for (Staff s1 : list) {
            if (s1.getUser().getId().equals(userID)) {
                s = s1;
            }
        }

        List<DoctorPatient> list2 = dps.getAllDoctorPatientForDoctor(s);

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.addObject("doctor", s);
        m.addObject("user", u);
        m.addObject("patients", list2);

        m.setViewName("list-patients-for-doctor");

        return m;

    }

    @RequestMapping(value = "viewpatientdocview")
    public ModelAndView viewpatientdocviewForm(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        if (request.getParameter("count") == null) { //added getID
            return submitUserUpdateForm(request);
        }
        //int id = Integer.valueOf(request.getParameter("count"));
        String s = request.getParameter("count");
        User ud = uS.getUser(s);
        Patient p = patientService.getPatientByUser(ud);

        Staff ss = staffService.getStaffByUser(u);
        List<DoctorPatient> list2 = dps.getAllDoctorPatientForPatient(p);
        DoctorPatient dp2 = dps.getDoctorPatient(ss, p);

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.addObject("user", u);
        m.addObject("patient2", p);
        m.addObject("dp2", dp2);
        m.addObject("list", list2);
        m.setViewName("patient-docview");

        return m;
    }

    @RequestMapping(value = "viewpatientdocviewADD")
    public ModelAndView viewpatientdocviewFormAdd(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        if (request.getParameter("count") == null) { //added getID
            return viewpatientdocviewForm(request);
        }
        String s = request.getParameter("count");
        User ud = uS.getUser(s);
        Patient p = patientService.getPatientByUser(ud);
//        
//        HttpSession session = request.getSession();
//        session.setAttribute("patientMap", p);

        ModelAndView m = new ModelAndView("MAPdocAddpatient", "patientAddDoc", new DoctorPatient());
        m.addObject("role", role);
        m.addObject("user", u);
        m.addObject("patient2", p);
        //m.setViewName("MAPdocAddpatient");

        return m;
    }

    @RequestMapping(value = "viewpatientdocviewADDP2")
    public ModelAndView viewpatientdocviewFormAddP2(HttpServletRequest request, @ModelAttribute DoctorPatient s) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");
        String errMessage1 = null;
        String errMessage2 = null;

        try {
            String da = s.getDoctor().getUser().getUsername();
            String db = s.getPatient().getUser().getUsername();
            User u1 = uS.getUser(da);
            User u2 = uS.getUser(db);

            Staff s1 = staffService.getStaffByUser(u1);
            Patient s2 = patientService.getPatientByUser(u2);
            List<DoctorPatient> l1 = dps.getAllDoctorPatient();
            int i = 0;
            for (DoctorPatient l2 : l1) {
                if ((l2.getDoctor() == s1) && (l2.getPatient() == s2)) {
                    i = 1;
                    errMessage1 = "Mapping Already Exisits";
                } else if (s1.getRole().equals("doctor")) {
                    i = 1;
                    errMessage2 = "You have no defined a doctor";
                }
            }
            if (i == 0) {
                DoctorPatient d3 = new DoctorPatient();
                d3.setDoctor(s1);
                d3.setPatient(s2);
                d3.setPrimaryDoctor(false);
                dps.addDoctorPatient(d3);
            }

            List<DoctorPatient> list2 = dps.getAllDoctorPatientForPatient(s2);
        } catch (Exception e) {
            return viewpatientdocviewFormAdd(request);
        }

        //ModelAndView m = new ModelAndView();
        //m.addObject("role", role);
        //m.addObject("user", u);
        //m.addObject("errMessage1", errMessage1);
        //m.addObject("errMessage2", errMessage2);
        //m.addObject("list", list2);
        //m.setViewName("patient-docview");
        return viewpatientdocviewForm(request);
    }

}
