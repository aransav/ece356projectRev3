/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.DoctorPatientDAO;
import ca.uw.proj.dao.PatientDAO;
import ca.uw.proj.dao.StaffDAO;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import ca.uw.proj.service.DoctorPatientService;
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
public class DoctorPatientServiceImpl implements DoctorPatientService {

    @Autowired
    DoctorPatientDAO doctorPatientDAO;

    @Autowired
    StaffDAO staffDAO;

    @Autowired
    PatientDAO patientDAO;

    @Override
    public void addDoctorPatient(DoctorPatient doctorPatient) {
        doctorPatientDAO.addDoctorPatient(doctorPatient);
    }

    @Override
    public void updateDoctorPatient(DoctorPatient doctorPatient) {
        doctorPatientDAO.updateDoctorPatient(doctorPatient);
    }

    @Override
    public void removeoctorPatient(DoctorPatient doctorPatient) {
        doctorPatientDAO.removeDoctorPatient(doctorPatient);
    }

    @Override
    public List<DoctorPatient> getAllDoctorPatient() {
        return doctorPatientDAO.getAllDoctorPatient();
    }

    @Override
    public List<Staff> getAllDoctorForPatient(Patient patient) {
        List<DoctorPatient> list = getAllDoctorPatient();
        List<Staff> result = new ArrayList<>();
        for (DoctorPatient d : list) {
            if (d.getPatient().equals(patient)) {
                result.add(d.getDoctor());
            }
        }
        return result;
    }

    @Override
    public List<Patient> getAllPatientForDoctor(Staff doctor) {
        List<DoctorPatient> list = getAllDoctorPatient();
        List<Patient> result = new ArrayList<>();
        for (DoctorPatient d : list) {
            if (d.getDoctor().equals(doctor)) {
                result.add(d.getPatient());
            }
        }
        return result;
    }
    
    
    @Override
    public List<DoctorPatient> getAllDoctorPatientForDoctor(Staff doctor) {
        List<DoctorPatient> list = getAllDoctorPatient();
        List<DoctorPatient> result = new ArrayList<>();
        for (DoctorPatient d : list) {
            if (d.getDoctor().equals(doctor)) {
                result.add(d);
            }
        }
        return result;
    }    
    
    @Override
    public List<DoctorPatient> getAllDoctorPatientForPatient(Patient patient) {
        List<DoctorPatient> list = getAllDoctorPatient();
        List<DoctorPatient> result = new ArrayList<>();
        for (DoctorPatient d : list) {
            if (d.getPatient().equals(patient)) {
                result.add(d);
            }
        }
        return result;
    }    

    @Override
    public boolean existsDoctorPatient(Staff doctor, Patient patient) {
        List<DoctorPatient> list = getAllDoctorPatient();
        for (DoctorPatient d : list) {
            if (d.getDoctor().equals(doctor) && d.getPatient().equals(patient)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public DoctorPatient getDoctorPatient(Staff doctor, Patient patient) {
        List<DoctorPatient> list = getAllDoctorPatient();
        for (DoctorPatient d : list) {
            if (d.getDoctor().equals(doctor) && d.getPatient().equals(patient)) {
                return d;
            }
        }
        return null;
    }

}
