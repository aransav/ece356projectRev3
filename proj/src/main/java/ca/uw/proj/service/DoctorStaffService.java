/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.service;

import ca.uw.proj.model.DoctorStaff;
import ca.uw.proj.model.Staff;
import java.util.List;

/**
 *
 * @author siva
 */
public interface DoctorStaffService {
    public void addDoctorStaff(DoctorStaff doctorStaff);
    public void updateDoctorStaff(DoctorStaff doctorStaff);
    public void removeDoctorStaff(DoctorStaff doctorStaff);
    public List<Staff> findDoctorsForStaff(Staff staff);
    public List<Staff> findStaffForDoctor(Staff doctor);
    public List<DoctorStaff> getAllDoctorStaff(DoctorStaff doctorStaff);
    
}
