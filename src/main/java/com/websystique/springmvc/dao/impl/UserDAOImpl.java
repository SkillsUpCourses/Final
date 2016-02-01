/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao.impl;

import com.websystique.springmvc.dao.UserDAO;
import com.websystique.springmvc.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ksu
 */

@Repository("userDao")
public class UserDAOImpl implements UserDAO {
    
    @PersistenceContext
    private EntityManager em;

    public User findById(long id) {
        return em.find(User.class, id);
    }


    public void add(User user) {
        em.persist(user);
        System.err.println(user.getId());
    }

    public void update(User user) {
        User old = em.find(User.class, user.getId());
        old.setUsername(user.getUsername());
        old.setAddress(user.getAddress());
        old.setEmail(user.getEmail());
    }

    public void deleteById(long id) {
        em.remove(this.findById(id));
    }

    public List<User> getAll() {
        return em.createQuery("SELECT user FROM User user").getResultList();
    }

    public void deleteAll() {
        em.clear();
    }

    public boolean isExist(User user) {
        return em.contains(user);
    }
    
}
