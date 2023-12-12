package com.cv.dataqualityapi.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cv.dataqualityapi.dto.JsonResponseDto;
import com.cv.dataqualityapi.controller.GenerateRulesJsonRest;
import com.cv.dataqualityapi.service.GenerateRulesJsonService;

@RestController
public class GenerateRulesJsonRestImpl implements GenerateRulesJsonRest{
	
	@Autowired
	private GenerateRulesJsonService ruleService;

	@Override
	public JsonResponseDto generateRulesJson(String ruleSetName) {

		return ruleService.generateRulesJson(ruleSetName);
	}
}
