package org.una.proyecto_Municipal.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cobros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Cobro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "facturas_id")
    private Factura facturaId;

    @ManyToOne
    @JoinColumn(name="bienxColaborador_id")
    private BienxColaborador bienxColaborador;

//    @ManyToOne
//    @JoinColumn(name="bienes_id")
//    private BienxColaborador bien;

//    @ManyToOne
//    @JoinColumn(name="colaboradores_id")
//    private BienxColaborador colaborador;

    @Column(name = "monto")
    private double monto;

    @Column(name = "tipo")
    private int tipo;

    @Column(name = "periodo")
    private Integer periodo;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
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