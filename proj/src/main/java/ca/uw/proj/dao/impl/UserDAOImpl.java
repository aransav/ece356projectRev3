/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao.impl;

import ca.uw.proj.dao.UserDAO;
import ca.uw.proj.model.User;
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
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    public void updateUser(User user) {
        getCurrentSession().update(user);
    }

    public User getUser(int id) {
        User user = (User) getCurrentSession().get(User.class, id);
        return user;
    }

    public User getUser(String username) {
        return getUser("username", username);
    }

    public User getUser(String parameter, Object value) {
        String hql = "from User where " + parameter + " = :v";
        Query q = getCurrentSession().createQuery(hql);
        q.setParameter("v", value);
        if (q.list().isEmpty()) {
            return null;
        } else {
            return (User) q.list().get(0);
        }
    }

    public void deleteUser(User user) {
        User u = getUser(user.getId());
        if (u != null) {
            getCurrentSession().delete(user);
        }
    }

    public List<User> getAllUsers() {
        return getCurrentSession().createQuery("from User").list();
    }

}
