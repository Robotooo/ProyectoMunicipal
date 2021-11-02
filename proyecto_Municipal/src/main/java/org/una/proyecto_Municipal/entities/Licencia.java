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
@Builder
public class Licencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "telefono", unique = true)
    private String telefono;

    @Column(name = "email",length = 50, unique = true)
    private String email;

    @Column(name = "distrito",length = 45)
    private String distrito;

    @ManyToOne
    @JoinColumn(name="bienes_id"/*, insertable = false, updatable = false*/)
    private Bien bienId;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "ganancias")
    private double ganancias;


    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado = true;
        fechaRegistro = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }

}
