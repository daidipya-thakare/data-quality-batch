package com.cv.dataqualityapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entity_template_properties")

public class EntityTemplateProperties {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Entity Template Property  Id", example = "58664835", required = true)
    @Column(name = "entity_template_prop_id")
    private Integer entityTemplatePropId;

    @ApiModelProperty(notes = "entity_template_id")
    @Column(name = "entity_template_id")
    private Integer entityTemplateId;

    @ApiModelProperty(notes = "entity_template_prop_key", example = "PATH}")
    @Column(name = "entity_template_prop_key")
    private String entityTemplatePropKey;

    @ApiModelProperty(notes = "entity_template_prop_desc", example = "Location of the data file")
    @Column(name = "entity_template_prop_desc")
    private String entityTemplatePropDesc;

    @ApiModelProperty(notes = "entity_template_prop_type", example = "VARIABLE")
    @Column(name = "entity_template_prop_type")
    private String entityTemplatePropType;

    @ApiModelProperty(notes = "is_mandatory", example = "True")
    @Column(name = "is_mandatory")
    private String isMandatory;

    @ApiModelProperty(notes = "created_by", example = "System")
    @Column(name = "created_by")
    private String entityTemplatePropCreatedBy;

    @ApiModelProperty(notes = "created_date", example = "2023-04-18 14:20:20.785")
    @Column(name = "created_date")
    private String entityTemplatePropCreatedDate;

    @ApiModelProperty(notes = "updated_by", example = "System")
    @Column(name = "updated_by")
    private String entityTemplatePropUpdatedBy;

    @ApiModelProperty(notes = "updated_date", example = "2023-04-18 14:20:20.785")
    @Column(name = "updated_date")
    private String entityTemplatePropUpdatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_template_id", insertable = false, updatable = false)
    @JsonBackReference
    private EntityTemplate entityTemp;

}