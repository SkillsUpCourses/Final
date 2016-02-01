/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao.impl;

import com.websystique.springmvc.dao.GenericDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ksu
 */
@Transactional
public abstract class DAOTemplate<T> implements GenericDAO<T> {

    @PersistenceContext
    private EntityManager em;

    public void add(T entity) {
        em.persist(entity);
    }

    public void deleteById(long id) {
        em.remove(this.findById(id));
    }

    public boolean isExist(T entity) {
        return em.contains(entity);
    }

    public abstract T findById(long id);

    public abstract void update(T entity);

    public abstract List<T> getAll();

}
