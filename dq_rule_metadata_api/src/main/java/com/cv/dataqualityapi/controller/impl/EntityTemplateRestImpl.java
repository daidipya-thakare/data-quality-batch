package com.cv.dataqualityapi.controller.impl;

import com.cv.dataqualityapi.controller.EntityTemplateRest;
import com.cv.dataqualityapi.dto.EntityTemplateDto;
import com.cv.dataqualityapi.service.EntityTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntityTemplateRestImpl implements EntityTemplateRest {

    @Autowired
    private EntityTemplateService entityTemplateService;

    @Override
    public List<EntityTemplateDto> getAllEntityTemplates() {
        return entityTemplateService.getAllEntityTemplate();
    }
}

