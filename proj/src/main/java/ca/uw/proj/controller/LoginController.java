/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.controller;

import ca.uw.proj.model.User;
import ca.uw.proj.service.AuthenticationService;
import ca.uw.proj.service.UserLoginService;
import ca.uw.proj.service.UserService;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author siva
 */
@Controller
public class LoginController {
    //comment
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login-form")
    public ModelAndView loginPage() {
        return new ModelAndView("home", "login-entity", new User());
    }

    @RequestMapping(value = {"process-user", "/process-user"})
    public ModelAndView processSubmit(@ModelAttribute User user, HttpServletRequest request) throws ServletException {
        ModelAndView modelAndView = new ModelAndView();

        HttpSession session = request.getSession();

        if (authenticationService.authenticate(user)) {

            User u = userService.getUser(user.getUsername());
            String role = userService.userType(u);

            session.setAttribute("user", u);
            session.setAttribute("role", role);
            
            modelAndView.addObject("role", role);
            modelAndView.addObject("user1", u);
            modelAndView.setViewName("dashboard-base");

            
            return modelAndView;
        } else {
            user.setPassword("");
            modelAndView.addObject("user1", user);
            return new ModelAndView("homefail", "login-entity", user);
        }

    }

    @RequestMapping(value = {"logoutRefresh"})
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return new ModelAndView("home", "login-entity", new User());
    }
    
    @RequestMapping(value = "dashboard")
    public ModelAndView dashboardsc(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");

        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.addObject("user1", u);
        m.setViewName("dashboard-base");
        
        return m;
    }

}
