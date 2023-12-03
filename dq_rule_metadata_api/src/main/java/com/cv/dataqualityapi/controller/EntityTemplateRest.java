package com.cv.dataqualityapi.controller;

import com.cv.dataqualityapi.dto.EntityTemplateDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/entity_template")
public interface EntityTemplateRest {

    @GetMapping(path = "/all")
    List<EntityTemplateDto> getAllEntityTemplates();
}
