/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.service;

import ca.uw.proj.model.Patient;
import ca.uw.proj.model.User;
import java.util.List;

/**
 *
 * @author siva
 */
public interface PatientService {
    //comment
    public void addPatient(Patient p);
    public void removePatient(Patient p);
    public void updatePatient(Patient p);

    
    public Patient getPatientByHealthCardNo(String healthCardNo);
    public Patient getPatientBySIN(long SIN);
    
    public Patient getPatientByUserId(int id);
    public Patient getPatientByUser(User u);
    
    public Patient getPatientByPatientId(Long id);
    
    
    public List<Patient> getAllPatients();
}
