package com.examcomplexivo.subastainversaservices.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "personas")
@Data
@AllArgsConstructor
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @Column(unique = true)
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Column(unique = true)
    private String telefono;

    @NotBlank
    private String direccion;

    
    
    public Long getId_persona() {
		return id_persona;
	}



	public void setId_persona(Long id_persona) {
		this.id_persona = id_persona;
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



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public Persona() {
    }
}
