/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.model.DoctorPatient;
import java.util.List;

/**
 *
 * @author siva
 */
public interface DoctorPatientDAO {
    public void addDoctorPatient(DoctorPatient doctorPatient);
    public List<DoctorPatient> getDoctorPatient(String parameter, Object value);
    public void updateDoctorPatient(DoctorPatient doctorPatient);
    public void removeDoctorPatient(DoctorPatient doctorPatient);
    public List<DoctorPatient> getAllDoctorPatient();
    
}
