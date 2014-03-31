/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.transients;

import ca.uw.proj.model.Prescription;

/**
 *
 * @author siva
 */
public class PrescriptionFinancialObj {
    Prescription prescription;
    int totalTimesAssigned;

    public int getTotalTimesAssigned() {
        return totalTimesAssigned;
    }

    public void setTotalTimesAssigned(int totalTimesAssigned) {
        this.totalTimesAssigned = totalTimesAssigned;
    }
    
    public PrescriptionFinancialObj() {
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
    
    
    
}
