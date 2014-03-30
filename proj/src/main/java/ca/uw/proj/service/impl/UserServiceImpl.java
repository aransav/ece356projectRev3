/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.StaffDAO;
import ca.uw.proj.dao.UserDAO;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private StaffDAO staffDAO;

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    public List<User> getUsers() {
        return userDAO.getAllUsers();
    }

    public boolean authenticate(User user) {
        List<User> users = getUsers();

        return (users.contains(user));

    }

    @Override
    public User getUser(String username) {
        return userDAO.getUser(username);
    }

    @Override
    public String userType(User user) {
        List<Staff> staffs = staffDAO.getStaff("user", user);
        
        if(staffs == null || staffs.isEmpty()){
            return "patient";
        }else{
            return staffs.get(0).getRole();
        }
    }
}
