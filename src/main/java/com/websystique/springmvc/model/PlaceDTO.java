/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import com.websystique.springmvc.model.utils.Model;
import com.websystique.springmvc.entity.Place;
import javax.persistence.Column;

/**
 *
 * @author ksu
 */
public class PlaceDTO implements Model<Place> {

    private long placeId;
    private String title;

    public PlaceDTO() {
    }

    public PlaceDTO(long placeId, String title) {
        this.placeId = placeId;
        this.title = title;
    }

    public PlaceDTO(Place entity) {
        this.placeId = entity.getPlaceId();
        this.title = entity.getTitle();
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

    public Place getEntity() {
        return new Place(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.title != null ? this.title.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlaceDTO other = (PlaceDTO) obj;
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        return true;
    }

}
