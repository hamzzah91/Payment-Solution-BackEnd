package com.omnia.pie.cm.data.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Converter(autoApply = false)
public class LocalDateTimeToDateAttributeConverter implements AttributeConverter<LocalDateTime, Date> {
	
    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
    	Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    	return date;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
    	LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    	return localDateTime;
    }
}