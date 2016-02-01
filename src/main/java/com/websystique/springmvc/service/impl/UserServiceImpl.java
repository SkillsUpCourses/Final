package com.websystique.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.UserDTO;
import com.websystique.springmvc.dao.UserDAO;
import com.websystique.springmvc.entity.User;
import com.websystique.springmvc.service.UserService;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    
    private static final AtomicLong counter = new AtomicLong();
	
       @Autowired
       UserDAO dao;
       
	public List<UserDTO> findAll() {
            List<UserDTO> result = new ArrayList<UserDTO>();
            List<User> entities = dao.getAll();
            UserDTO model = null;
            for (User entity: entities) {
                model = new UserDTO (entity);
                result.add(model);
            }
		return result;
	}
	
	public UserDTO findById(long id) {
	    return new UserDTO (dao.findById(id));
	}
	
	
	public long save(UserDTO user) {
            //Long id = counter.incrementAndGet();
            User entity = new User(user);
            //entity.setId(id);
	    dao.add(entity);
            //return id;
            return 1;
	}

	public void update(UserDTO user) {
            dao.update(new User(user));
		
	}

	public void deleteById(long id) {
	     dao.deleteById(id);
	}

	public boolean isExist(UserDTO user) {
		return dao.isExist(new User(user));
	}
	
	public void deleteAll(){
		dao.deleteAll();
	}

}
