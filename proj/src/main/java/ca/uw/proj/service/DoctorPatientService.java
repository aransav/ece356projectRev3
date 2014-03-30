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
    public void addDoctorPatient(Staff doctor, Patient patient, boolean primaryDoctor);
    public void updateDoctorPatient(DoctorPatient doctorPatient);
    public List<Staff> findDoctorsForPatient(Patient patient);
    public List<DoctorPatient> findDoctorPatientsForPatient(Patient patient);
    public List<Patient> findPatientsforDoctor(Staff doctor);
    public List<DoctorPatient> findDoctorPatientsForDoctor(Staff doctor);
    public DoctorPatient findDoctorPatient(Staff doctor, Patient patient);
    public Staff findPrimaryDoctor(Patient patient);
    public List<DoctorPatient> getAllDoctorPatient();
    public void removeDoctorPatient(DoctorPatient doctorPatient);
    
}
