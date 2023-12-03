package com.cv.dataqualityapi.repository;

import com.cv.dataqualityapi.model.RuleTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RuleTemplateRepo extends JpaRepository<RuleTemplate,Integer> {
    Optional<Object> findByRuleTemplateName(String Name);
}
