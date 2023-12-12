package com.cv.dataqualityapi.service.impl;

import com.cv.dataqualityapi.dto.EntityDetailsDto;
import com.cv.dataqualityapi.repository.EntityRepo;
import com.cv.dataqualityapi.model.Entities;
import com.cv.dataqualityapi.service.EntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntitiesServiceImpl implements EntitiesService {
    @Autowired
    private EntityRepo entityRepo;

    public Entities saveEntities(List<Entities> entities){
        return (Entities) entityRepo.saveAll(entities);
    }

    public Entities saveEntity(Entities entities){
        return entityRepo.save(entities);
    }

    public List<EntityDetailsDto> getEntities(){

        List<Entities> entities = entityRepo.findAll();
        List<EntityDetailsDto> entityDetailsList = new ArrayList<>();
        entities.forEach(e ->{
            EntityDetailsDto entityDetailsDto = new EntityDetailsDto();
            entityDetailsDto.setEntityName(e.getEntityName());
            entityDetailsDto.setEntityPhysicalName(e.getEntityPhysicalName());
            entityDetailsDto.setSubType(e.getEntityTemp().getEntityTemplateSubtype());
            entityDetailsDto.setType(e.getEntityTemp().getEntityTemplateType());
            entityDetailsDto.setPrimaryKey(e.getEntityPrimaryKey());
            entityDetailsList.add(entityDetailsDto);

        });
        return entityDetailsList;
    }

    public Entities getEntityById(int id){
        return entityRepo.findByEntityId(id).orElse(null);
    }

    public Entities getEntityByName(String name){
        return (Entities) entityRepo.findByEntityName(name).orElse(null);
    }

}
