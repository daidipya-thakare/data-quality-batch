package com.cv.dataqualityapi.Repo;

import com.cv.dataqualityapi.model.Entities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntityRepo extends JpaRepository<Entities,Integer> {


    Optional<Entities> findByEntityId(Integer EntityId);

    Optional<Object> findByEntityName(String name);


}
