package com.cv.dataqualityapi.controller.impl;

import com.cv.dataqualityapi.controller.RulesRest;
import com.cv.dataqualityapi.service.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RulesRestImpl implements RulesRest {

    @Autowired
    private RulesService rulesService;
}
