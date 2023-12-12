package com.cv.dataqualityapi.service;

import com.cv.dataqualityapi.dto.EntityDetailsDto;
import com.cv.dataqualityapi.model.Entities;

import java.util.List;

public interface EntitiesService {

    public List<EntityDetailsDto> getEntities();
}
