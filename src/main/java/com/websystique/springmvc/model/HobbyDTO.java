/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import com.websystique.springmvc.entity.Hobby;

/**
 *
 * @author Ksu
 */
public class HobbyDTO implements Model <Hobby> {

    private long hobbyId;
    private String hobbyName;

    public HobbyDTO() {
    }

    public HobbyDTO(long hobbyId, String hobbyName) {
        this.hobbyId = hobbyId;
        this.hobbyName = hobbyName;
    }

    public HobbyDTO(Hobby entity) {
        this.hobbyId = entity.getHobbyId();
        this.hobbyName = entity.getHobbyName();
    }

    public long getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(long hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }
    
    public Hobby getEntity() {
        return new Hobby(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.hobbyName != null ? this.hobbyName.hashCode() : 0);
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
        final HobbyDTO other = (HobbyDTO) obj;
        if ((this.hobbyName == null) ? (other.hobbyName != null) : !this.hobbyName.equals(other.hobbyName)) {
            return false;
        }
        return true;
    }
     
    
}
