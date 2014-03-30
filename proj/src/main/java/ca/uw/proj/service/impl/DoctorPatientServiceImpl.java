/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.DoctorPatientDAO;
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

    @Override
    public void addDoctorPatient(DoctorPatient doctorPatient) {
        doctorPatientDAO.addDoctorPatient(doctorPatient);
    }

    @Override
    public void addDoctorPatient(Staff doctor, Patient patient, boolean primaryDoctor) {
        DoctorPatient doctorPatient = new DoctorPatient();
        doctorPatient.setDoctor(doctor);
        doctorPatient.setPatient(patient);
        doctorPatient.setPrimaryDoctor(primaryDoctor);
        addDoctorPatient(doctorPatient);
    }

    @Override
    public void updateDoctorPatient(DoctorPatient doctorPatient) {
        doctorPatientDAO.updateDoctorPatient(doctorPatient);
    }

    @Override
    public List<Staff> findDoctorsForPatient(Patient patient) {
        List<DoctorPatient> l = findDoctorPatientsForPatient(patient);
        List<Staff> doctors = new ArrayList<Staff>();
        for (DoctorPatient p : l) {
            doctors.add(p.getDoctor());
        }
        return doctors;
    }

    @Override
    public List<DoctorPatient> findDoctorPatientsForPatient(Patient patient) {
        return doctorPatientDAO.getDoctorPatient("Patient", patient);
    }

    @Override
    public List<Patient> findPatientsforDoctor(Staff doctor) {
        List<DoctorPatient> l = findDoctorPatientsForDoctor(doctor);
        List<Patient> patients = new ArrayList<>();
        for (DoctorPatient p : l) {
            patients.add(p.getPatient());
        }
        return patients;
    }

    @Override
    public List<DoctorPatient> findDoctorPatientsForDoctor(Staff doctor) {
        return doctorPatientDAO.getDoctorPatient("Doctor", doctor);
    }

    @Override
    public DoctorPatient findDoctorPatient(Staff doctor, Patient patient) {
        List<DoctorPatient> listA = findDoctorPatientsForPatient(patient);
        List<DoctorPatient> listB = findDoctorPatientsForDoctor(doctor);
        for (DoctorPatient a: listA){
            for (DoctorPatient b: listB){
                if (a.equals(b)){
                    return a;
                }
            }
        }
        
        return null;
    }

    @Override
    public Staff findPrimaryDoctor(Patient patient) {
        List<DoctorPatient> listA = findDoctorPatientsForPatient(patient);
        for (DoctorPatient a: listA){
            if (a.isPrimaryDoctor()){
                return a.getDoctor();
            }
        }
        return null;
    }

    @Override
    public List<DoctorPatient> getAllDoctorPatient() {
        return doctorPatientDAO.getAllDoctorPatient();
    }

    @Override
    public void removeDoctorPatient(DoctorPatient doctorPatient) {
        doctorPatientDAO.removeDoctorPatient(doctorPatient);
    }

}
