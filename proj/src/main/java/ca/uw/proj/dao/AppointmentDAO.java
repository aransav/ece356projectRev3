/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.model.Appointment;
import java.util.List;

/**
 *
 * @author siva
 */
public interface AppointmentDAO {
    public void addAppointment(Appointment app);
    public void updateAppointmment(Appointment app);
    public Appointment getAppointment(Long id);
    public List<Appointment> getAppointment(String param, Object value);
    public List<Appointment> getAllAppointments();
}
