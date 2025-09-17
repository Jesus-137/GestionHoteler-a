package com.example.huespedes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "HUESPEDES")
public class Huesped {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HUESPEDES_SEQ")
	@SequenceGenerator(name = "HUESPEDES_SEQ", sequenceName = "HUESPEDES_SEQ", allocationSize = 1)
	
	@Column(name = "ID")
	private Long id;
	@Column(name = "NOMBRE", nullable = false, length = 30)
	private String nombre;
	@Column(name = "APELLIDO", nullable = false, length = 30)
	private String apellido;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "TELEFONO")
	private String telefono;
	@Column(name = "DOCUMENTO")
	private String  documento;
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
	
}
