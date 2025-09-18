package com.jesus.commons.Enum;

public enum DocumentoEnum {

	INE,
	PASAPORTE;
	
	public String getNombre() {
		switch(this) {
			case INE->{
				return "Ine";
			}
			case PASAPORTE->{
				return "Pasaporte";
			}
			default->{
				throw new IllegalArgumentException("Unexpected value: " + this);
			}
		}
	}
}
