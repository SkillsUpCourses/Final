/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.dao.PlaceDAO;
import com.websystique.springmvc.entity.Place;
import com.websystique.springmvc.model.PlaceDTO;
import com.websystique.springmvc.service.PlaceService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ksu
 */
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDAO dao;

    public List<PlaceDTO> findAll() {
        List<PlaceDTO> result = new ArrayList<PlaceDTO>();
        List<Place> entities = dao.getAll();
        PlaceDTO model = null;
        for (Place entity : entities) {
            model = new PlaceDTO(entity);
            result.add(model);
        }
        return result;
    }

    public PlaceDTO findById(long id) {
        return new PlaceDTO(dao.findById(id));
    }

    public void save(PlaceDTO model) {
        Place entity = new Place(model);
        dao.add(entity);
    }

    public void update(PlaceDTO model) {
        dao.update(new Place(model));

    }

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    public boolean isExist(PlaceDTO model) {
        return dao.isExist(new Place(model));
    }
}
