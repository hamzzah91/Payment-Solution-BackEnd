package com.omnia.pie.cm.ui.converter;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

/**
 * @author M Louie
 *
 */

@FacesConverter(value = "localTimeConverter")
public class LocalTimeConverter extends DateTimeConverter {
	
	private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		LocalTime lTime = null;
	  	Date date = null;
	  	Object o = super.getAsObject(context, component, value);
	  	 if(o == null) {
			return null;
		}
	  	if (o instanceof Date) {
	  		date = (Date) o;
	  		Instant instant = Instant.ofEpochMilli(date.getTime());
	  		lTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
	  		return lTime;
	  	}
	  	else{
	  		throw new IllegalArgumentException(String.format("value=%s could not be converted to a LocalTime, result super.getAsObject=%s",value,o));
	  	}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return super.getAsString(context, component, value);
		}
		
	  	if (value instanceof LocalTime) {
	  		Instant instant = ((LocalTime)value).atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant();
	  		Date time = Date.from(instant);
	  		return formatter.format(time);
	  	}
	  	else if  (value instanceof Date) {
	  		return formatter.format(value);
	  	}else if  (value instanceof String) {
		  		return value.toString();	
	  	} else{
	  		throw new IllegalArgumentException(String.format("value=%s is not a instanceof LocalTime", value));
	  	}
	}	
}
