/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.service;

import ca.uw.proj.model.User;
import ca.uw.proj.model.UserLoginLog;
import java.util.List;

/**
 *
 * @author siva
 */
public interface UserLoginService {
    
    public boolean authenticate(User u);
    
    public List<UserLoginLog> getUserLoginLogs(User u);
    public List<UserLoginLog> getAllUserLoginLogs();
    
}
