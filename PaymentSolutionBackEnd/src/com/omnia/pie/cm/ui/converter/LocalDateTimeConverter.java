package com.omnia.pie.cm.ui.converter;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

/**
 * @author M Louie
 *
 */

@FacesConverter(value = "localDateTimeConverter")
public class LocalDateTimeConverter extends DateTimeConverter {
	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		LocalDateTime ldate = null;
	  	Date date = null;
	  	Object o = super.getAsObject(context, component, value);
	  	 if(o == null) {
			return null;
		}
	  	if (o instanceof Date) {
	  		date = (Date) o;
	  		Instant instant = Instant.ofEpochMilli(date.getTime());
	  		ldate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	  		return ldate;
	  	}
	  	else{
	  		throw new IllegalArgumentException(String.format("value=%s could not be converted to a LocalDateTime, result super.getAsObject=%s",value,o));
	  	}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return super.getAsString(context, component, value);
		}
	  	if (value instanceof LocalDateTime) {
	  		LocalDateTime lDate = (LocalDateTime) value;
	  		ZonedDateTime zdt = lDate.atZone(ZoneId.systemDefault());
	  		Date date = Date.from(zdt.toInstant());
	  		return formatter.format(date);
	  	}else if (value instanceof Date) {
	  		return formatter.format(value);
	  	}
	  	else{
	  		throw new IllegalArgumentException(String.format("value=%s is not a instanceof LocalDateTime", value));
	  	}
	}	
}
