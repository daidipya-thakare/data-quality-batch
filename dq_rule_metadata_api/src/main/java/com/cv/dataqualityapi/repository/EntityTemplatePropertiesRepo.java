package com.cv.dataqualityapi.repository;

import com.cv.dataqualityapi.model.EntityTemplateProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityTemplatePropertiesRepo extends JpaRepository<EntityTemplateProperties,Integer>{

}
