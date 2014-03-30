/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.service.impl;

import ca.uw.proj.dao.VisitPrescriptionDAO;
import ca.uw.proj.dao.VisitationRecordDAO;
import ca.uw.proj.model.DoctorPatient;
import ca.uw.proj.model.Patient;
import ca.uw.proj.model.Staff;
import ca.uw.proj.model.User;
import ca.uw.proj.model.VisitPrescription;
import ca.uw.proj.model.VisitationRecord;
import ca.uw.proj.service.VisitationService;
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
public class VisitationServiceImpl implements VisitationService {
    @Autowired
    VisitPrescriptionDAO vpDAO;
    @Autowired
    VisitationRecordDAO vrDAO;

    @Override
    public void addVisitationRecord(VisitationRecord visitationRecord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addVisitationRecord(DoctorPatient doctorPatient, Date visitDate, Date startTime, Date endTime, VisitPrescription visitPrescription, String diagnosis, String comments, String surgeryPerformed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addVisitationRecord(Staff doctor, Patient patient, Date visitDate, Date startTime, Date endTime, VisitPrescription visitPrescription, String diagnosis, String comments, String surgeryPerformed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateVisitationRecord(VisitationRecord visitationRecord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VisitationRecord> getAllVisitationRecord() {
        return vrDAO.getAllVisitationRecord();
    }

    @Override
    public List<VisitationRecord> getAllVisitationRecordByPatient(Patient patient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VisitationRecord> getAllVisitationRecordByDoctor(Staff doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VisitationRecord> getAllVisitationRecordByDate(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VisitationRecord> getAllVisitationRecordByDateRange(Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VisitPrescription> getVisitPrescriptions(User u) {
        List<VisitationRecord> list = getAllVisitationRecord(u);
        if (list == null || list.isEmpty()){
            return new ArrayList<VisitPrescription>();
        }
        List<VisitPrescription> result = new ArrayList<>();
        for (VisitationRecord v: list){
            if (v.getVisitPrescription() != null){
                result.add(v.getVisitPrescription());
            }
        }
        return result;
        
    }
    
    @Override
    public List<VisitationRecord> getAllVisitationRecord(User u){
        List<VisitationRecord> list = getAllVisitationRecord();
        List<VisitationRecord> result = new ArrayList<>();
        
        for (VisitationRecord v: list){
            Staff staff = v.getDoctorPatient().getDoctor();
            Patient patient = v.getDoctorPatient().getPatient();
            
            if (staff.getUser().equals(u) || patient.getUser().equals(u)){
                result.add(v);
            }
        }
        return result;
        
    }
}
