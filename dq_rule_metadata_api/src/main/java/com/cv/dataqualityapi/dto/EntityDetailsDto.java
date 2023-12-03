package com.cv.dataqualityapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityDetailsDto {

	private String type;
	private String subType;
	private String entityName;
	private String entityPhysicalName;
	private String primaryKey;

}
