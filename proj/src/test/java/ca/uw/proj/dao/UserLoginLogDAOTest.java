/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao;

import ca.uw.proj.init.ProjectConfig;
import ca.uw.proj.model.User;
import ca.uw.proj.model.UserLoginLog;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author siva
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {ProjectConfig.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
@Ignore
public class UserLoginLogDAOTest {

    @Autowired
    UserLoginLogDAO userLoginLogDAO;

    User u1;
    User u2;
    User u3;

    UserLoginLog ul1;
    UserLoginLog ul2;
    UserLoginLog ul3;

    public UserLoginLogDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        u1 = new User();
        u1.setUsername("user1");
        u1.setPassword("password");

        u2 = new User();
        u2.setUsername("user2");
        u2.setPassword("password");

        u3 = new User();
        u3.setUsername("user3");
        u3.setPassword("password");

        ul1 = new UserLoginLog();
        ul1.setUser(u1);
        ul1.setLogin_time(new java.sql.Date(1000));

        ul2 = new UserLoginLog();
        ul2.setUser(u2);
        ul2.setLogin_time(new java.sql.Date(2000));

        ul3 = new UserLoginLog();
        ul3.setUser(u3);
        ul3.setLogin_time(new java.sql.Date(3000));

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addUserLoginLog method, of class UserLoginLogDAO.
     */
    @Test
    public void testAddUserLoginLog_User() {
        System.out.println("addUserLoginLog");

        userLoginLogDAO.addUserLoginLog(u1);

        List<UserLoginLog> l = userLoginLogDAO.getAllUserLoginLogs();

        assertEquals(1, l.size());

        assertEquals(u1, l.get(0).getUser());

    }

    /**
     * Test of addUserLoginLog method, of class UserLoginLogDAO.
     */
    @Test
    public void testAddUserLoginLog_UserLoginLog() {
        System.out.println("addUserLoginLog");

        userLoginLogDAO.addUserLoginLog(ul1);

        List<UserLoginLog> l = userLoginLogDAO.getAllUserLoginLogs();

        assertEquals(1, l.size());

        assertEquals(ul1.getUser(), l.get(0).getUser());
    }

    /**
     * Test of getUserLoginLogs method, of class UserLoginLogDAO.
     */
    @Test
    public void testGetUserLoginLogs() {
        System.out.println("getUserLoginLogs");

        userLoginLogDAO.addUserLoginLog(u1);
        userLoginLogDAO.addUserLoginLog(u1);
        userLoginLogDAO.addUserLoginLog(u1);
        userLoginLogDAO.addUserLoginLog(ul1);

        userLoginLogDAO.addUserLoginLog(u2);
        userLoginLogDAO.addUserLoginLog(u3);

        List<UserLoginLog> l = userLoginLogDAO.getUserLoginLogs(u1);

        assertEquals(4, l.size());
        assertEquals(u1, l.get(0).getUser());
        assertEquals(u1, l.get(1).getUser());
        assertEquals(u1, l.get(2).getUser());
        assertEquals(u1, l.get(3).getUser());

    }

    /**
     * Test of getAllUserLoginLogs method, of class UserLoginLogDAO.
     */
    @Test
    public void testGetAllUserLoginLogs() {
        System.out.println("getAllUserLoginLogs");
        
        userLoginLogDAO.addUserLoginLog(u1);
        userLoginLogDAO.addUserLoginLog(u1);
        userLoginLogDAO.addUserLoginLog(u1);
        userLoginLogDAO.addUserLoginLog(ul1);

        userLoginLogDAO.addUserLoginLog(u2);
        userLoginLogDAO.addUserLoginLog(u3);

        List<UserLoginLog> l = userLoginLogDAO.getAllUserLoginLogs();
        
        assertEquals(6, l.size());
        

    }

}
