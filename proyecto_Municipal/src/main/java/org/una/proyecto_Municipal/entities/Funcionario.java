package org.una.proyecto_Municipal.entities;

import lombok.*;
import javax.persistence.*;
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
    private Long id;

    @Column(name = "usuario", length = 30)
    private String usuario;


    @Column(length = 45, unique = true)
    private String cedula;

    @Column
    private Boolean estado;

    @Column(length = 100, name = "password_encriptado")
    private String passwordEncriptado;

    @ManyToOne
    @JoinColumn(name="roles_id")
    private Rol rol;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
//    private List<Factura> factura = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
//    private List<Transaccion> transaccion= new ArrayList<>();

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
