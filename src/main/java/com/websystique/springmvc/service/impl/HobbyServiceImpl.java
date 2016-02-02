/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.dao.HobbyDAO;
import com.websystique.springmvc.dao.PlaceDAO;
import com.websystique.springmvc.entity.Hobby;
import com.websystique.springmvc.entity.Place;
import com.websystique.springmvc.model.HobbyDTO;
import com.websystique.springmvc.model.PlaceDTO;
import com.websystique.springmvc.service.HobbyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ksu
 */
@Service
public class HobbyServiceImpl implements HobbyService {

    @Autowired
    private HobbyDAO dao;

    public List<HobbyDTO> findAll() {
        List<HobbyDTO> result = new ArrayList<HobbyDTO>();
        List<Hobby> entities = dao.getAll();
        HobbyDTO model = null;
        for (Hobby entity : entities) {
            model = new HobbyDTO(entity);
            result.add(model);
        }
        return result;
    }

    public HobbyDTO findById(long id) {
        return new HobbyDTO(dao.findById(id));
    }

    public void save(HobbyDTO model) {
        Hobby entity = new Hobby(model);
        dao.add(entity);
    }

    public void update(HobbyDTO model) {
        dao.update(new Hobby(model));

    }

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    public boolean isExist(HobbyDTO model) {
        return dao.isExist(new Hobby(model));
    }

}
