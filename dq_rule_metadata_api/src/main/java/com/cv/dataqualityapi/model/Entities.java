package com.cv.dataqualityapi.model;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entity")
public class Entities {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "entity Id", example = "93733590", required = true)
	@Column(name = "entity_id",nullable = false)
	private Integer entityId;

	@ApiModelProperty(notes = "entity_physical_name", example = "data_quality_ds.Account")
	@Column(name = "entity_physical_name",nullable = false)
	private String entityPhysicalName;

	@ApiModelProperty(notes = "entity_name", example = "payment")
	@Column(name = "entity_name",nullable = false)
	private String entityName;

	@ApiModelProperty(notes = "entity_primary_key", example = "FILE")
	@Column(name = "entity_primary_key",nullable = false)
	private String entityPrimaryKey;

	@ApiModelProperty(notes = "entity_template_id", example = "37504759")
	@Column(name = "entity_template_id",nullable = false)
	private Integer entityTemplateId;

	@ApiModelProperty(notes = "created_by", example = "System")
	@Column(name = "created_by",nullable = false)
	private String createdBy;

	@ApiModelProperty(notes = "updated_by", example = "System")
	@Column(name = "updated_by",nullable = false)
	private String updatedBy;

	@ApiModelProperty(notes = "created_date", example = "2023-02-11 11:25:04")
	@Column(name = "created_date",nullable = false)
	private String createdDate;

	@ApiModelProperty(notes = "updated_date", example = "2023-02-11 11:25:04")
	@Column(name = "updated_date",nullable = false)
	private String updatedDate;

	@ManyToOne
	@MapsId("entity_template_id")
	@JoinColumn(name = "entity_template_id",insertable = false, updatable = false)
	private EntityTemplate entityTemp;

	@OneToMany(mappedBy = "entities"  , cascade = CascadeType.ALL)
	private Set<EntityProperties> entityProp;

	@OneToMany(mappedBy = "entities", cascade = CascadeType.ALL)
	private Set<RuleEntityMap> ruleEntityMap;
}