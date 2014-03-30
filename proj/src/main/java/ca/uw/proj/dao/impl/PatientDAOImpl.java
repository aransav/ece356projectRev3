/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao.impl;

import ca.uw.proj.dao.PatientDAO;
import ca.uw.proj.model.Patient;
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
public class PatientDAOImpl implements PatientDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addPatient(Patient patient) {
        getCurrentSession().save(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        getCurrentSession().update(patient);
    }

    @Override
    public void removePatient(Patient patient) {
        getCurrentSession().delete(patient);
    }

    @Override
    public List<Patient> getPatient(String param, Object value) {
        String hql = "from Patient where " + param + " = :v";
        Query q = getCurrentSession().createQuery(hql);
        q.setParameter("v", value);
        return q.list();
    }

    @Override
    public List<Patient> getAllPatients() {
        return getCurrentSession().createQuery("from Patient").list();
    }
    
    
}
