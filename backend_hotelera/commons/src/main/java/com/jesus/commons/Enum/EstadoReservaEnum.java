package com.jesus.commons.Enum;

public enum EstadoReservaEnum {
	CONFIRMADA,
	EN_CURSO,
	FINALIZADA,
	CANCELADA;

	public String getNombre(){
		switch (this) {
			case CONFIRMADA-> {
				return "Confirmada";
			}
			case EN_CURSO-> {
				return "En curso";
			}
			case FINALIZADA-> {
				return "Finalizada";
			}
			case CANCELADA-> {
				return "Cancelada";
			}
			default->{			
				throw new IllegalArgumentException("Unexpected value: " + this);
			}
		}
	}
}
