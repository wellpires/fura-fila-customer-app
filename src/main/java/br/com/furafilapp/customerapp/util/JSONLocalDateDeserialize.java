package br.com.furafilapp.customerapp.util;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JSONLocalDateDeserialize extends JsonDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
		return CustomerAppUtils.stringToLocalDate(jp.getValueAsString());
	}

}
