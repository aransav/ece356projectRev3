/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao.impl;

import ca.uw.proj.dao.DoctorStaffDAO;
import ca.uw.proj.model.DoctorStaff;
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
public class DoctorStaffDAOImpl implements DoctorStaffDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addDoctorStaff(DoctorStaff doctorStaff) {
        getCurrentSession().save(doctorStaff);
    }

    @Override
    public void updateDoctorStaff(DoctorStaff doctorStaff) {
        getCurrentSession().update(doctorStaff);
    }

    @Override
    public void removeDoctorStaff(DoctorStaff doctorStaff) {
        getCurrentSession().delete(doctorStaff);
    }

    @Override
    public List<DoctorStaff> getDoctorStaff(String param, Object value) {
        String hql = "from DoctorStaff where " + param + " = :v";
        Query q = getCurrentSession().createQuery(hql);
        q.setParameter("v", value);
        return q.list();
    }

    @Override
    public List<DoctorStaff> getAllDoctorStaff() {
        return getCurrentSession().createQuery("from DoctorStaff").list();
    }
}
