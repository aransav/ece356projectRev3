/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.dao;

import ca.uw.proj.dao.impl.UserDAOImpl;
import ca.uw.proj.init.ProjectConfig;
import ca.uw.proj.model.User;
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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

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
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    public UserDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    /**
     * Test of addUser method, of class UserDAO.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");

        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        userDAO.addUser(user);

        assertEquals(1, userDAO.getAllUsers().size());
        User u1 = userDAO.getAllUsers().get(0);
        assertEquals("user1", u1.getUsername());
        assertEquals("password", u1.getPassword());
    }

    /**
     * Test of updateUser method, of class UserDAO.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");

        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        userDAO.addUser(user);

        assertEquals(1, userDAO.getAllUsers().size());
        User u1 = userDAO.getAllUsers().get(0);
        assertEquals("user1", u1.getUsername());
        assertEquals("password", u1.getPassword());

        u1.setUsername("user2");
        userDAO.updateUser(u1);

        User u2 = userDAO.getAllUsers().get(0);
        assertEquals("user2", u1.getUsername());
        assertEquals("password", u1.getPassword());

    }

    /**
     * Test of getUser method, of class UserDAO.
     */
    @Test
    @Ignore
    public void testGetUser_int() {
        System.out.println("getUser");

        int id = 1;
        User user = new User();
        user.setId(id);
        user.setUsername("user1");
        user.setPassword("password");
        userDAO.addUser(user);

        User user2 = userDAO.getUser(id);
        assertEquals(user, user2);
        System.out.println(user2.getId() + "-" + user2.getUsername());
    }

    /**
     * Test of getUser method, of class UserDAO.
     */
    @Test
    public void testGetUser_String() {
        System.out.println("getUser");

        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        userDAO.addUser(user);

        User user2 = userDAO.getUser("user1");
        assertNotNull(user2);
        assertEquals(user, user2);
        System.out.println(user2.getId() + "-" + user2.getUsername());
    }

    /**
     * Test of getUser method, of class UserDAO.
     */
    @Test
    public void testGetUser_String_Object() {
        System.out.println("getUser");

        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        userDAO.addUser(user);

        User user2 = userDAO.getUser("password", "password");
        assertNotNull(user2);
        assertEquals(user, user2);
        System.out.println(user2.getId() + "-" + user2.getUsername());
    }

    /**
     * Test of deleteUser method, of class UserDAO.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        userDAO.addUser(user);

        User user2 = userDAO.getUser("password", "password");
        assertNotNull(user2);
        assertEquals(user, user2);
        
        userDAO.deleteUser(user2);
        User user3 = userDAO.getUser("password", "password");
        assertNull(user3);
    }

    /**
     * Test of getAllUsers method, of class UserDAO.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        
        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("password");
        userDAO.addUser(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("password");
        userDAO.addUser(user2);
        
        List<User> list = userDAO.getAllUsers();
        
        assertEquals(2, list.size());
    }
}
