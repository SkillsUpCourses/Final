/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.service.utils;

import com.websystique.springmvc.dao.utils.GenericDAO;
import com.websystique.springmvc.entity.utils.EntityInterface;
import com.websystique.springmvc.model.utils.Model;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ksu
 */
/**
 *
 * @author ksu
 * @param <M,E>
 */
public class ServiceTemplate<M extends Model<E>, E extends EntityInterface<M>, D extends GenericDAO<E>> implements GenericService<M> {

    @Autowired
    private D dao;

    public M findById(long id) {
        return dao.findById(id).getModel();
    }

    public long save(M model) {
        dao.add(model.getEntity());
        return 1;
    }

    public void update(M model) {
        dao.update(model.getEntity());
    }

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    public List<M> findAll() {
        List<M> result = new ArrayList<M>();
        List<E> entities = dao.getAll();
        for (E entity : entities) {
            result.add(entity.getModel());
        }
        return result;
    }

    public boolean isExist(M model) {
        return dao.isExist(model.getEntity());
    }

    public D getDao() {
        return dao;
    }
    
    
}

