package com.cv.dataqualityapi.controller.impl;

import com.cv.dataqualityapi.controller.EntityPropertiesRest;
import com.cv.dataqualityapi.service.EntityPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityPropertiesRestImpl implements EntityPropertiesRest {

    @Autowired
    private EntityPropertiesService entityPropertiesService;

}
