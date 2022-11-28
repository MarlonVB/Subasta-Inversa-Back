package com.examcomplexivo.subastainversaservices.models;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement
@Entity
@Table(name = "servicio")
@AllArgsConstructor
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private long idServicio;

    private String nombreServicio;

    private String descripcion_servicio;
    
    

    public long getIdServicio() {
		return idServicio;
	}



	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}



	public String getNombreServicio() {
		return nombreServicio;
	}



	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}



	public String getDescripcion_servicio() {
		return descripcion_servicio;
	}



	public void setDescripcion_servicio(String descripcion_servicio) {
		this.descripcion_servicio = descripcion_servicio;
	}



	public Servicio() {

    }
}
