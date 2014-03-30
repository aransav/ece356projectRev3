/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.model;

/**
 *
 * @author siva
 */
public class DoctorPatientAppointment {
    Staff doctor;
    Patient patient;
    Appointment appointment;
    String dateOfApp;

    public DoctorPatientAppointment() {
    }

    public Staff getDoctor() {
        return doctor;
    }

    public void setDoctor(Staff doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getDateOfApp() {
        return dateOfApp;
    }

    public void setDateOfApp(String dateOfApp) {
        this.dateOfApp = dateOfApp;
    }
    
    
    
}
