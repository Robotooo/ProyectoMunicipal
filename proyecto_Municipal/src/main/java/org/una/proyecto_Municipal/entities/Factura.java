package org.una.proyecto_Municipal.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column
    private Double monto_cancelar;

    @ManyToOne
    @JoinColumn(name="cajero_id")
    private Cobro cajero;

    @Column(name = "tipo_pago", length = 45)
    private String tipo_pago;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Cobro> cobro = new ArrayList<>();

    @Column(name = "fecha_cancelacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fecha_cancelacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fecha_cancelacion = new Date();
    }

}
