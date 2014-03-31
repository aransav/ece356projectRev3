/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.service;

import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import java.util.List;

/**
 *
 * @author siva
 */
public interface DoctorPatientService {
    public void addDoctorPatient(DoctorPatient doctorPatient);
    public void updateDoctorPatient(DoctorPatient doctorPatient);
    public void removeoctorPatient(DoctorPatient doctorPatient);
    public List<DoctorPatient> getAllDoctorPatient();
    
    public List<Staff> getAllDoctorForPatient(Patient patient);
    public List<Patient> getAllPatientForDoctor(Staff doctor);
    
    public boolean existsDoctorPatient(Staff doctor, Patient patient);
    public DoctorPatient getDoctorPatient(Staff doctor, Patient patient);

    public List<DoctorPatient> getAllDoctorPatientForDoctor(Staff doctor);
    public List<DoctorPatient> getAllDoctorPatientForPatient(Patient patient);
    
}
