/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao.impl;

import ca.uw.proj.dao.DoctorPatientDAO;
import ca.uw.proj.model.DoctorPatient;
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
public class DoctorPatientDAOImpl implements DoctorPatientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addDoctorPatient(DoctorPatient doctorPatient) {
        getCurrentSession().save(doctorPatient);
    }

    @Override
    public List<DoctorPatient> getDoctorPatient(String parameter, Object value) {
        String hql = "from DoctorPatient where " + parameter + " = :v";
        Query q = getCurrentSession().createQuery(hql);
        q.setParameter("v", value);
        return q.list();
    }

    @Override
    public void updateDoctorPatient(DoctorPatient doctorPatient) {
        getCurrentSession().update(doctorPatient);
    }

    @Override
    public void removeDoctorPatient(DoctorPatient doctorPatient) {
        getCurrentSession().delete(doctorPatient);
    }

    @Override
    public List<DoctorPatient> getAllDoctorPatient() {
        return getCurrentSession().createQuery("from DoctorPatient").list();
    }

}
