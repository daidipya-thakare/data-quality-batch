package com.cv.dataqualityapi.controller.impl;

import com.cv.dataqualityapi.controller.EntityTemplatePropertiesRest;
import com.cv.dataqualityapi.service.EntityTemplatePropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityTemplatePropertiesRestImpl implements EntityTemplatePropertiesRest {

    @Autowired
    private EntityTemplatePropertiesService entityTemplatePropertiesService;
}
