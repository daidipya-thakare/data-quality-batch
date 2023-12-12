package com.cv.dataqualityapi.controller;
import com.cv.dataqualityapi.dto.EntityDetailsDto;
import com.cv.dataqualityapi.dto.JsonResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/entity")
public interface EntitiesRest {

    @GetMapping(path = "/all")
    List<EntityDetailsDto> getAllEntities();

}
