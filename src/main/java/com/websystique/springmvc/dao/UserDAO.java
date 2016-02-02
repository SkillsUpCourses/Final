/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import com.websystique.springmvc.dao.utils.GenericDAO;
import com.websystique.springmvc.entity.Hobby;
import com.websystique.springmvc.entity.Place;
import com.websystique.springmvc.entity.User;
import java.util.List;

/**
 *
 * @author ksu
 */
public interface UserDAO extends GenericDAO<User> {

    void deleteAll();

    Hobby getHobby(User user);
    
    void addHobby(Hobby hobby, User user);
    
    void deleteHobby(Hobby hobby, User user);

    List<Place> getPlaces(User user);
    
    void addPlace(Place place, User user);
    
    void deletePlace(Place place, User user);


}
