/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.UserDAO;
import ca.uw.proj.dao.UserLoginLogDAO;
import ca.uw.proj.model.User;
import ca.uw.proj.model.UserLoginLog;
import ca.uw.proj.service.UserLoginService;
import ca.uw.proj.service.UserService;
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
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginLogDAO userLoginLogDAO;
    private UserService userService;

    @Override
    public boolean authenticate(User u) {
        if (userService.authenticate(u)){
            userLoginLogDAO.addUserLoginLog(u);
            return true;
        }
        return false;
    }

    @Override
    public List<UserLoginLog> getUserLoginLogs(User u) {
        return userLoginLogDAO.getUserLoginLogs(u);
    }

    @Override
    public List<UserLoginLog> getAllUserLoginLogs() {
        return userLoginLogDAO.getAllUserLoginLogs();
    }

}
