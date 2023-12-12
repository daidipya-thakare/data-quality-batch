package com.cv.dataqualityapi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "entity_template")
public class EntityTemplate {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Entity Template Id", example = "37504759", required = true)
    @Column(name = "entity_template_id")
    private Integer entityTemplateId;

    @ApiModelProperty(notes = "entity template type", example = "FILE")
    @Column(name = "entity_template_type")
    private String entityTemplateType;

    @ApiModelProperty(notes = "entity template subtype", example = "CSV")
    @Column(name = "entity_template_subtype")
    private String entityTemplateSubtype;

    @ApiModelProperty(notes = "created by name", example = "System")
    @Column(name = "created_by")
    private String entityTemplateCreatedBy;

    @ApiModelProperty(notes = "updated by name", example = "System")
    @Column(name = "updated_by")
    private String entityTemplateUpdatedBy;

    @Column(name = "created_date")
    @ApiModelProperty(notes = "Entity template creation timestamp", example = "2023-04-18 14:20:20.785", required = false)
    @Temporal(TemporalType.DATE)
    private Date entityTemplateCreatedDate;

    @Column(name = "updated_date")
    @ApiModelProperty(notes = "Entity Update timestamp", example = "2023-04-18 14:20:20.785", required = false)
    @Temporal(TemporalType.DATE)
    private Date entityTemplateUpdatedDate;

    @OneToMany(mappedBy = "entityTemp", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<EntityTemplateProperties> entityTemProp;

    @OneToMany(mappedBy = "entityTemp", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Entities> entities;

}
