/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.model.Patient;
import ca.uw.proj.model.User;
import java.util.List;

/**
 *
 * @author siva
 */
public interface PatientDAO {
    public void addPatient(Patient patient);
    public void updatePatient(Patient patient);
    public void removePatient(Patient patient);
    public List<Patient> getPatient(String param, Object value);
    public List<Patient> getAllPatients();
}
