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
}
