package com.websystique.springmvc.service;

import java.util.List;


import com.websystique.springmvc.model.UserDTO;



public interface UserService {
	
	UserDTO findById(long id);
	
	long save(UserDTO user);
	
	void update(UserDTO user);
	
	void deleteById(long id);

	List<UserDTO> findAll(); 
	
	void deleteAll();
	
	public boolean isExist(UserDTO user);
	
}
