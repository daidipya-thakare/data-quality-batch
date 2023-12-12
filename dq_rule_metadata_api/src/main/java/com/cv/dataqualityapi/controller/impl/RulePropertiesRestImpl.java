package com.cv.dataqualityapi.controller.impl;

import com.cv.dataqualityapi.controller.RulePropertiesRest;
import com.cv.dataqualityapi.service.RulePropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RulePropertiesRestImpl implements RulePropertiesRest {

    @Autowired
    private RulePropertiesService rulePropertiesService;
}
