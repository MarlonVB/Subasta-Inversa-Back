package com.examcomplexivo.subastainversaservices.models;

//import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@XmlRootElement
@Table(name = "oferta")
public class Oferta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta")
    private Long idOferta;
    @Column(name = "percio_oferta")
    private Double percioOferta;

    @Column(name = "fecha_oferta")
    private Date fecha;
    @Column(name = "descripcion_oferta")
    private String descripcion_oferta;
    @Column(name = "estado_oferta")
    private boolean estado;

    @ManyToOne()
    @JoinColumn(referencedColumnName="id_proveedor", nullable = false, unique = true)
    private Proveedor proveedor;


    @ManyToOne()
    @JoinColumn(referencedColumnName="id_subasta", nullable = false)
    private Subasta subasta;


	public Long getIdOferta() {
		return idOferta;
	}


	public void setIdOferta(Long idOferta) {
		this.idOferta = idOferta;
	}


	public Double getPercioOferta() {
		return percioOferta;
	}


	public void setPercioOferta(Double percioOferta) {
		this.percioOferta = percioOferta;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getDescripcion_oferta() {
		return descripcion_oferta;
	}


	public void setDescripcion_oferta(String descripcion_oferta) {
		this.descripcion_oferta = descripcion_oferta;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public Subasta getSubasta() {
		return subasta;
	}


	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}
    
    
}
