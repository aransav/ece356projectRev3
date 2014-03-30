/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.service;

import ca.uw.proj.model.Appointment;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import java.util.List;

/**
 *
 * @author siva
 */
public interface AppointmentService {
    public void addAppointment(Appointment appointment);
    public void addAppointment(DoctorPatient doctorPatient, java.sql.Date date, int schedLength, String procedureDesc, String comments, String status);
    public void addAppointment(Staff doctor, Patient patient, java.sql.Date date, int schedLength, String procedureDesc, String comments, String status);
    public void updateAppointment(Appointment appointment);
    public List<Appointment> getAllAppointments();
    public List<Appointment> getAppointmentsForDoctor(Staff doctor);
    public List<Appointment> getAppointmentForPatient(Patient patient);
    public List<Appointment> getAppointmentsForDate(java.sql.Date date);
    public List<Appointment> getAppointmentsForRange(java.sql.Date startDate, java.sql.Date endDate);
    public List<Appointment> getAppointmentsForUser(User u);
    
}
