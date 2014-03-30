/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.StaffDAO;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.service.StaffService;
import java.util.ArrayList;
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
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffDAO staffDAO;

    @Override
    public void addStaff(Staff s) {
        staffDAO.addStaff(s);
    }

    @Override
    public void updateStaff(Staff s) {
        staffDAO.updateStaff(s);
    }

    @Override
    public void removeStaff(Staff s) {
        staffDAO.removeStaff(s);
    }

    @Override
    public Staff getStaffByUserId(int id) {
        List<Staff> list = getAllStaff();
        for (Staff s : list) {
            if (s.getUser().getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Staff getStaffByUser(User user) {
        return getStaffByUserId(user.getId());
    }

    @Override
    public Staff getStaffByStaffId(Long id) {
        List<Staff> list = getAllStaff();
        for (Staff s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;

    }

    @Override
    public List<Staff> getStaffByRole(String role) {
         List<Staff> list = getAllStaff();
         List<Staff> result = new ArrayList<>();
         for (Staff s: list){
             if (s.getRole().equals(role)){
                 result.add(s);
             }
         }
         return result;
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffDAO.getAllStaff();
    }

}
