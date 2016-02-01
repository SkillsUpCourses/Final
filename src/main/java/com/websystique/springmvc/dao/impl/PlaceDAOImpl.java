/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao.impl;

import com.websystique.springmvc.dao.PlaceDAO;
import com.websystique.springmvc.entity.Place;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ksu
 */
@Repository("placeDao")
public class PlaceDAOImpl extends DAOTemplate<Place> implements PlaceDAO {

    @PersistenceContext
    private EntityManager em;

    public Place findById(long id) {
        return em.find(Place.class, id);
    }

    public void update(Place entity) {
        Place old = em.find(Place.class, entity.getPlaceId());
        old.setTitle(entity.getTitle());
    }

    public List<Place> getAll() {
        return em.createQuery("SELECT place FROM Place place").getResultList();
    }

}
