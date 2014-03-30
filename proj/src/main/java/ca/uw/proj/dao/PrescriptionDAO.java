/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.model.Prescription;
import java.util.List;

/**
 *
 * @author siva
 */
public interface PrescriptionDAO {
    public void addPrescription(Prescription prescription);
    public void removePrescription(Prescription prescription);
    public void updatePrescription(Prescription prescription);
    public List<Prescription> getPrescription(String param, Object value);
    public List<Prescription> getAllPrescription();
}
