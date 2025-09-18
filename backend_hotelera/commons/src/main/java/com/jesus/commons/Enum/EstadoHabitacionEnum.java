package com.jesus.commons.Enum;

public enum EstadoHabitacionEnum {
	DISPONIBLE,
	OCUPADA,
	LIMPIEZA,
	MANTENIMIENTO;

	public String getNombre() {
		switch (this) {
			case DISPONIBLE-> {
				return "Disponible";
			}
			case OCUPADA->{
				return "Ocupada";
			}
			case LIMPIEZA->{
				return "Limpieza";
			}
			case MANTENIMIENTO->{
				return "Mantenimiento";
			}
			default->{			
				throw new IllegalArgumentException("Unexpected value: " + this);
			}
		}
	}
}
