package com.omnia.pie.cm.ui.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.calendar.Calendar;

import com.sun.faces.util.MessageFactory;

/**
 * @author M Louie
 *
 */

public interface DateConverter extends Converter {

	/**
	 * Faces converter for support for LocalDate
	 */
	@FacesConverter(value = "xlocalDateTimeConverter")
	public static class XLocalDateTimeConverter implements Converter {
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			try {
				return LocalDateTime.parse(value, buildParser(component.getAttributes().getOrDefault("pattern", "").toString()));
			} catch (DateTimeParseException e) {
				throw new ConverterException(formatErrorMessage("Date/Time", context, component, value), e);
			}
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value instanceof String) {
				return (String) value;
			}
			LocalDateTime dateValue = (LocalDateTime) value;
			return primefacesSupport(component, dateValue.format(DateTimeFormatter
					.ofPattern(component.getAttributes().getOrDefault("pattern", "yyyy/MM/dd HH:mm:ss").toString())));
		}
	}

	@FacesConverter(value = "xlocalDateConverter")
	public static class XLocalDateConverter implements Converter {
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			try {
				return LocalDate.parse(value, buildParser(component.getAttributes().getOrDefault("pattern", "").toString()));
			} catch (DateTimeParseException e) {
				throw new ConverterException(formatErrorMessage("Date", context, component, value), e);
			}
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value instanceof String) {
				return (String) value;
			}
			LocalDate dateValue = (LocalDate) value;
			return primefacesSupport(component, dateValue.format(DateTimeFormatter
					.ofPattern(component.getAttributes().getOrDefault("pattern", "yyyy/MM/dd").toString())));
		}
	}

	@FacesConverter(value = "xlocalTimeConverter")
	public static class XLocalTimeConverter implements Converter {
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			try {
				return LocalTime.parse(value, buildParser(component.getAttributes().getOrDefault("pattern", "").toString()));
			} catch (DateTimeParseException e) {
				throw new ConverterException(formatErrorMessage("Time", context, component, value), e);
			}
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value instanceof String) {
				return (String) value;
			}
			LocalDateTime dateValue = (LocalDateTime) value;
			return primefacesSupport(component, dateValue.format(DateTimeFormatter.ofPattern(component.getAttributes().getOrDefault("pattern", "HH:mm:ss").toString())));
		}
	}
	
	static String primefacesSupport(UIComponent component, String val) {
		// PrimeFaces support
		if (component instanceof Calendar) {
			Calendar cal = (Calendar) component;
			cal.setValue(val);
		}
		return val;
	}

	static FacesMessage formatErrorMessage(String which, FacesContext context, UIComponent component, String value) {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, String.format("%s Conversion Failed: %s - %s", which,
				(String) MessageFactory.getLabel(context, component), value), "");
	}

	static DateTimeFormatter buildParser(String pattern) {
		DateTimeFormatterBuilder dtf = new DateTimeFormatterBuilder().parseLenient();
		dtf.appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		if (!pattern.isEmpty()) {
			dtf.appendOptional(DateTimeFormatter.ofPattern(pattern));
		}
		return dtf.toFormatter();
	}

}