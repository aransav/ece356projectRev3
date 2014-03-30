/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.controller;

import ca.uw.proj.model.Patient;
import ca.uw.proj.model.User;
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
public class UserController {
    
    @Autowired
    UserService uS;
    
    
    @RequestMapping(value = "userInfoView")
     public ModelAndView userInfoView(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");
        
        ModelAndView m = new ModelAndView();
        m.addObject("role", role);
        m.addObject("user",u);
        m.setViewName("user-info-view");
        
        return m;
     }
     
     @RequestMapping(value = "displayUserUpdateForm")
     public ModelAndView displayUserUpdateForm(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        String role = (String) request.getSession().getAttribute("role");
        
        ModelAndView m = new ModelAndView("user-update-form", "user_update_form", new User());
       
        m.addObject("role", role);
        m.addObject("user",u);
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
        m.addObject("user",user);
        m.setViewName("user-info-view");
        
        return m;
     }
    
}