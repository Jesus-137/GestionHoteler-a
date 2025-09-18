package com.hotelera.reserva.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class Reserva {

	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "HUESPED_ID", nullable= false)
	private Long idHuesped;
	
	@Column(name= "habitacion_id", nullable= false)
	private Long idHabitacion;
	
	@Column(name= "fecha_entrada", nullable=false)
	private Date fechaEntrada;
	
	@Column(name= "fecha_salida", nullable=false)
	private Date fecheSalida;
	
	@Column(name = "noches", nullable=false)
	private Integer noches;
	
	@Column(name = "total", nullable=false)
	private Double total;
	
	@Column(name = "estado", nullable = false)
	private String estado;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getIdHuesped() {
		return idHuesped;
	}

	public void setIdHuesped(Long idHuesped) {
		this.idHuesped = idHuesped;
	}

	public Long getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(Long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFecheSalida() {
		return fecheSalida;
	}

	public void setFecheSalida(Date fecheSalida) {
		this.fecheSalida = fecheSalida;
	}

	public Integer getNoches() {
		return noches;
	}

	public void setNoches(Integer noches) {
		this.noches = noches;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
