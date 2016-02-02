package com.websystique.springmvc.service;

import com.websystique.springmvc.service.utils.GenericService;
import com.websystique.springmvc.entity.Hobby;
import com.websystique.springmvc.entity.Place;
import com.websystique.springmvc.model.HobbyDTO;
import com.websystique.springmvc.model.PlaceDTO;
import com.websystique.springmvc.model.UserDTO;
import java.util.List;

public interface UserService extends GenericService<UserDTO> {

    void deleteAll();

    HobbyDTO getHobby(UserDTO user);

    List<PlaceDTO> getPlaces(UserDTO user);
    
    void addHobby(HobbyDTO hobby, UserDTO user);
    
    void deleteHobby(HobbyDTO hobby, UserDTO user);
    
    void addPlace(PlaceDTO place, UserDTO user);
    
    void deletePlace(PlaceDTO place, UserDTO user);
    
    void addPlaces(List<PlaceDTO> places, UserDTO user);
    
    void deleteAllPlaces(UserDTO user);

}
