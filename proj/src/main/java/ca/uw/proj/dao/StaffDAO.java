/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.model.Staff;
import java.util.List;

/**
 *
 * @author siva
 */
public interface StaffDAO {
    public void addStaff(Staff staff);
    public void updateStaff(Staff staff);
    public void removeStaff(Staff staff);
    public List<Staff> getStaff(String param, Object value);
    public List<Staff> getAllStaff();
}
