package com.cv.dataqualityapi.service.impl;

import com.cv.dataqualityapi.dto.EntityTemplateDto;
import com.cv.dataqualityapi.dto.EntityTemplatePropertiesDto;
import com.cv.dataqualityapi.model.EntityTemplateProperties;
import com.cv.dataqualityapi.repository.EntityTemplateRepo;
import com.cv.dataqualityapi.service.EntityTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import com.cv.dataqualityapi.model.EntityTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EntityTemplateServiceImpl implements EntityTemplateService {
    @Autowired
    private EntityTemplateRepo entityTemplateRepo;

    public EntityTemplate saveEntityTemplate(EntityTemplate entityTemplate){
        return entityTemplateRepo.save(entityTemplate);
    }

    public EntityTemplate saveAllEntityTemplate(List<EntityTemplate> entityTemplateList){
        return (EntityTemplate) entityTemplateRepo.saveAll(entityTemplateList);
    }

    public Optional<EntityTemplate> getEntityTemplateById(int id){
        return entityTemplateRepo.findById(id);
    }

    public List<EntityTemplateDto> getAllEntityTemplate(){
        List<EntityTemplateDto> entityTemplateList = new ArrayList<>();
        List<EntityTemplate> entityTemplates = entityTemplateRepo.findAll();

        entityTemplates.forEach(entityTemplate -> {
            EntityTemplateDto entityTemplateDto = new EntityTemplateDto();
            entityTemplateDto.setEntityTemplateType(entityTemplate.getEntityTemplateType());
            entityTemplateDto.setEntityTemplateId(entityTemplate.getEntityTemplateId());
            entityTemplateDto.setEntityTemplateSubType(entityTemplate.getEntityTemplateSubtype());

            Set<EntityTemplateProperties> entityTemplateProperties = entityTemplate.getEntityTemProp();

            if( !entityTemplateProperties.isEmpty()) {
                List<EntityTemplatePropertiesDto> entityTemplatePropertiesDtoList = new ArrayList<>();
                entityTemplateProperties.forEach(property -> {
                    EntityTemplatePropertiesDto entityTemplatePropertiesDto = new EntityTemplatePropertiesDto();
                    entityTemplatePropertiesDto.setEntityTemplatePropKey(property.getEntityTemplatePropKey());
                    entityTemplatePropertiesDto.setEntityTemplatePropDesc(property.getEntityTemplatePropDesc());
                    entityTemplatePropertiesDto.setIsMandatory(property.getIsMandatory());
                    entityTemplatePropertiesDto.setEntityTemplatePropType(property.getEntityTemplatePropType());
                    entityTemplatePropertiesDtoList.add(entityTemplatePropertiesDto);
                });
                entityTemplateDto.setEntityTemplateProperties(entityTemplatePropertiesDtoList);
            }
            entityTemplateList.add(entityTemplateDto);
        });

        return entityTemplateList;
    }

    public String deleteEntityTemplate(int id){
        entityTemplateRepo.deleteById(id);
        return "Entity Template Delete" + id ;
    }
}
