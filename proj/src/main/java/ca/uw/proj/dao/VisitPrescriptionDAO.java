/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.model.VisitPrescription;
import java.util.List;

/**
 *
 * @author siva
 */
public interface VisitPrescriptionDAO {
    public void addVisitPrescription(VisitPrescription v);
    public void updateVisitPrescription(VisitPrescription v);
    public void removeVisitPrescription(VisitPrescription v);
    public List<VisitPrescription> getVisitPrescription(String param, Object value);
    public List<VisitPrescription> getAllVisitPrescriptions();
    
}
