/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.service;

import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import java.util.List;

/**
 *
 * @author siva
 */
public interface StaffService {
    public void addStaff(Staff s);
    public void updateStaff(Staff s);
    public void removeStaff(Staff s);
    
    public Staff getStaffByUserId(int id);
    public Staff getStaffByUser(User user);
    
    public Staff getStaffByStaffId(Long id);
    
    public List<Staff> getStaffByRole(String role);
    
    public List<Staff> getAllStaff();
}
