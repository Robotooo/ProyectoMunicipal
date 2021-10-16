package org.una.proyecto_Municipal.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cobros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Cobro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="facturas_id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name="colaboradores_id")
    private Colaborador colaboradores;

    @ManyToOne
    @JoinColumn(name="bienes_id")
    private Bien bienId;

    @ManyToOne  //  muchos cobros tienen una factura
    @JoinColumn(name="facturas_id")
    private Factura facturaId;

    @Column
    private Double monto;

    @Column
    private Integer periodo;

    @Column
    private boolean estado;

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