package com.cv.dataqualityapi.repository;

import com.cv.dataqualityapi.model.Rules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RulesRepo extends JpaRepository<Rules,Integer> {
        Optional<Rules> findByRuleName(String ruleName);

}

