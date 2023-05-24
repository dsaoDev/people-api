package com.dsaoDev.peopleAPI.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Genero {
	MASCULINO("masculino"),
	FEMININO("feminino");
	
	private String key;
	
	Genero(String key){
		this.key = key;
	}
	
	@JsonCreator
	public static Genero fromString(String key) {
		return key == null
				?null
				:Genero.valueOf(key.toUpperCase());
	}
	@JsonValue
	public String getKey() {
		return key;
	}
	
}
