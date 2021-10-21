package org.una.proyecto_Municipal.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "propiedades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Propiedad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    private String valorTerreno;

    @Column(name = "valor_construccion", length = 45)
    private String valorConstruccion;

    @Column(name = "valor_otros", length = 45)
    private String valorOtros;

    @Column
    private boolean esEstado;

    @Column
    private boolean estado;

    @Column
    private Integer zona;

    @Column
    private float area;

    @ManyToOne
    @JoinColumn(name="bienes_id")
    private Bien bienId;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propiedadId")
    private List<CategoriaxPropiedad> categoriaxPropiedad = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @PrePersist
    public void prePersist() {
        esEstado = true;
        estado = true;
        fechaRegistro = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }

}