/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.service.utils;

import java.util.List;

/**
 *
 * @author ksu
 */
public interface GenericService<T> {

    T findById(long id);

    long save(T model);

    void update(T model);

    void deleteById(long id);

    List<T> findAll();

    public boolean isExist(T model);
    
}

