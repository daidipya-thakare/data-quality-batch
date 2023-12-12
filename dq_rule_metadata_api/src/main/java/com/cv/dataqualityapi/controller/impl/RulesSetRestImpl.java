package com.cv.dataqualityapi.controller.impl;

import com.cv.dataqualityapi.controller.RulesSetRest;
import org.springframework.beans.factory.annotation.Autowired;
import com.cv.dataqualityapi.service.RulesSetService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RulesSetRestImpl implements RulesSetRest {

    @Autowired
    private RulesSetService rulesSetService;

}
