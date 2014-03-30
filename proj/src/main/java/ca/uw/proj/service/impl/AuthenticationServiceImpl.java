/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.UserDAO;
import ca.uw.proj.dao.UserLoginLogDAO;
import ca.uw.proj.model.User;
import ca.uw.proj.service.AuthenticationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author siva
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserLoginLogDAO userLoginLogDAO;

    @Override
    public boolean authenticate(User user) {
        User u = userDAO.getUser(user.getUsername());
        if (u != null){
            if (u.getPassword().equals(user.getPassword())){
                addToUserLoginLog(u);
                return true;
            }
        }
        
        return false;
    }

    @Override
    public boolean authenticate(String username, String password) {
       User u = new User();
       u.setUsername(username);
       u.setPassword(password);
       return authenticate(u);
    }

    public void addToUserLoginLog(User u){
        userLoginLogDAO.addUserLoginLog(u);
    }

}
