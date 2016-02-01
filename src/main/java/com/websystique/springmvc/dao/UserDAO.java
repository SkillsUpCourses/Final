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
public interface UserDAO {

    User findById(long id);

    void add(User user);

    void update(User user);

    void deleteById(long id);

    List<User> getAll();

    void deleteAllUsers();

    public boolean isExist(User user);
}
