package com.cv.dataqualityapi.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rule_template_properties")
public class RuleTemplateProperties {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "rule_template_prop_id", example = "95430871", required = true)
    @Column(name = "rule_template_prop_id",nullable = false)
    private Integer ruleTemplatePropertiesId;

    @Column(name = "rule_template_id")
    @ApiModelProperty(notes = "rule_template_id")
    private Integer ruleTemplateId;

    @ApiModelProperty(notes = "rule_template_prop_key", example = "BASE_CRITERIA", required = true)
    @Column(name = "rule_template_prop_key",nullable = false)
    private String ruleTemplatePropertiesKey;

    @ApiModelProperty(notes = "rule_template_prop_type", example = "PREDEFINED", required = true)
    @Column(name = "rule_template_prop_type",nullable = false)
    private String ruleTemplatePropertiesType;

    @ApiModelProperty(notes = "rule_template_prop_value", example = "round({BASE_CRITERIA_COLUMN}) <> {BASE_CRITERIA_COLUMN}", required = true)
    @Column(name = "rule_template_prop_value",nullable = false)
    private String ruleTemplatePropertiesValue;

    @ApiModelProperty(notes = "rule_template_prop_desc", example = "Condition to be applied on the column", required = true)
    @Column(name = "rule_template_prop_desc",nullable = false)
    private String ruleTemplatePropertiesDesc;

    @ApiModelProperty(notes = "is_mandatory", example = "True")
    @Column(name = "is_mandatory")
    private String ruleTemplatePropertiesIsMandatory;

    @ApiModelProperty(notes = "created_by", example = "System")
    @Column(name = "created_by")
    private String ruleTemplatePropertiesCreatedBy;

    @ApiModelProperty(notes = "updated_by", example = "System")
    @Column(name = "updated_by")
    private String ruleTemplatePropertiesUpdatedBy;

    @ApiModelProperty(notes = "created_date", example = "2023-04-18 14:20:20.785")
    @Column(name = "created_date")
    private String ruleTemplatePropertiesCreatedDate;

    @ApiModelProperty(notes = "updated_date", example = "2023-04-18 14:20:20.785")
    @Column(name = "updated_date")
    private String ruleTemplatePropertiesUpdatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rule_template_id")
    @JoinColumn(name = "rule_template_id",insertable = false,updatable = false)
    private RuleTemplate ruleTemp;
}
