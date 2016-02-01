/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.entity;

import com.websystique.springmvc.model.UserDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author ksu
 */
@Entity
@Table(name = "users")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String username;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;
    
    @ManyToOne(cascade = { CascadeType.ALL })  
    private Hobby hobby;

    @ManyToMany
    @JoinTable(
      name="users_places",
      joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
      inverseJoinColumns={@JoinColumn(name="PLACE_ID", referencedColumnName="PLACE_ID")})
    private List<Place> places;
    
    public User() {
        
    }

    public User(long id, String username, String address, String email) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.email = email;
    }
    
    public User(String username, String address, String email) {
        this.username = username;
        this.address = address;
        this.email = email;
    }

    public User(UserDTO user) {
        this.username = user.getUsername();
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.id = user.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", address=" + address
                + ", email=" + email + "]";
    }

}
