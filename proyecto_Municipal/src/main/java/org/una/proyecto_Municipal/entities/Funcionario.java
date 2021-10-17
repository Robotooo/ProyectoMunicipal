package org.una.proyecto_Municipal.entities;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "funcionarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
    private Long id;

    @Column(name = "usuario", length = 30)
//    @NotNull
    private String usuario;


    @Column(length = 45, unique = true)
//    @NotNull
    private String cedula;

    @Column
//    @NotNull

    private boolean estado;

    @Column(length = 100, name = "password_encriptado")
//    @NotNull
    private String passwordEncriptado;

    @ManyToOne
    @JoinColumn(name="roles_id")
    private Rol rol;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "cajero")
    //private List<Factura> factura = new ArrayList<>();

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    //private List<Transaccion> transaccion= new ArrayList<>();

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
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
