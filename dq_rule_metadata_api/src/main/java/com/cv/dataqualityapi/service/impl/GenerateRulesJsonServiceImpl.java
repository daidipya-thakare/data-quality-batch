package com.cv.dataqualityapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.cv.dataqualityapi.Repo.*;
import com.cv.dataqualityapi.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.exception.ResourceNotFoundException;
import com.cv.dataqualityapi.model.RuleSet;
import com.cv.dataqualityapi.service.GenerateRulesJsonService;

@Service
public class GenerateRulesJsonServiceImpl implements GenerateRulesJsonService {

	@Autowired
	private RuleSetRepo ruleSetRepository;

	@Autowired
	private RulesRepo ruleRepository;

	@Autowired
	private EntityPropertiesRepo entityPropertiesRepository;

	@Autowired
	private EntityRepo entityRepository;

	@Autowired
	private EntityTemplatePropertiesRepo entityTemplatePropertiesRepository;

	@Autowired
	private EntityTemplateRepo entityTemplateRepository;

	@Autowired
	private RuleEntityMapRepo ruleEntityMapRepository;

	@Autowired
	private RulePropertiesRepo rulePropertiesRepository;

	@Autowired
	private RuleTemplatePropertiesRepo ruleTemplatePropertiesRepository;

	@Autowired
	private RuleTemplateRepo ruleTemplateRepository;

	@Override
	public JsonResponseDto generateRulesJson(String rulesetName) {

		Optional<RuleSet> ruleSetOp = ruleSetRepository.findByRulesetname(rulesetName);
		if (! ruleSetOp.isPresent()) {
			throw new ResourceNotFoundException("rule set not found");
		}

		JsonResponseDto jsonResponse = new JsonResponseDto();
		List<RulesJsonDto> rulesJsonDtolist = new ArrayList<>();

		RuleSet ruleset = ruleSetOp.get();
		AtomicInteger seq = new AtomicInteger(0);

		ruleset.getRules().stream().forEach(rule -> {

			List<DataEntityAssociations> dataEntityAssociationsList = new ArrayList<>();
			rule.getRuleEntityMap().stream().forEach(ruleMap -> {

				List<EntityPropertiesDto> entityPropList = new ArrayList<>();
				ruleMap.getEntities().getEntityProp().stream().forEach(entityPro ->
				{
					EntityPropertiesDto entityPropListDto = new EntityPropertiesDto();
					entityPropListDto.setKey(entityPro.getEntityPropKey());
					entityPropListDto.setValue(entityPro.getEntityPropValue());
					entityPropList.add(entityPropListDto);
				});

				List<EntityTemplatePropertiesDto> entityTemplatePropList = new ArrayList<>();
				ruleMap.getEntities().getEntityTemp().getEntityTemProp().stream().forEach(entityTemplateProp ->
				{
					EntityTemplatePropertiesDto entityTemplatePropListDto = new EntityTemplatePropertiesDto();
					entityTemplatePropListDto.setEntityTemplatePropDesc(entityTemplateProp.getEntityTemplatePropDesc());
					entityTemplatePropListDto.setEntityTemplatePropKey(entityTemplateProp.getEntityTemplatePropKey());
					entityTemplatePropListDto.setIsMandatory(entityTemplateProp.getIsMandatory());

					entityTemplatePropList.add(entityTemplatePropListDto);
				});

				DataEntityAssociations entityAssociationsDto = new DataEntityAssociations();
				entityAssociationsDto.setEntity_id(ruleMap.getEntities().getEntityId());
				entityAssociationsDto.setEntity_type(ruleMap.getEntities().getEntityTemp().getEntityTemplateType());
				entityAssociationsDto.setEntity_behaviour(ruleMap.getRuleEntityMapEntityBehaviour());
				entityAssociationsDto.setEntity_sub_type(ruleMap.getEntities().getEntityTemp().getEntityTemplateSubtype());
				entityAssociationsDto.setEntity_name(ruleMap.getEntities().getEntityName());
				entityAssociationsDto.setEntity_physical_name(ruleMap.getEntities().getEntityPhysicalName());
				entityAssociationsDto.setPrimary_key(ruleMap.getEntities().getEntityPrimaryKey());
				entityAssociationsDto.setIs_primary("TRUE");
				entityAssociationsDto.setProperties(entityPropList);
				entityAssociationsDto.setEntity_properties(entityTemplatePropList);

				dataEntityAssociationsList.add(entityAssociationsDto);
			});

			List<PropertiesDto> propertyDtoList = new ArrayList<>();
			rule.getRulesProp().stream().forEach(prop -> {
				PropertiesDto propDto = new PropertiesDto();
				propDto.setKey(prop.getRulePropertiesKey());
				propDto.setValue(prop.getRulePropertiesValue());
				propDto.setType("VARIABLE");
				propertyDtoList.add(propDto);
			});


			List<RuleTemplateDetailsDTO> ruleTemplateDetailsDtolist = new ArrayList<>();

			List<RuleTemplatePropertiesDTO> ruleTempPropDtoList = new ArrayList<>();
			rule.getRuleTemp().getRuleTempProp().stream().forEach(temp -> {
				RuleTemplatePropertiesDTO ruleTempPropDto = new RuleTemplatePropertiesDTO();
				ruleTempPropDto.setMandatory(temp.getRuleTemplatePropertiesIsMandatory());
				ruleTempPropDto.setDescription(temp.getRuleTemplatePropertiesDesc());
				ruleTempPropDto.setType(temp.getRuleTemplatePropertiesType());
				ruleTempPropDto.setKey(temp.getRuleTemplatePropertiesKey());
				ruleTempPropDtoList.add(ruleTempPropDto);
			});
			RuleTemplateDetailsDTO ruleTemplateDetailsDto = new RuleTemplateDetailsDTO();
			ruleTemplateDetailsDto.setId(rule.getRuleTemplateId());
			ruleTemplateDetailsDto.setName(rule.getRuleTemp().getRuleTemplateName());
			ruleTemplateDetailsDto.setDescription(rule.getRuleTemp().getRuleTemplateDesc());
			ruleTemplateDetailsDto.setTemplateProperties(ruleTempPropDtoList);

			RuleDetailsDto ruleDetailsDto = new RuleDetailsDto();
			ruleDetailsDto.setId(rule.getRuleId());
			ruleDetailsDto.setName(rule.getRuleName());
			ruleDetailsDto.setDescription(rule.getRuleDesc());
		    ruleDetailsDto.setDq_metric(rule.getRuleTemp().getRuleTemplateDqMetric());
			ruleDetailsDto.setData_entity_associations(dataEntityAssociationsList);
			ruleDetailsDto.setProperties(propertyDtoList);
			ruleDetailsDto.setTemplate(ruleTemplateDetailsDto);

			RulesJsonDto rulesJsonDto = new RulesJsonDto();
			rulesJsonDto.setSequence(seq.incrementAndGet());
			rulesJsonDto.setStatus("ACTIVE");
			rulesJsonDto.setRuleDetails(ruleDetailsDto);
			rulesJsonDtolist.add(rulesJsonDto);

		});

		List<String> notificationPreferences = new ArrayList<>();
		notificationPreferences.add("EMAIL");

		jsonResponse.setRuleset_id(ruleset.getRulesetid1());
		jsonResponse.setRuleset_name(ruleset.getRulesetname());
		jsonResponse.setRuleset_desc(ruleset.getRulesetdesc());
		jsonResponse.setNotification_preference(notificationPreferences);
		jsonResponse.setRules(rulesJsonDtolist);

		return jsonResponse;
	}

}