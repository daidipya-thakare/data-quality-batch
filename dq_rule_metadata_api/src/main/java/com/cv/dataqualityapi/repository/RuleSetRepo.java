package com.cv.dataqualityapi.repository;

import com.cv.dataqualityapi.model.RuleSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RuleSetRepo extends JpaRepository<RuleSet,Integer> {

   Optional<RuleSet> findByRulesetname(String rulesetName);
}
