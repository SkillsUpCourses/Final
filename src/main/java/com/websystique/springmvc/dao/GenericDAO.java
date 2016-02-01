/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import com.websystique.springmvc.entity.User;
import java.util.List;

/**
 *
 * @author ksu
 */
public interface GenericDAO <T> {
    
    T findById(long id);

    void add(T entity);

    void update(T entity);

    void deleteById(long id);

    List<T> getAll();
    
    boolean isExist(T entity);

}
