/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao.impl;

import com.websystique.springmvc.dao.UserDAO;
import com.websystique.springmvc.entity.Hobby;
import com.websystique.springmvc.entity.Place;
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
public class UserDAOImpl extends DAOTemplate<User> implements UserDAO {
    

    @PersistenceContext
    private EntityManager em;

    public User findById(long id) {
        return em.find(User.class, id);
    }

    public void update(User user) {
        User old = em.find(User.class, user.getId());
        old.setUsername(user.getUsername());
        old.setAddress(user.getAddress());
        old.setEmail(user.getEmail());
    }

    public List<User> getAll() {
        return em.createQuery("SELECT user FROM User user").getResultList();
    }

    public void deleteAll() {
        em.clear();
    }

    public Hobby getHobby(User user) {
        return (Hobby) em.createNativeQuery("SELECT * FROM hobbies WHERE HOBBY_ID in"
                + "(SELECT HOBBY_ID FROM users WHERE USER_ID="
                + user.getId() + "))").getSingleResult();
    }

    public List<Place> getPlaces(User user) {
               return em.createNativeQuery("SELECT * FROM places WHERE PLACE_ID in"
                + "(SELECT PLACE_ID FROM users_places WHERE USER_ID="
                + user.getId() + "))").getResultList();
                       
    }

}
