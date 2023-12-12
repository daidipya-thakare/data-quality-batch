package com.cv.dataqualityapi.service;

import com.cv.dataqualityapi.dto.EntityDetailsDto;
import com.cv.dataqualityapi.dto.EntityTemplateDto;

import java.util.List;

public interface EntityTemplateService {
    public List<EntityTemplateDto> getAllEntityTemplate();
}
