package com.cv.dataqualityapi.controller.impl;

import com.cv.dataqualityapi.controller.RuleEntityMapRest;
import com.cv.dataqualityapi.service.RuleEntityMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleEntityMapRestImpl implements RuleEntityMapRest {

    @Autowired
    private RuleEntityMapService ruleEntityMapService;
}
