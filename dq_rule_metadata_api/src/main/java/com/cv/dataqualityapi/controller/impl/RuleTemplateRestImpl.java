package com.cv.dataqualityapi.controller.impl;

import com.cv.dataqualityapi.controller.RuleTemplateRest;
import com.cv.dataqualityapi.service.RuleTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleTemplateRestImpl implements RuleTemplateRest {

    @Autowired
    private RuleTemplateService ruleTemplateService;
}
