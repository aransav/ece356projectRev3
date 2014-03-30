/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.AppointmentDAO;
import ca.uw.proj.model.Appointment;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.service.AppointmentService;
import ca.uw.proj.service.DoctorPatientService;
import ca.uw.proj.service.UtilitiesService;
import java.sql.Date;
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
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDAO appointmentDAO;
    @Autowired
    private DoctorPatientService doctorPatientService;
    @Autowired
    private UtilitiesService utilitiesService;

    @Override
    public void addAppointment(Appointment appointment) {
        appointmentDAO.addAppointment(appointment);
    }

    @Override
    public void addAppointment(DoctorPatient doctorPatient, Date date, int schedLength, String procedureDesc, String comments, String status) {
        Appointment app = new Appointment();
        app.setDoctorPatient(doctorPatient);
        app.setDateOfApp(date);
        app.setSchedLength(schedLength);
        app.setProcedureDesc(procedureDesc);
        app.setComments(comments);
        app.setStatus(status);
        addAppointment(app);
    }

    @Override
    public void addAppointment(Staff doctor, Patient patient, Date date, int schedLength, String procedureDesc, String comments, String status) {
        DoctorPatient doctorPatient = doctorPatientService.findDoctorPatient(doctor, patient);
        addAppointment(doctorPatient, date, schedLength, procedureDesc, comments, status);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentDAO.updateAppointmment(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(Staff doctor) {
        List<DoctorPatient> doctorPatients = doctorPatientService.findDoctorPatientsForDoctor(doctor);
        List<Appointment> apps = new ArrayList<Appointment>();
        for (DoctorPatient p : doctorPatients) {
            apps.addAll(appointmentDAO.getAppointment("DoctorPatient", p));
        }
        return apps;
    }

    @Override
    public List<Appointment> getAppointmentForPatient(Patient patient) {
        List<DoctorPatient> doctorPatients = doctorPatientService.findDoctorPatientsForPatient(patient);
        List<Appointment> apps = new ArrayList<Appointment>();
        for (DoctorPatient p : doctorPatients) {
            apps.addAll(appointmentDAO.getAppointment("DoctorPatient", p));
        }
        return apps;
    }

    @Override
    public List<Appointment> getAppointmentsForDate(Date date) {
        return appointmentDAO.getAppointment("dateOfApp", date);

    }

    @Override
    public List<Appointment> getAppointmentsForRange(Date startDate, Date endDate) {
        List<Appointment> apps = new ArrayList<Appointment>();
        List<Date> dates = utilitiesService.generateRangeDates(startDate, endDate);
        for (Date d: dates){
            apps.addAll(getAppointmentsForDate(d));
        }
        return apps;
    }

    @Override
    public List<Appointment> getAppointmentsForUser(User u) {
        List<Appointment> appsAll = getAllAppointments();
        List<Appointment> apps = new ArrayList<>();
        
        for (Appointment a: appsAll){
            DoctorPatient dp = a.getDoctorPatient();
            Staff doctor = dp.getDoctor();
            Patient patient = dp.getPatient();
            
            if (doctor.getUser().equals(u) || patient.getUser().equals(u)){
                apps.add(a);
            }
        }
        
        return apps;
        
    }

}
