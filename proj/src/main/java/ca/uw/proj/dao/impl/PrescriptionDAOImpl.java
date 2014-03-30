/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao.impl;

import ca.uw.proj.dao.PrescriptionDAO;
import ca.uw.proj.model.Prescription;
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
public class PrescriptionDAOImpl implements PrescriptionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addPrescription(Prescription prescription) {
        getCurrentSession().save(prescription);
    }

    @Override
    public void removePrescription(Prescription prescription) {
        getCurrentSession().delete(prescription);
    }

    @Override
    public void updatePrescription(Prescription prescription) {
        getCurrentSession().update(prescription);
    }

    @Override
    public List<Prescription> getPrescription(String param, Object value) {
        String hql = "from Prescription where " + param + " = :v";
        Query q = getCurrentSession().createQuery(hql);
        q.setParameter("v", value);
        return q.list();
    }

    @Override
    public List<Prescription> getAllPrescription() {
        return getCurrentSession().createQuery("from Prescription").list();
    }

}
