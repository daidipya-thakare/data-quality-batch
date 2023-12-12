package com.cv.dataqualityapi.model;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rule_template")
public class RuleTemplate {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "rule_template_id", example = "28946357", required = true)
    @Column(name = "rule_template_id",nullable = false)
    private Integer ruleTemplateId;

    @ApiModelProperty(notes = "dq_metric", example = "VALIDITY", required = true)
    @Column(name = "dq_metric",nullable = false)
    private String ruleTemplateDqMetric;

    @ApiModelProperty(notes = "rule_template_name", example = "SQL_VALIDATOR", required = true)
    @Column(name = "rule_template_name",nullable = false)
    private String ruleTemplateName;

    @ApiModelProperty(notes = "rule_template_desc", example = "Apply sql rule for accuracy metric", required = true)
    @Column(name = "rule_template_desc",nullable = false)
    private String ruleTemplateDesc;

    @ApiModelProperty(notes = "created_by", example = "System")
    @Column(name = "created_by")
    private String ruleTemplateCreatedBy;

    @ApiModelProperty(notes = "updated_by", example = "System")
    @Column(name = "updated_by")
    private String ruleTemplateUpdatedBy;

    @ApiModelProperty(notes = "created_date",  example = "2023-04-18 14:20:20.785")
    @Column(name = "created_date")
    private String ruleTemplateCreatedDate;

    @ApiModelProperty(notes = "updated_date",  example = "2023-04-18 14:20:20.785")
    @Column(name = "updated_date")
    private String ruleTemplateUpdatedDate;

    @OneToMany(mappedBy = "ruleTemp", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<RuleTemplateProperties> ruleTempProp;

    @OneToMany(mappedBy = "ruleTemp", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Rules> rules;
}
