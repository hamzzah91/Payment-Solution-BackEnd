package com.omnia.pie.cm.ui.converter;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

@FacesConverter(value = "localDateConverter")
public class LocalDateConverter extends DateTimeConverter {
	
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		LocalDate ldate = null;
	  	Date date = null;
	  	Object o = super.getAsObject(context, component, value);
	  	 if(o == null) {
			return null;
		}
	  	if (o instanceof Date) {
	  		date = (Date) o;
	  		Instant instant = Instant.ofEpochMilli(date.getTime());
	  		ldate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	  		return ldate;
	  	}
	  	else{
	  		throw new IllegalArgumentException(String.format("value=%s could not be converted to a LocalDate, result super.getAsObject=%s",value,o));
	  	}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return super.getAsString(context, component, value);
		}
	  	if (value instanceof LocalDate) {
	  		LocalDate lDate = (LocalDate) value;
	  		Instant instant = lDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
	  		Date date = Date.from(instant);
	  		return formatter.format(date);
	  	}
	  	else{
	  		throw new IllegalArgumentException(String.format("value=%s is not a instanceof LocalDate", value));
	  	}
	}	
}
