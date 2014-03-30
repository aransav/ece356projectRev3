/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao.impl;

import ca.uw.proj.dao.UserLoginLogDAO;
import ca.uw.proj.model.User;
import ca.uw.proj.model.UserLoginLog;
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
public class UserLoginLogDAOImpl implements UserLoginLogDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addUserLoginLog(UserLoginLog u) {
        getCurrentSession().save(u);
    }

    public List<UserLoginLog> getUserLoginLogs(User user) {
        Query q = getCurrentSession().createQuery("from UserLoginLog where user = :u");
        q.setParameter("u", user);
        return q.list();
    }
    
    public List<UserLoginLog> getAllUserLoginLogs() {
        return getCurrentSession().createQuery("from UserLoginLog").list();
    }


    public void addUserLoginLog(User user) {
        UserLoginLog u = new UserLoginLog();
        u.setUser(user);
        
        java.util.Date utilDate = new java.util.Date();
        u.setLogin_time(new java.sql.Date(utilDate.getTime()));
        addUserLoginLog(u);
    }
    
    

}
