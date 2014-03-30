/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.PatientDAO;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.User;
import ca.uw.proj.service.PatientService;
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
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDAO patientDAO;

    @Override
    public void addPatient(Patient p) {
        patientDAO.addPatient(p);
    }

    @Override
    public void removePatient(Patient p) {
        patientDAO.removePatient(p);
    }

    @Override
    public void updatePatient(Patient p) {
        patientDAO.updatePatient(p);
    }

    @Override
    public Patient getPatientByHealthCardNo(String healthCardNo) {
        List<Patient> list = patientDAO.getPatient("healthCardNo", healthCardNo);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Patient getPatientBySIN(long SIN) {
        List<Patient> list = patientDAO.getPatient("SIN", SIN);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Patient getPatientByUserId(int id) {
        List<Patient> list = getAllPatients();
        for (Patient p : list) {
            if (p.getUser().getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Patient getPatientByUser(User u) {
        return getPatientByUserId(u.getId());
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    @Override
    public Patient getPatientByPatientId(Long id) {
        List<Patient> list = getAllPatients();
        for (Patient p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

}
