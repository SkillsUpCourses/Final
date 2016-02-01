/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.entity;

import com.websystique.springmvc.model.HobbyDTO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ksu
 */

@Entity
@Table(name = "hobbies")
public class Hobby implements Serializable, EntityInterface<HobbyDTO> {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOBBY_ID")
    private long hobbyId;
    
    @Column(name = "HOBBY_NAME", nullable = false, unique = true)
    private String hobbyName;
    


    public Hobby() {
    }

    public Hobby(long hobbyId, String hobbyName) {
        this.hobbyId = hobbyId;
        this.hobbyName = hobbyName;
    }

    public Hobby(HobbyDTO model) {
        this.hobbyId = model.getHobbyId();
        this.hobbyName = model.getHobbyName();
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
    
    public HobbyDTO getModel() {
        return new HobbyDTO(this);
    }
    
}
