/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao.impl;

import ca.uw.proj.dao.VisitationRecordDAO;
import ca.uw.proj.model.VisitationRecord;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author siva
 */
@Repository
public class VisitationRecordDAOImpl implements VisitationRecordDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addVisitationRecord(VisitationRecord v) {
        getCurrentSession().save(v);
    }

    @Override
    public void updateVisitationRecord(VisitationRecord v) {
        getCurrentSession().update(v);
    }

    @Override
    public void removeVisitationRecord(VisitationRecord v) {
        getCurrentSession().delete(v);
    }

    @Override
    public List<VisitationRecord> getVisitationRecord(String param, Object value) {
        String hql = "from VisitationRecord where " + param + " = :v";
        Query q = getCurrentSession().createQuery(hql);
        q.setParameter("v", value);
        return q.list();       
    }

    @Override
    public List<VisitationRecord> getAllVisitationRecord() {
        return getCurrentSession().createQuery("from VisitationRecord").list();
    }

}
