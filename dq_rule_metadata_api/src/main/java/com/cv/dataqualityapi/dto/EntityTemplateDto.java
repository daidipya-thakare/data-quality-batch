package com.cv.dataqualityapi.dto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EntityTemplateDto {

    private String entityTemplateType;
    private Integer entityTemplateId;
    private String entityTemplateSubType;
    private List<EntityTemplatePropertiesDto> entityTemplateProperties;

}
