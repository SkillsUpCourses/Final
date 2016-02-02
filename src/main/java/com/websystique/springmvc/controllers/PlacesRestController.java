/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.controllers;

import com.websystique.springmvc.entity.Place;
import com.websystique.springmvc.model.PlaceDTO;
import com.websystique.springmvc.service.PlaceService;
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
public class PlacesRestController {

    @Autowired
    PlaceService placeService;  //Service which will do all data retrieval/manipulation work

    //-------------------Retrieve All Places--------------------------------------------------------
    @RequestMapping(value = "/place/", method = RequestMethod.GET)
    public ResponseEntity<List<Place>> listAllPlaces() {
        List<PlaceDTO> models = placeService.findAll();
        List<Place> entities = new ArrayList<Place>();
        Place entity = null;
        for (PlaceDTO model : models) {
            entity = new Place(model);
            entities.add(entity);
        }
        if (entities.isEmpty()) {
            return new ResponseEntity<List<Place>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Place>>(entities, HttpStatus.OK);
    }

    //-------------------Retrieve Single Place--------------------------------------------------------
    @RequestMapping(value = "/place/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Place> getPlace(@PathVariable("id") long id) {
        System.out.println("Fetching Place with id " + id);
        PlaceDTO model = placeService.findById(id);
        if (model == null) {
            System.out.println("Place with id " + id + " not found");
            return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Place>(new Place(model), HttpStatus.OK);
    }

    //-------------------Create a new Place--------------------------------------------------------
    @RequestMapping(value = "/place/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlace(@RequestBody Place place, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Place " + place.getTitle());

        if (placeService.isExist(new PlaceDTO(place))) {
            System.out.println("A User with name " + place.getTitle() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        placeService.save(new PlaceDTO(place));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/place/{id}").buildAndExpand(place.getPlaceId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Place --------------------------------------------------------
    @RequestMapping(value = "/place/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Place> updatePlace(@PathVariable("id") long id, @RequestBody Place place) {
        System.out.println("Updating place " + id);

        Place currentPlace = new Place(placeService.findById(id));

        if (currentPlace == null) {
            System.out.println("Place with id " + id + " not found");
            return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
        }

        currentPlace.setTitle(place.getTitle());

        placeService.update(new PlaceDTO(currentPlace));
        return new ResponseEntity<Place>(currentPlace, HttpStatus.OK);
    }

    //------------------- Delete a Place --------------------------------------------------------
    @RequestMapping(value = "/place/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Place> deletePlace(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Place with id " + id);

        Place place = new Place(placeService.findById(id));
        if (place == null) {
            System.out.println("Unable to delete. Place with id " + id + " not found");
            return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
        }

        placeService.deleteById(id);
        return new ResponseEntity<Place>(HttpStatus.NO_CONTENT);
    }

}
