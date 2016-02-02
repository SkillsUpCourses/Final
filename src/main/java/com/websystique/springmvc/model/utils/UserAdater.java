/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model.utils;

import com.websystique.springmvc.entity.User;
import com.websystique.springmvc.model.UserDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author ksu
 */

@Component
public class UserAdater  {
    
    public User getEntity (UserDTO model){
        User entity = new User();
        entity.setUsername(model.getUsername());
        entity.setAddress(model.getAddress());
        entity.setEmail(model.getEmail() );
        entity.setId(model.getId());
        return entity;
    }
    
    public UserDTO getModel (User entity){
        UserDTO model = new UserDTO();
        model.setUsername(entity.getUsername());
        model.setAddress(entity.getAddress());
        model.setEmail(entity.getEmail() );
        model.setId(entity.getId());
        return model;
    }
}
