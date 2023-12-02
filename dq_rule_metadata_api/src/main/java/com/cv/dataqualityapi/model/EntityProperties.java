package com.cv.dataqualityapi.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entity_properties")
public class EntityProperties {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Entity Id", example = "68337369", required = true)
	@Column(name = "entity_prop_id")
	private Integer entityPropId;

	@ApiModelProperty(notes = "entity_prop_key", example = "PATH")
	@Column(name = "entity_prop_key")
	private String entityPropKey;

	@ApiModelProperty(notes = "entity_prop_value", example = "data/payments/payment_source.csv")
	@Column(name = "entity_prop_value")
	private String entityPropValue;

	@ApiModelProperty(notes = "Entity Id", example = "89919999", required = true)
	@Column(name = "entity_id")
	private Integer EntityId;

	@ApiModelProperty(notes = "created_by", example = "System")
	@Column(name = "created_by")
	private String entityPropCreatedBy;

	@ApiModelProperty(notes = "updated_by", example = "System")
	@Column(name = "updated_by")
	private String entityPropUpdatedBy;

	@ApiModelProperty(notes = "created_date", example = "2023-02-11 11:25:04")
	@Column(name = "created_date")
	private String entityPropCreatedDate;

	@ApiModelProperty(notes = "updated_date", example = "2023-02-11 11:25:04")
	@Column(name = "updated_date")
	private String entityPropUpdatedDate;

	@ManyToOne()
	@JoinColumn(name = "entity_id", insertable = false, updatable = false)
	private Entities entities;

}