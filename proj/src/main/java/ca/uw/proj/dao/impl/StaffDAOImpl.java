/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.dao.impl;

import ca.uw.proj.dao.StaffDAO;
import ca.uw.proj.model.Staff;
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
public class StaffDAOImpl implements StaffDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void addStaff(Staff staff) {
        getCurrentSession().save(staff);
    }
    
    @Override
    public void updateStaff(Staff staff) {
        getCurrentSession().update(staff);
    }
    
    @Override
    public void removeStaff(Staff staff) {
        getCurrentSession().delete(staff);
    }
    
    @Override
    public List<Staff> getStaff(String param, Object value) {
        String hql = "from Staff where " + param + " = :v";
        Query q = getCurrentSession().createQuery(hql);
        q.setParameter("v", value);
        return q.list();    
    }
    
    @Override
    public List<Staff> getAllStaff() {
        return getCurrentSession().createQuery("from Staff").list();
    }
}
