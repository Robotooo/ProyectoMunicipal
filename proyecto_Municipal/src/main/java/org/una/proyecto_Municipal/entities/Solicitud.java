package org.una.proyecto_Municipal.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "solicitudes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Solicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registroId")
    private Long registroId;

    @Column(name = "accion", length = 15)
    private String accion;

    @Column(name = "respuesta")
    private boolean respuesta;

    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="gestor_id")
    private Funcionario gestor;

    @ManyToOne
    @JoinColumn(name="gerente_id")
    private Funcionario gerente;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaSolicitud;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado = true;
        fechaSolicitud = new Date();
    }



}
