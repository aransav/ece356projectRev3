/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.model.DoctorStaff;
import java.util.List;

/**
 *
 * @author siva
 */
public interface DoctorStaffDAO {
    public void addDoctorStaff(DoctorStaff doctorStaff);
    public void updateDoctorStaff(DoctorStaff doctorStaff);
    public void removeDoctorStaff(DoctorStaff doctorStaff);
    public List<DoctorStaff> getDoctorStaff(String param, Object value);
    public List<DoctorStaff> getAllDoctorStaff();
}
