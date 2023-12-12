package com.cv.dataqualityapi.repository;

import com.cv.dataqualityapi.model.RuleEntityMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleEntityMapRepo extends JpaRepository<RuleEntityMap,Integer> {

}
