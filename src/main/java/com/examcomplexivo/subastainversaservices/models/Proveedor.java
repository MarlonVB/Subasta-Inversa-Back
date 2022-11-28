package com.examcomplexivo.subastainversaservices.models;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@XmlRootElement
@Table(name = "proveedor")
@PrimaryKeyJoinColumn(name = "id_proveedor", referencedColumnName = "id_persona")
public class Proveedor extends Persona {

    @Column(name = "anios_exp")
    private String anios_experiencia;

    @JoinColumn(name = "id_usuario", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "id_proveedor"),
    inverseJoinColumns = @JoinColumn(name = "id_servicio"))
    private List<Servicio> servicios = new ArrayList<>();

	public String getAnios_experiencia() {
		return anios_experiencia;
	}

	public void setAnios_experiencia(String anios_experiencia) {
		this.anios_experiencia = anios_experiencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
    
    
    

}
