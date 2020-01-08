package com.demo.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
final public class BooleanConverter implements AttributeConverter<Boolean, String> {

	final private static String _FALSE = "N";
	final private static String _TRUE = "Y";
	
	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if(attribute == null) return _FALSE;//it is very important because maybe the column is can be null!!
		return attribute ? _TRUE : _FALSE;
		
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		if(dbData == null) return false;//it is very important because maybe the column is can be null!!
		return dbData.equalsIgnoreCase(_TRUE);
	}



}
