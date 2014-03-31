/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.transients;

import ca.uw.proj.model.Staff;

/**
 *
 * @author siva
 */
public class DoctorFinancialObj {
    public Staff doctor;
    public int totalAppointments;
    public int totalPatients;
    
    
    public DoctorFinancialObj() {
    }

    public Staff getDoctor() {
        return doctor;
    }

    public void setDoctor(Staff doctor) {
        this.doctor = doctor;
    }

    public int getTotalAppointments() {
        return totalAppointments;
    }

    public void setTotalAppointments(int totalAppointments) {
        this.totalAppointments = totalAppointments;
    }

    public int getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(int totalPatients) {
        this.totalPatients = totalPatients;
    }
    
    
    
    
    
    
}
