/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.Patient;
import ca.uw.proj.model.User;
import ca.uw.proj.service.PatientService;
import ca.uw.proj.service.UserService;
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
public class UserPatientInfoController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "patientInfo")
    public ModelAndView partientInfoDisp(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", u);
        modelAndView.addObject("role", role);
        modelAndView.addObject("patient", patientService.getPatient(u));

        modelAndView.setViewName("patientInfo");

        return modelAndView;
    }

    @RequestMapping(value = "patientInfoEdit")
    public ModelAndView userProfEditDisplay(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        ModelAndView modelAndView = new ModelAndView("patientInfoEdit", "patient-info-edit", new Patient());

        modelAndView.addObject("user", u);
        modelAndView.addObject("role", role);

        return modelAndView;
    }

    @RequestMapping(value = "patientInfoEditChanges")
    public ModelAndView userProfEditChanges(HttpServletRequest request, @ModelAttribute Patient patient) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        Patient p = patientService.getPatient(u);
        p.setHealthCardNo(patient.getHealthCardNo());
        p.setSocialInsNo(patient.getSocialInsNo());
        patientService.updatePatient(p);
    
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", u);
        modelAndView.addObject("role", role);
        modelAndView.addObject("patient", patientService.getPatient(u));

        modelAndView.setViewName("patientInfo");

        return modelAndView;
    }

}
