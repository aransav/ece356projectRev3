/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.model.User;
import java.util.List;

/**
 *
 * @author siva
 */
public interface UserDAO {
    public void addUser(User user);
    public void updateUser(User user);
    
    public User getUser(int id);
    public User getUser(String username);
    public User getUser(String parameter, Object value);
    
    public void deleteUser(User user);
  
    public List<User> getAllUsers();
}
