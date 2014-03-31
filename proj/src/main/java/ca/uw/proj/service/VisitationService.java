/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service;

import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Prescription;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.model.VisitPrescription;
import ca.uw.proj.model.VisitationRecord;
import java.util.List;

/**
 *
 * @author siva
 */
public interface VisitationService {

    public void addVisitationRecord(VisitationRecord visitationRecord);
    public void updateVisitationRecord(VisitationRecord visitationRecord);
    public void removeVisitationRecord(VisitationRecord visitationRecord);
    
    
    public List<VisitationRecord> getAllVisitationRecord();
    public List<VisitationRecord> getAllVisitationRecordByPatient(Patient patient);
    public List<VisitationRecord> getAllVisitationRecordByDoctor(Staff doctor);
    
    public List<VisitationRecord> getAllVisitationRecordByDate(java.sql.Date date);
    public List<VisitationRecord> getAllVisitationRecordByDateRange(java.sql.Date startDate, java.sql.Date endDate);
    

    public List<VisitationRecord> getAllVisitationRecord(User u);
    
    public List<VisitPrescription> getVisitPrescriptions(User u);
    public List<VisitPrescription> getVisitPrescriptions(Prescription p);
}
