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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author siva
 */
@Controller
public class UserProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "userProf")
    public ModelAndView userProfDisplay(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", u);
        modelAndView.addObject("role", role);

        modelAndView.setViewName("userProf");

        return modelAndView;
    }

    @RequestMapping(value = "userProfEdit")
    public ModelAndView userProfEditDisplay(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        ModelAndView modelAndView = new ModelAndView("userProfEdit", "user-prof-edit", u);
        
        modelAndView.addObject("user", u);
        modelAndView.addObject("role", role);

        return modelAndView;
    }

    @RequestMapping(value = "userProfEditChanges")
    public ModelAndView userProfEditChanges(HttpServletRequest request, @ModelAttribute User user) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");
        
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        user.setId(u.getId());
        userService.updateUser(user);
        
        request.getSession().setAttribute("user", user);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("role", role);

        modelAndView.setViewName("userProf");

        return modelAndView;
    }

}
