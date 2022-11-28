package com.examcomplexivo.subastainversaservices.models;



import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@XmlRootElement
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;

    @Column(unique = true)
    private String nombreUsuario;
    @Column(name = "contrasenia_usuario")
    private String contraseniaUsuario;
	public Long getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseniaUsuario() {
		return contraseniaUsuario;
	}
	public void setContraseniaUsuario(String contraseniaUsuario) {
		this.contraseniaUsuario = contraseniaUsuario;
	}
	@Override
	public String toString() {
		return "Usuario [usuario_id=" + usuario_id + ", nombreUsuario=" + nombreUsuario + ", contraseniaUsuario="
				+ contraseniaUsuario + "]";
	}
	public Usuario(Long usuario_id, String nombreUsuario, String contraseniaUsuario) {
		super();
		this.usuario_id = usuario_id;
		this.nombreUsuario = nombreUsuario;
		this.contraseniaUsuario = contraseniaUsuario;
	}
	public Usuario() {
		super();
	}
    
    
}
