package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.dao.utils.GenericDAO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.UserDTO;
import com.websystique.springmvc.dao.UserDAO;
import com.websystique.springmvc.dao.impl.DAOTemplate;
import com.websystique.springmvc.entity.utils.EntityInterface;
import com.websystique.springmvc.entity.Hobby;
import com.websystique.springmvc.entity.Place;
import com.websystique.springmvc.entity.User;
import com.websystique.springmvc.model.HobbyDTO;
import com.websystique.springmvc.model.PlaceDTO;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import com.websystique.springmvc.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDAO dao;
    
    public List<UserDTO> findAll() {
        List<UserDTO> result = new ArrayList<UserDTO>();
        List<User> entities = dao.getAll();
        UserDTO model = null;
        for (User entity : entities) {
            model = new UserDTO(entity);
            result.add(model);
        }
        return result;
    }
    
    public UserDTO findById(long id) {
        return new UserDTO(dao.findById(id));
    }
    
    public void save(UserDTO user) {
        User entity = new User(user);
        dao.add(entity);
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
    
    public void deleteAll() {
        dao.deleteAll();
    }
    
    public HobbyDTO getHobby(UserDTO user) {
        Hobby hobby = dao.getHobby(new User(user));
        return new HobbyDTO(hobby);
    }
    
    public List<PlaceDTO> getPlaces(UserDTO user) {
        List<Place> entities = dao.getPlaces(new User(user));
        List<PlaceDTO> models = new ArrayList<PlaceDTO>();
        for (Place entity : entities) {
            models.add(new PlaceDTO(entity));
        }
        return models;
    }
    
    public UserDAO getDao() {
        return dao;
    }
    
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }
    
    public void addHobby(HobbyDTO hobby, UserDTO user) {
        User userEntity = new User(user);
        Hobby hobbyEntity = new Hobby(hobby);
        userEntity.setHobby(hobbyEntity);
        dao.addHobby(hobbyEntity, userEntity);
    }
    
    public void deleteHobby(HobbyDTO hobby, UserDTO user) {
        User userEntity = new User(user);
        Hobby hobbyEntity = new Hobby(hobby);
        userEntity.setHobby(null);
        dao.deleteHobby(hobbyEntity, userEntity);
    }
    
    public void addPlace(PlaceDTO place, UserDTO user) {
        User userEntity = new User(user);
        Place placeEntity = new Place(place);
        userEntity.getPlaces().add(placeEntity);
        placeEntity.getUsers().add(userEntity);
        dao.addPlace(placeEntity, userEntity);
    }
    
    public void addPlaces(List<PlaceDTO> places, UserDTO user) {
        for (PlaceDTO place : places) {
            addPlace(place, user);
        }
    }
    
    public void deletePlace(PlaceDTO place, UserDTO user) {
        User userEntity = new User(user);
        Place placeEntity = new Place(place);
        userEntity.getPlaces().remove(placeEntity);
        placeEntity.getUsers().remove(userEntity);
        dao.deletePlace(placeEntity, userEntity);
    }

    public void deleteAllPlaces(UserDTO user) {
        List <Place> places = dao.getPlaces(new User(user));
        for (Place place: places){
            deletePlace(new PlaceDTO(place), user);
        }
    }
    
}
