package com.cv.dataqualityapi.repository;

import com.cv.dataqualityapi.model.EntityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntityPropertiesRepo extends JpaRepository <EntityProperties, Integer> {
    Optional<Object> findByEntityPropId(int id);
}
