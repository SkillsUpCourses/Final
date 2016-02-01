/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.service.impl;

import com.websystique.springmvc.dao.HobbyDAO;
import com.websystique.springmvc.dao.PlaceDAO;
import com.websystique.springmvc.entity.Hobby;
import com.websystique.springmvc.entity.Place;
import com.websystique.springmvc.model.HobbyDTO;
import com.websystique.springmvc.model.PlaceDTO;
import com.websystique.springmvc.service.HobbyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ksu
 */
public class HobbyServiceImpl extends ServiceTemplate <HobbyDTO, Hobby,HobbyDAO> implements HobbyService {

}
