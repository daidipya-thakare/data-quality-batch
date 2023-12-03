package com.cv.dataqualityapi.controller.impl;

import com.cv.dataqualityapi.controller.EntitiesRest;
import com.cv.dataqualityapi.dto.EntityDetailsDto;
import com.cv.dataqualityapi.dto.JsonResponseDto;
import com.cv.dataqualityapi.service.EntitiesService;
import com.cv.dataqualityapi.service.GenerateRulesJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntitiesRestImpl implements EntitiesRest {

    @Autowired
    private EntitiesService entitiesService;

    @Override
    public List<EntityDetailsDto> getAllEntities() {
       return entitiesService.getEntities();
    }
}
