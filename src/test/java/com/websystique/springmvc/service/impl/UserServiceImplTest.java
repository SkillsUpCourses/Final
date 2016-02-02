/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.dao.UserDAO;
import com.websystique.springmvc.entity.User;
import com.websystique.springmvc.model.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author ksu
 */
public class UserServiceImplTest {

    private UserServiceImpl instance;
    private UserDTO user1;
    private UserDTO user2;
    private User user3;
    private static UserDAO dao;

    public UserServiceImplTest() {
    }

    @Before
    public void setUp() {
        dao = mock(UserDAO.class);
        instance = new UserServiceImpl();
        instance.setDao(dao);
        user1 = new UserDTO("Peter", "USA,CA", "peter@gmail.com");
        user2 = new UserDTO("Sherlok", "London", "she@yandex.ru");
        user3 = new User(1, "Oksana", "Ukraine", "dn100488ro;@gmail.com");
    }

    /**
     * Test of findAllUsers method, of class UserServiceImpl.
     */
    @Test
    public void testFindAllUsers() {
        System.out.println("findAllUsers");
        List<User> daoResult = new ArrayList<User>();
        daoResult.add(new User(user1));
        daoResult.add(new User(user2));
        when(dao.getAll()).thenReturn(daoResult);
        List<UserDTO> expResult = new ArrayList<UserDTO>();
        expResult.add(user1);
        expResult.add(user2);
        List<UserDTO> result = instance.findAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class UserServiceImpl.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        long id = 1L;
        when(dao.findById(id)).thenReturn(user3);
        UserDTO expResult = new UserDTO(user3);
        UserDTO result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveUser method, of class UserServiceImpl.
     */
    @Test
    public void testSaveUser() {
        System.out.println("saveUser");
        instance.save(user1);
        verify(dao).add(new User(user1));
    }

    /**
     * Test of updateUser method, of class UserServiceImpl.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        UserDTO user = new UserDTO("Peter Haden", "USA,CA,LA", "peter@gmail.com");
        instance.update(user);
        verify(dao).update(new User(user));
    }

    /**
     * Test of deleteUserById method, of class UserServiceImpl.
     */
    @Test
    public void testDeleteUserById() {
        System.out.println("deleteUserById");
        long id = 1L;
        instance.deleteById(id);
        verify(dao).deleteById(id);
    }

    /**
     * Test of isUserExist method, of class UserServiceImpl.
     */
    @Test
    public void testIsUserExist() {
        System.out.println("isUserExist");
        UserDTO user = new UserDTO(user3);
        when(dao.isExist(user3)).thenReturn(Boolean.FALSE);
        boolean expResult = false;
        boolean result = instance.isExist(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteAllUsers method, of class UserServiceImpl.
     */
    @Test
    public void testDeleteAllUsers() {
        System.out.println("deleteAllUsers");
        instance.deleteAll();
        verify(dao).deleteAll();
    }

}
