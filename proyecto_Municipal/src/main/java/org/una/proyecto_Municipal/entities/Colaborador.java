package org.una.proyecto_Municipal.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "colaboradores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Colaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "cedula", length = 45, unique = true)
    private String cedula;

    @Column(name = "telefono", length = 45, unique = true)
    private String telefono;

    @Column(name = "estado")
    private boolean estado;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradorId")
//    private List<BienxColaborador> bienxColaborador = new ArrayList<>();

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "colaboradores")
//    private List<Bien> bienes = new ArrayList<>();

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion", updatable = true)
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado = true;
        fechaCreacion = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }

}
