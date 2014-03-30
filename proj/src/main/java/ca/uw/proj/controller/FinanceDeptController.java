/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.User;
import ca.uw.proj.service.DoctorPatientService;
import ca.uw.proj.service.UserService;
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
    private DoctorPatientService dpS; 

    @RequestMapping(value = "financialInfoView")
    public ModelAndView financialInfoView(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");
        
        //Summary of Doctor
        

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.addObject("user", u);
        m.setViewName("financial-info-view");

        return m;
    }

}
