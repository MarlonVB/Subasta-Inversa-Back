package com.examcomplexivo.subastainversaservices.models;


//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@Entity
@XmlRootElement
@Table(name = "subasta")
public class Subasta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_subasta")
    private long idSubasta;

    @Column(name = "fecha_inicio_subasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin_subasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Column(name = "estado_subasta")
    private String estadoSubasta;

    @Column(name = "desc_subasta")
    private String descripcionSubasta;

    @Column(name = "img_subasta")
    private String imgSubasta;


    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente cliente;

    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne
    private Servicio servicio;

	public long getIdSubasta() {
		return idSubasta;
	}

	public void setIdSubasta(long idSubasta) {
		this.idSubasta = idSubasta;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstadoSubasta() {
		return estadoSubasta;
	}

	public void setEstadoSubasta(String estadoSubasta) {
		this.estadoSubasta = estadoSubasta;
	}

	public String getDescripcionSubasta() {
		return descripcionSubasta;
	}

	public void setDescripcionSubasta(String descripcionSubasta) {
		this.descripcionSubasta = descripcionSubasta;
	}

	public String getImgSubasta() {
		return imgSubasta;
	}

	public void setImgSubasta(String imgSubasta) {
		this.imgSubasta = imgSubasta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
    
    

}
