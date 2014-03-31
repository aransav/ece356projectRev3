/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.DoctorStaffDAO;
import ca.uw.proj.model.DoctorStaff;
import ca.uw.proj.model.Staff;
import ca.uw.proj.service.DoctorStaffService;
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
public class DoctorStaffServiceImpl implements DoctorStaffService {

    @Autowired
    DoctorStaffDAO doctorStaffDAO;

    @Override
    public void addDoctorStaff(DoctorStaff doctorStaff) {
        doctorStaffDAO.addDoctorStaff(doctorStaff);
    }

    @Override
    public void updateDoctorStaff(DoctorStaff doctorStaff) {
        doctorStaffDAO.updateDoctorStaff(doctorStaff);
    }

    @Override
    public void removeDoctorStaff(DoctorStaff doctorStaff) {
        doctorStaffDAO.removeDoctorStaff(doctorStaff);
    }

    @Override
    public List<Staff> findDoctorsForStaff(Staff staff) {
        List<DoctorStaff> list = getAllDoctorStaff();
        List<Staff> result = new ArrayList<>();
        for (DoctorStaff d : list) {
            if (d.getStaff().equals(staff)) {
                if (!result.contains(d.getDoctor())) {
                    result.add(d.getDoctor());
                }
            }
        }
        return result;
    }

    @Override
    public List<Staff> findStaffForDoctor(Staff doctor) {
        List<DoctorStaff> list = getAllDoctorStaff();
        List<Staff> result = new ArrayList<>();
        for (DoctorStaff d : list) {
            if (d.getDoctor().equals(doctor)) {
                if (!result.contains(d.getStaff())) {
                    result.add(d.getStaff());
                }
            }
        }
        return result;
    }

    @Override
    public List<DoctorStaff> getAllDoctorStaff() {
        return doctorStaffDAO.getAllDoctorStaff();
    }

}
