/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao.impl;

import ca.uw.proj.dao.VisitPrescriptionDAO;
import ca.uw.proj.model.VisitPrescription;
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
public class VisitPrescriptionDAOImpl implements VisitPrescriptionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addVisitPrescription(VisitPrescription v) {
        getCurrentSession().save(v);
    }

    @Override
    public void updateVisitPrescription(VisitPrescription v) {
        getCurrentSession().update(v);
    }

    @Override
    public void removeVisitPrescription(VisitPrescription v) {
        getCurrentSession().delete(v);
    }

    @Override
    public List<VisitPrescription> getVisitPrescription(String param, Object value) {
        String hql = "from VisitPrescription where " + param + " = :v";
        Query q = getCurrentSession().createQuery(hql);
        q.setParameter("v", value);
        return q.list();
    }

    @Override
    public List<VisitPrescription> getAllVisitPrescriptions() {
        return getCurrentSession().createQuery("from VisitPrescription").list();
    }

}
