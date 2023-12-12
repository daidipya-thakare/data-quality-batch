package com.cv.dataqualityapi.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Setter
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rule_properties")
public class RuleProperties {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "rule_prop_id", example = "1", required = true)
    @Column(name = "rule_prop_id",nullable = false)
    private Integer rulePropertiesId;

    @ApiModelProperty(notes = "rule_id", example = "71667655", required = true)
    @Column(name = "rule_id",nullable = false)
    private Integer rulePropertiesRuleId;

    @ApiModelProperty(notes = "rule_properties_key", example = "LOWER_LIMIT", required = true)
    @Column(name = "rule_prop_key",nullable = false)
    private String rulePropertiesKey;

    @ApiModelProperty(notes = "rule_properties_value", example = "60000", required = true)
    @Column(name = "rule_prop_value",nullable = false, length = 200)
    private String rulePropertiesValue;

    @ApiModelProperty(notes = "created_by", example = "System")
    @Column(name = "created_by")
    private String rulePropertiesCreatedBy;

    @ApiModelProperty(notes = "updated_by", example = "System")
    @Column(name = "updated_by")
    private String rulePropertiesUpdatedBy;

    @ApiModelProperty(notes = "created_date", example = "2023-04-18 14:20:20.785")
    @Column(name = "created_date")
    private String rulePropertiesCreatedDate;

    @ApiModelProperty(notes = "updated_date", example = "2023-04-18 14:20:20.785")
    @Column(name = "updated_date")
    private String rulePropertiesUpdatedDate;

    @ManyToOne
    @MapsId("rule_id")
    @JoinColumn(name = "rule_id", insertable = false, updatable = false)
    private Rules rules;
}
