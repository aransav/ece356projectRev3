/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.Appointment;
import ca.uw.proj.model.User;
import ca.uw.proj.service.AppointmentService;
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
        
        return  modelAndView;

    }
    
    

}
