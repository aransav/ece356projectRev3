/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.controller;

import ca.uw.proj.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author siva
 */

@Controller
public class LinkController {
    @RequestMapping(value="/")
    public ModelAndView homePage(){
        return new ModelAndView("home","login-entity",new User());
    }
    
    @RequestMapping(value="")
    public ModelAndView homePage2(){
        return new ModelAndView("home","login-entity",new User());
    }
    
    @RequestMapping(value="/index")
    public ModelAndView indexPage(){
        return new ModelAndView("home","login-entity",new User());
    }
    
}
