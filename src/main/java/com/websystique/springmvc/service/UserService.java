package com.websystique.springmvc.service;

import java.util.List;


import com.websystique.springmvc.model.UserDTO;
import com.websystique.springmvc.service.utils.GenericService;



public interface UserService extends GenericService<UserDTO> {
	
	void deleteAll();

}
