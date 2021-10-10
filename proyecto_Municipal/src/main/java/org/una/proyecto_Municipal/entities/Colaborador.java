package org.una.proyecto_Municipal.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "colaborador")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Colaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(length = 45, unique = true)
    private String cedula;

    @Column(unique = true)
    private Integer telefono;

    @Column
    private boolean estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contribuyente")
    private List<Cobro> cobro = new ArrayList<>();

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fecha_creacion;

    @Column(name = "fecha_modificacion")
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
