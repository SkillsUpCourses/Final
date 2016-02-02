/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.entity;

import com.websystique.springmvc.entity.utils.EntityInterface;
import com.websystique.springmvc.model.PlaceDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Ksu
 */
@Entity
@Table(name = "places")
public class Place implements Serializable, EntityInterface<PlaceDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLACE_ID")
    private long placeId;

    @Column(name = "PLACE_TITLE", nullable = false, unique = true)
    private String title;

    @ManyToMany(mappedBy = "places")
    private List<User> users;

    public Place() {
    }

    public Place(long placeId, String title) {
        this.placeId = placeId;
        this.title = title;
    }

    public Place(PlaceDTO model) {
        this.placeId = model.getPlaceId();
        this.title = model.getTitle();
    }

    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public PlaceDTO getModel() {
        return new PlaceDTO(this);
    }
}
