package com.cv.dataqualityapi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "rule")
public class Rules {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Rule ID", example = "68640425", required = true)
	@Column(name = "rule_id")
	private Integer ruleId;

	@Column(name = "ruleset_id")
	@ApiModelProperty(notes = "ruleset_id",example = "68640425")
	private Integer ruleSetId;

	@Column(name = "rule_template_id")
	@ApiModelProperty(notes = "rule_template_id" ,example = "59221370")
	private Integer ruleTemplateId;

	// newly added
	@Column(name = "rule_desc", nullable = false)
	@ApiModelProperty(notes = "Rule Description", example = "Bank code is not among BARC and HSBC", required = false)
	private String ruleDesc;

	@Column(name = "rule_name", nullable = false)
	@ApiModelProperty(notes = "Rule Name", example = "account.accountNumber.LENGTH_CHECK", required = false)
	private String ruleName;

	@Column(name = "created_date")
	@ApiModelProperty(notes = "Rule creation timestamp", example = "2023-04-18 14:20:20.785", required = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "updated_date")
	@ApiModelProperty(notes = "Rule update timestamp", example = "2023-04-18 14:20:20.785", required = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Column(name = "created_by")
	@ApiModelProperty(notes = "Created by name", example = "System", required = false)
	private String createdBy;

	@Column(name = "updated_by")
	@ApiModelProperty(notes = "Updated by name", example = "System", required = false)
	private String updatedBy;

	@ManyToOne
	@MapsId("ruleset_id")
	@JoinColumn(name = "ruleset_id", insertable = false, updatable = false)
	private RuleSet ruleSet;

	@ManyToOne
	@MapsId("rule_template_id")
	@JoinColumn(name = "rule_template_id", insertable = false, updatable = false)
	private RuleTemplate ruleTemp;

	@OneToMany(mappedBy = "rules")
	private Set<RuleProperties> rulesProp;

	@OneToMany(mappedBy = "rules", cascade = CascadeType.ALL)
	private Set<RuleEntityMap> ruleEntityMap;

	public Rules(Integer ruleId) {
		super();
		this.ruleId = ruleId;
	}
}