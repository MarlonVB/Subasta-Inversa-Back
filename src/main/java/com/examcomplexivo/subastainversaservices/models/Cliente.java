package com.examcomplexivo.subastainversaservices.models;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@Entity
@XmlRootElement
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id_cliente", referencedColumnName = "id_persona")
public class Cliente extends Persona{

    @JoinColumn(name = "usuario_id", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    
    
}
