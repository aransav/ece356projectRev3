/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service;

import ca.uw.proj.model.User;
import java.util.List;

/**
 *
 * @author siva
 */
public interface UserService {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

    public User getUser(int id);
    
    public User getUser(String username);

    public List<User> getUsers();
    
    public boolean authenticate(User user);
    
    public String userType(User user);
}
