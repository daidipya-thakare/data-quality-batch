package com.cv.dataqualityapi.model;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ruleset")
public class RuleSet {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ruleset_id")
	private Integer rulesetid1;

	@Column(name = "ruleset_name", nullable = false)
	private String rulesetname;

	@Column(name = "ruleset_desc", nullable = false)
	private String rulesetdesc;

	@Column(name = "notification_email", nullable = false)
	private String ruleSetNotificationEmail;

	@Column(name = "created_by", nullable = false)
	private String ruleSetCreatedBy;

	@Column(name = "created_date", nullable = false)
	private String ruleSetCreatedDate;

	@Column(name = "updated_by", nullable = false)
	private String ruleSetUpdatedBy;

	@Column(name = "updated_date", nullable = false)
	private String ruleSetUpdatedDate;

	@OneToMany(mappedBy = "ruleSet",fetch = FetchType.LAZY)
	private Set<Rules> rules;
}

