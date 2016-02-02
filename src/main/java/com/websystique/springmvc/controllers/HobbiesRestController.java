/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.controllers;

import com.websystique.springmvc.entity.Hobby;
import com.websystique.springmvc.model.HobbyDTO;
import com.websystique.springmvc.service.HobbyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author ksu
 */
public class HobbiesRestController {
    
    @Autowired
    HobbyService hobbyService;  //Service which will do all data retrieval/manipulation work

    //-------------------Retrieve All Hobbies--------------------------------------------------------
    @RequestMapping(value = "/hobby/", method = RequestMethod.GET)
    public ResponseEntity<List<Hobby>> listAllHobbies() {
        List<HobbyDTO> models = hobbyService.findAll();
        List<Hobby> entities = new ArrayList<Hobby>();
        Hobby entity = null;
        for (HobbyDTO model : models) {
            entity = new Hobby(model);
            entities.add(entity);
        }
        if (entities.isEmpty()) {
            return new ResponseEntity<List<Hobby>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Hobby>>(entities, HttpStatus.OK);
    }

    //-------------------Retrieve Single Hobby--------------------------------------------------------
    @RequestMapping(value = "/hobby/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hobby> getHobby(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        HobbyDTO model = hobbyService.findById(id);
        if (model == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Hobby>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Hobby>(new Hobby(model), HttpStatus.OK);
    }

    //-------------------Create a new Hobby--------------------------------------------------------
    @RequestMapping(value = "/hobby/", method = RequestMethod.POST)
    public ResponseEntity<Void> createHobby(@RequestBody Hobby hobby, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + hobby.getHobbyName());

        if (hobbyService.isExist(new HobbyDTO(hobby))) {
            System.out.println("A User with name " + hobby.getHobbyName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        hobbyService.save(new HobbyDTO(hobby));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/hobby/{id}").buildAndExpand(hobby.getHobbyId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Hobby --------------------------------------------------------
    @RequestMapping(value = "/hobby/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Hobby> updateHobby(@PathVariable("id") long id, @RequestBody Hobby hobby) {
        System.out.println("Updating hobby " + id);

        Hobby currentHobby = new Hobby(hobbyService.findById(id));

        if (currentHobby == null) {
            System.out.println("Hobby with id " + id + " not found");
            return new ResponseEntity<Hobby>(HttpStatus.NOT_FOUND);
        }

        currentHobby.setHobbyName(hobby.getHobbyName());

        hobbyService.update(new HobbyDTO(currentHobby));
        return new ResponseEntity<Hobby>(currentHobby, HttpStatus.OK);
    }

    //------------------- Delete a Hobby --------------------------------------------------------
    @RequestMapping(value = "/hobby/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Hobby> deleteHobby(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Hobby with id " + id);

        Hobby hobby = new Hobby(hobbyService.findById(id));
        if (hobby == null) {
            System.out.println("Unable to delete. Hobby with id " + id + " not found");
            return new ResponseEntity<Hobby>(HttpStatus.NOT_FOUND);
        }

        hobbyService.deleteById(id);
        return new ResponseEntity<Hobby>(HttpStatus.NO_CONTENT);
    }

}
