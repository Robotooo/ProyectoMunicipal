package org.una.proyecto_Municipal.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "colaboradores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Colaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(length = 45, unique = true, nullable = false)
    private String cedula;

    @Column(unique = true, nullable = false)
    private Integer telefono;

    @Column(nullable = false)
    private boolean estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradores")
    private List<Cobro> cobros= new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradores")
//    private List<Bien> bienes= new ArrayList<>();

    @Column(name = "fecha_creacion", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fecha_creacion;

    @Column(name = "fecha_modificacion", nullable = false, updatable = true)
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fecha_modificacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado = true;
        fecha_creacion = new Date();
        fecha_modificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fecha_modificacion = new Date();
    }

}
