package com.omnia.pie.cm.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CustomObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -402324347362487410L;

	public CustomObjectMapper(){
		JavaTimeModule module = new JavaTimeModule();
		registerModule(module);
	}
}
