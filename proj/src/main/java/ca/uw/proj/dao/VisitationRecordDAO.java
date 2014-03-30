/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao;

import ca.uw.proj.model.VisitationRecord;
import java.util.List;

/**
 *
 * @author siva
 */
public interface VisitationRecordDAO {
    public void addVisitationRecord(VisitationRecord v);
    public void updateVisitationRecord(VisitationRecord v);
    public void removeVisitationRecord(VisitationRecord v);
    public List<VisitationRecord> getVisitationRecord(String param, Object value);
    public List<VisitationRecord> getAllVisitationRecord();
    
}
