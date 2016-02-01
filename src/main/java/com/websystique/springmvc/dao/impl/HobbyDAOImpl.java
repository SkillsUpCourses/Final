/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao.impl;

import com.websystique.springmvc.dao.HobbyDAO;
import com.websystique.springmvc.entity.Hobby;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ksu
 */
@Repository("hobbyDao")
public class HobbyDAOImpl extends DAOTemplate<Hobby> implements HobbyDAO {

    @PersistenceContext
    private EntityManager em;

    public Hobby findById(long id) {
        return em.find(Hobby.class, id);
    }

    public void update(Hobby entity) {
        Hobby old = em.find(Hobby.class, entity.getHobbyId());
        old.setHobbyName(entity.getHobbyName());
    }

    public List<Hobby> getAll() {
        return em.createQuery("SELECT hobby FROM Hobby hobby").getResultList();
    }

}
