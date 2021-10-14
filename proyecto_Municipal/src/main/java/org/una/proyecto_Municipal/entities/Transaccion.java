package org.una.proyecto_Municipal.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transacciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Transaccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="funcionarios_id")
    private Funcionario usuarioId;

    @Column(name = "accion", length = 150)
    private String accion;

    @Column(name = "objeto", length = 50)
    private String objeto;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();
    }

}