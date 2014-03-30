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
    public Patient getPatient(User u) {
        if (patientDAO.getPatient("u", u) != null){
            return patientDAO.getPatient("u", u).get(0);
        }else{
            return null;
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        patientDAO.updatePatient(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
    
}
