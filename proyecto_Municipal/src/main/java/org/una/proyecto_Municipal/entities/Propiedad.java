package org.una.proyecto_Municipal.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "propiedades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Propiedad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provincia", length = 45)
    private String provincia;

    @Column(name = "canton", length = 45)
    private String canton;

    @Column(name = "distrito", length = 45)
    private String distrito;

    @Column(name = "direccion", length = 150)
    private String direccion;

    @Column(name = "geolocalizacion", length = 150)
    private String geolocalizacion;

    @Column(name = "plano", length = 45)
    private String plano;

    @Column(name = "metros", length = 45)
    private String metros;

    @Column(name = "valor_terreno", length = 45)
    private String valor_terreno;

    @Column(name = "valor_construccion", length = 45)
    private String valor_construccion;

    @Column(name = "valor_otros", length = 45)
    private String valor_otros;

    @Column
    private boolean es_estado;

    @Column
    private boolean estado;

    @Column
    private Integer zona;

    @Column
    private float area;

//    @Column
//    private Long bien;

    private static final long serialVersionUID = 1L;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fecha_registro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fecha_modificacion;

    @PrePersist
    public void prePersist() {
        es_estado = true;
        estado = true;
        fecha_registro = new Date();
        fecha_modificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fecha_modificacion = new Date();
    }

}