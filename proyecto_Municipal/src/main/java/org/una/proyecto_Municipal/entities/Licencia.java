package org.una.proyecto_Municipal.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "licencias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Licencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(unique = true)
    private Integer telefono;

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 45, unique = true)
    private String distrito;

    @Column
    private boolean estado;

    @Column
    private BigInteger bien;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fecha_registro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fecha_modificacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado = true;
        fecha_registro = new Date();
        fecha_modificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fecha_modificacion = new Date();
    }

}
