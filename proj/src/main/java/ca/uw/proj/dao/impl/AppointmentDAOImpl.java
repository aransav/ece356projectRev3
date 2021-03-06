/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao.impl;

import ca.uw.proj.dao.AppointmentDAO;
import ca.uw.proj.model.Appointment;
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
public class AppointmentDAOImpl implements AppointmentDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void addAppointment(Appointment app) {
        getCurrentSession().save(app);
    }

    @Override
    public void updateAppointmment(Appointment app) {
        getCurrentSession().update(app);
    }

    @Override
    public Appointment getAppointment(Long id) {
        return (Appointment)getCurrentSession().get(Appointment.class, id);
    }

    @Override
    public List<Appointment> getAppointment(String param, Object value) {
        String hql = "from Appointment where " + param + " = :v";
        Query q = getCurrentSession().createQuery(hql);
        q.setParameter("v", value);
        return q.list();
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return getCurrentSession().createQuery("from Appointment").list();
    }
    
}
