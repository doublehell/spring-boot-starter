package com.demo.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.demo.entity.property.ProgramLanguageType;

@Converter
final public class ProgramLanguageConverter implements AttributeConverter<ProgramLanguageType, String> {

	@Override
	public String convertToDatabaseColumn(ProgramLanguageType attribute) {
		return attribute.name();
	}

	@Override
	public ProgramLanguageType convertToEntityAttribute(String dbData) {
		
		try {
			return ProgramLanguageType.valueOf(dbData.toUpperCase());
		} catch (Exception e) {
			// e.printStackTrace();
			// not found available ProgramLanguageType.
			return null;
		}
		
	}

}
